package com.spincity.roulette;

import com.spincity.roulette.bet.BetCalculator;
import com.spincity.roulette.bet.BettingFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

interface SpinCompletionCallback {
    void onSpinComplete(SpinnerNumber pickNumber);
}

public class Spinner extends JPanel implements ActionListener {
    private static final String IMAGE_PREFIX = "./images/Spinner/Roulette-"; // Roulette wheel images filename prefix
    private static final String WAV_FILE = "./images/Spinner/wheel.wav "; // Wheel Sound file (WAV format)
    private static final int NUM_IMAGES = 37; // Number of total images that makes the wheel spin
    private static final int INITIAL_ANIMATION_DELAY = 50; // Initial milliseconds per image
    private static final int MAX_INCREASE_DELAY = 250; // Maximum additional delay per second
    private static final int SPIN_DURATION = 12500; // 12.5 seconds (to match the sound file length)
    private static final int EXIT_DELAY = 10000; // show the winning number for 3 seconds before auto exit the frame
    private static final int[] WHEEL_ORDER = {0, 26, 3, 35, 12, 28, 7, 29, 18, 22, 9, 31, 14, 20, 1, 33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27, 6, 34, 17, 25, 2, 21, 4, 19, 15, 32};


    private int currentImageIndex;
    private Image currentImage;
    private Timer animationTimer;
    private JButton spinButton;
    private Timer spinDurationTimer;
    private boolean isSpinning = false;
    private int elapsedMilliseconds;
    private Clip soundClip;
    private SpinCompletionCallback spinCompletionCallback;


    public void spin(SpinCompletionCallback callback) {
        spinCompletionCallback = callback;
        currentImageIndex = 0;
        currentImage = new ImageIcon(IMAGE_PREFIX + currentImageIndex + ".jpg").getImage();
        currentImageIndex = new Random().nextInt(NUM_IMAGES);

        animationTimer = new Timer(INITIAL_ANIMATION_DELAY, this);

        // Create and add the "Spin" button
        spinButton = new JButton("Spin");
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isSpinning) {
                    // Start the animation and play sound when the button is clicked
                    startSpinning();
                }
            }
        });

        // Create a panel for the button and add it to the frame's bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(spinButton);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Initially, the button is enabled
        spinButton.setEnabled(true);

        // Create a timer for spin duration
        spinDurationTimer = new Timer(SPIN_DURATION, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Stop the animation when the spin duration timer expires
                stopSpinning();
            }
        });
        spinDurationTimer.setRepeats(false); // Only trigger once

        // Load the sound clip
        try {
            File soundFile = new File(WAV_FILE);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            soundClip = AudioSystem.getClip();
            soundClip.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private SpinnerNumber mapToSpinnerNumber(int winningNumber) {
        return SpinnerNumber.values()[winningNumber] ;
    }

    private void startSpinning() {
        // Disable the button
        spinButton.setEnabled(false);
        isSpinning = true;

        // Start the animation timer
        animationTimer.start();

        // Play the wheel ticking sound
        playSound();

        // Start the spin duration timer
        spinDurationTimer.start();
    }

    private void playSound() {
        if (soundClip != null) {
            soundClip.setFramePosition(0);
            soundClip.start();
        }
    }

    private void stopSpinning() {
        // Stop the animation
        animationTimer.stop();

        // Re-enable the "Spin" button
        spinButton.setEnabled(false);
        isSpinning = false;

        // Display the final number
        System.out.println("Stopped at number: " + (currentImageIndex));
        SpinnerNumber winningNumber;

        currentImageIndex = currentImageIndex == 0 ? NUM_IMAGES : currentImageIndex;
        winningNumber = mapToSpinnerNumber(WHEEL_ORDER[currentImageIndex - 1]);
        System.out.println("Winning number temp is: " + winningNumber);

        if (spinCompletionCallback != null) {
            spinCompletionCallback.onSpinComplete(winningNumber);
        }

        // Start the exit timer
        startExitTimer();
    }

    private void startExitTimer() {
        // Exit code
        Timer exitTimer = new Timer(EXIT_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application after 3 seconds once the result is shown
                System.exit(0);
            }
        });
        exitTimer.setRepeats(false); // Only trigger once
        exitTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String imagePath = IMAGE_PREFIX + currentImageIndex + ".jpg"; // Image path
        try {
            currentImage = new ImageIcon(imagePath).getImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        currentImageIndex = (currentImageIndex + 1) % NUM_IMAGES;
        repaint();

        elapsedMilliseconds += animationTimer.getDelay();
        if (elapsedMilliseconds >= 3000) { // 3 seconds have passed, so we will start to slow down
            int newDelay = animationTimer.getDelay() + 3; // Increase the animation delay by 3 milliseconds every second, up to the maximum
            if (newDelay <= MAX_INCREASE_DELAY) {
                animationTimer.setDelay(newDelay);
            }
        }
    }
}



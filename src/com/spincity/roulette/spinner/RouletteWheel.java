package com.spincity.roulette.spinner;

import com.spincity.roulette.utils.Sleep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheel extends JFrame {
    private static final String baseFileName = "./images/Spinner/Roulette-";
    private static final String fileSuffix = ".jpg";

    private final List<ImageIcon> images = new ArrayList<>();
    private final JLabel imageLabel = new JLabel();

    private boolean isSpinning;
    private int currentIndex = 0;
    private int winningNumber;
    private final JButton startButton;
    private static final int[] WHEEL_ORDER = {0, 26, 3, 35, 12, 28, 7, 29, 18, 22, 9, 31, 14, 20, 1, 33, 16, 24, 5, 10, 23, 8, 30, 11, 36, 13, 27, 6, 34, 17, 25, 2, 21, 4, 19, 15, 32};

    public RouletteWheel() {
        super("Spin City Casino");
        setUndecorated(false);

        loadImages();

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setText("Round, round, round she goes, where she stops nobody knows!");
        northPanel.add(label);
        northPanel.setBackground(Color.ORANGE);
        this.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.add(imageLabel);
        imageLabel.setIcon(images.get(0));
        this.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        startButton = new JButton("Spin");
        southPanel.add(startButton);
        southPanel.setBackground(Color.white);
        this.add(southPanel, BorderLayout.SOUTH);

        ButtonListener buttonListener = new ButtonListener();
        startButton.addActionListener(buttonListener);

        setFrameOptions();
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        spin();
        }
    }

    private class Spinner implements Runnable {
        public void run() {
            int click = 0;
            int lastClick = 75 + new Random().nextInt(25);
            int pause = 20;
            winningNumber = WHEEL_ORDER[lastClick % 36];

            while (isSpinning & (click != lastClick)) {
                click++;
                imageLabel.setIcon(images.get(++currentIndex));
                Sleep.sleep(pause += 2);
                if (currentIndex == 36) {  // end of the List, reset index
                    currentIndex = 0;
                }
            }
            synchronized (RouletteWheel.this) {
                RouletteWheel.this.notifyAll();
            }
        }
    }

    public int run() {
        isSpinning = true;
        winningNumber = -1;
        new Thread(new Spinner(), "Spinner");

        synchronized (this) {
            try {
                wait();
                // Schedule the frame to close after 5 seconds
                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RouletteWheel.this.dispose(); // Close the frame
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return winningNumber;
    }

    private void loadImages() {
        for (int i = 0; i <= 36;  i++) {
            images.add(i, new ImageIcon(baseFileName + i + fileSuffix));
        }
    }

    private void spin() {
        isSpinning = true;
        new Thread(new Spinner(), "Spinner").start();
        startButton.setEnabled(false);
    }

//    private static void sleep(long millis) {
//        try { Thread.sleep(millis); }
//        catch (InterruptedException ignored) { }
//    }

    private void setFrameOptions() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
        setSize(640, 750); // 750 if undecorated: false , 720 if true
        setResizable(false);
        toFront();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);  // places it in center of screen
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new RouletteWheel();
//    }

}
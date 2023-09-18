package com.spincity.roulette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen {

    private JFrame frame;
    private JLabel imageLabel;
    private ImageIcon[] imageIcons;
    private int currentImageIndex;
    private Timer timer;

    public SplashScreen() {
        // Initialize the JFrame
        frame = new JFrame();
        frame.setSize(1200, 600);
        frame.toFront();
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        // Load the images into array
        imageIcons = new ImageIcon[2];
        for (int i = 0; i < 2; i++) {
            imageIcons[i] = new ImageIcon("./images/Splash/splash-" + (i + 1) + ".jpg");
        }

        // Initialize the JLabel to display images
        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);

        // Initialize the timer to change images every 200 milliseconds
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the current image index
                currentImageIndex = (currentImageIndex + 1) % imageIcons.length;
                // Set the new image on the JLabel
                imageLabel.setIcon(imageIcons[currentImageIndex]);
            }
        });

        // Start the timer
        timer.start();

        // Schedule the frame to close after 5 seconds
        Timer exitTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame
            }
        });
        exitTimer.setRepeats(false);
        exitTimer.start();
    }

    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

//    public static void main(String[] args) {
//        SplashScreen app = new SplashScreen();
//        app.run();
//    }
}

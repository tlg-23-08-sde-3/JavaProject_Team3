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
    private int numOfImages;
    private boolean needsLoop;
    private int imageFrameTime = 250;

    public SplashScreen(String imageFolderName) {
        // Initialize the JFrame
        frame = new JFrame();

        switch (imageFolderName) {
            case "Welcome":
                numOfImages = 3;
                frame.setSize(1200, 800);
                imageFrameTime = 500;
                break;
            case "Splash":
                needsLoop = true;
                numOfImages = 2;
                frame.setSize(1200, 600);
                break;
            case "Win":
                numOfImages = 7;
                frame.setSize(1200, 686);
                break;
            case "Lost":
                numOfImages = 4;
                frame.setSize(1200, 686);
                break;
            default:
                break;
        }

        frame.toFront();
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        // Load the images into array
        imageIcons = new ImageIcon[numOfImages];
        for (int i = 0; i < numOfImages; i++) {
            imageIcons[i] = new ImageIcon("./images/" + imageFolderName + "/image-" + (i + 1) + ".jpg");
        }

        // Initialize the JLabel to display images
        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);


        if (needsLoop) {
            timer = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update the current image index
                    currentImageIndex = (currentImageIndex + 1) % imageIcons.length;
                    // Set the new image on the JLabel
                    imageLabel.setIcon(imageIcons[currentImageIndex]);
                }
            });

        }
        else {
            timer = new Timer(imageFrameTime, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update the current image index
                    currentImageIndex = (currentImageIndex + 1);
                    // Set the new image on the JLabel
                    if (currentImageIndex == numOfImages) {
                        imageLabel.setIcon(imageIcons[currentImageIndex-1]);
                        timer.stop();
                    }
                    else {
                        imageLabel.setIcon(imageIcons[(currentImageIndex-1)]);
                    }
                }
            });
        }
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

    public static void main(String[] args) {
        SplashScreen app = new SplashScreen("Welcome");
        app.run();
    }
}

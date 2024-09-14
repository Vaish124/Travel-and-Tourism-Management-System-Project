package com.Travel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Destination extends JFrame implements Runnable{
	
	JLabel[] labels;
    Thread th;

    public void run() {
        try {
            for (int i = 0; i < labels.length; i++) {
                if (i > 0) labels[i - 1].setVisible(false);
                labels[i].setVisible(true);
                Thread.sleep(2500); // Adjust the delay as needed
            }
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Destination() {
        // Set frame size and location
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        // Initialize image labels
        labels = new JLabel[10];
        for (int i = 0; i <= 9; i++) {
            ImageIcon icon = loadIcon("/icons/dest" + (i + 1));
            if (icon == null) {
                System.out.println("Image not found: /icons/dest" + (i + 1));
                continue; // Skip this iteration if image is not found
            }
            Image image = icon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            labels[i] = new JLabel(new ImageIcon(image));
            labels[i].setBounds(0, 0, 800, 600);
            add(labels[i]);
            if (i > 0) labels[i].setVisible(false);
        }

        // Start the thread to handle the slideshow
        th = new Thread(this);
        th.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ImageIcon loadIcon(String basePath) {
        String[] extensions = { ".jpg", ".png",".jpeg" };
        for (String ext : extensions) {
            URL imageUrl = getClass().getResource(basePath + ext);
            if (imageUrl != null) {
                return new ImageIcon(imageUrl);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Destination();
    }}

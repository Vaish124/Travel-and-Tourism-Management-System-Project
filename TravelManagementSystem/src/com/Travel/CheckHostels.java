package com.Travel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CheckHostels extends JFrame implements Runnable {

    JLabel[] labels;
    JLabel caption;
    Thread th;

    public void run() {
        String[] captions = {
            "JW Marriott Hotel",
            "Mandarin Oriental Hotel",
            "Four Seasons Hotel",
            "Radisson Hotel",
            "Classio Hotel",
            "The Bay Club Hotel",
            "Breeze Blows Hotel",
            "Quick Stop Hotel",
            "Happy Mornings Motel",
            "Moss View Hotel"
        };

        try {
            for (int i = 0; i < labels.length; i++) {
                if (i > 0) labels[i - 1].setVisible(false);
                labels[i].setVisible(true);
                caption.setText(captions[i]);
                Thread.sleep(2500); // Adjust the delay as needed
            }
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CheckHostels() {
        // Set frame size and location
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        // Initialize caption label
        caption = new JLabel();
        caption.setBounds(50, 500, 700, 50); // Adjusted bounds to fit within the frame
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 30)); // Adjusted font size to fit better
        add(caption);

        // Initialize image labels
        labels = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            URL imageUrl = getClass().getResource("/icons/hotel" + (i + 1) + ".jpg");
            if (imageUrl == null) {
                System.out.println("Image not found: /icons/hotel" + (i + 1) + ".jpg");
                continue; // Skip this iteration if image is not found
            }
            ImageIcon icon = new ImageIcon(imageUrl);
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

    public static void main(String[] args) {
      //  SwingUtilities.invokeLater(() -> new CheckHostels().setVisible(true));
    	new CheckHostels();
    }
}

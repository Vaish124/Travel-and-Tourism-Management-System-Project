package com.Travel;




import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;





public class Splash extends JFrame {
	public Splash(){
		URL imageUrl = getClass().getResource("/icons/splash.jpg"); // Adjust the path as needed

        if (imageUrl == null) {
            System.out.println("Image not found");
            return; // Exit the constructor if image is not found
        }

        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();

        // Desired dimensions
       // int desiredWidth = 1000;
        //int desiredHeight = 500;

        // Scale the image while preserving the aspect ratio
        Image scaledImage = originalImage.getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        add(label);
        setVisible(true);

        //setSize(desiredWidth, desiredHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Splash splash = new Splash();
       // splash.setVisible(true);
        int x=1;
        for(int i=1;i<=500;x+=4,i+=4) {
        	splash.setLocation(750 - (x+i)/2, 400- (i/2));
        	splash.setSize(x+i,i);
        	try {
        		Thread.sleep(10);
        		}catch (Exception e) {}
        	
        }
        
        

	}

}
	
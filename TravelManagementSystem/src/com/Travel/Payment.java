package com.Travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Payment extends JFrame implements ActionListener {
	JButton pay, back;
	Payment(){
		setBounds(500,200,800,600);
		setLocation(300,100);
		setLayout(null);
		
		URL imageUrl = getClass().getResource("/icons/paytm.jpeg");
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();
        Image i2 = originalImage.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        pay = new JButton("Pay");
        pay.setBounds(420, 0,80,40);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(520, 0,80,40);
        back.addActionListener(this);

        image.add(back);
        
        
		
		
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==pay) {
			
		}else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Payment();
		
	}

}

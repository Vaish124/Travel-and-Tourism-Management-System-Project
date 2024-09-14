package com.Travel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Insets;
import java.net.URL;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	String username;
	JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails,checkPackages,bookPackages, bookhotel,
	viewPackages,viewhotels, destinations,viewbookedhotel, payments,calculators,notepad,about;
	   Dashboard(String username) {
	        setBounds(0, 0, 1200, 800); // Minimized size
	        setExtendedState(JFrame.MAXIMIZED_BOTH);
	        setLayout(null);

	        JPanel p1 = new JPanel();
	        p1.setLayout(null);
	        p1.setBackground(new Color(0, 0, 102));
	        p1.setBounds(0, 0, 1300, 50); // Adjusted height
	        add(p1);

	        URL imageUrl = getClass().getResource("/icons/dashboard.png");
	        ImageIcon originalIcon = new ImageIcon(imageUrl);
	        Image originalImage = originalIcon.getImage();
	        Image i2 = originalImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT); // Adjusted size
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(5, 0, 50, 50); // Adjusted bounds
	        p1.add(image);

	        JLabel heading = new JLabel("Dashboard");
	        heading.setBounds(60, 5, 200, 40); // Adjusted bounds
	        heading.setForeground(Color.WHITE);
	        heading.setFont(new Font("Tahoma", Font.BOLD, 24)); // Adjusted font size
	        p1.add(heading);

	        JPanel p2 = new JPanel();
	        p2.setLayout(null);
	        p2.setBackground(new Color(0, 0, 102));
	        p2.setBounds(0, 50, 200, 750); // Adjusted width and height
	        add(p2);

	        addPersonalDetails = new JButton("Add Personal Details");
	        addPersonalDetails.setBounds(0, 0, 200, 40); // Adjusted bounds
	        addPersonalDetails.setBackground(new Color(0, 0, 102));
	        addPersonalDetails.setForeground(Color.WHITE);
	        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        addPersonalDetails.setMargin(new Insets(0, 0, 0, 30)); // Adjusted margin
	        addPersonalDetails.addActionListener(this);
	        p2.add(addPersonalDetails);

	       updatePersonalDetails = new JButton("Update personal Details");
	        updatePersonalDetails.setBounds(0, 40, 200, 40); // Adjusted bounds
	        updatePersonalDetails.setBackground(new Color(0, 0, 102));
	        updatePersonalDetails.setForeground(Color.WHITE);
	        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 20)); // Adjusted margin
	        updatePersonalDetails.addActionListener(this);
	        p2.add(updatePersonalDetails);

	        viewPersonalDetails = new JButton("View Details");
	        viewPersonalDetails.setBounds(0, 80, 200, 40); // Adjusted bounds
	        viewPersonalDetails.setBackground(new Color(0, 0, 102));
	        viewPersonalDetails.setForeground(Color.WHITE);
	        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        viewPersonalDetails.addActionListener(this);
	        p2.add(viewPersonalDetails);

	        JButton deletePersonalDetails = new JButton("Delete Personal Details");
	        deletePersonalDetails.setBounds(0, 120, 200, 40); // Adjusted bounds
	        deletePersonalDetails.setBackground(new Color(0, 0, 102));
	        deletePersonalDetails.setForeground(Color.WHITE);
	        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 20)); // Adjusted margin
	        p2.add(deletePersonalDetails);

	         checkPackages = new JButton("Check Package");
	        checkPackages.setBounds(0, 160, 200, 40); // Adjusted bounds
	        checkPackages.setBackground(new Color(0, 0, 102));
	        checkPackages.setForeground(Color.WHITE);
	        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        checkPackages.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        checkPackages.addActionListener(this);
	        p2.add(checkPackages);

	        bookPackages = new JButton("Book Package");
	        bookPackages.setBounds(0, 200, 200, 40); // Adjusted bounds
	        bookPackages.setBackground(new Color(0, 0, 102));
	        bookPackages.setForeground(Color.WHITE);
	        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        bookPackages.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        bookPackages.addActionListener(this);
	        p2.add(bookPackages);

	        viewPackages = new JButton("View Package");
	        viewPackages.setBounds(0, 240, 200, 40); // Adjusted bounds
	        viewPackages.setBackground(new Color(0, 0, 102));
	        viewPackages.setForeground(Color.WHITE);
	        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        viewPackages.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        viewPackages.addActionListener(this);
	        
	        p2.add(viewPackages);

	         viewhotels = new JButton("View Hotels");
	        viewhotels.setBounds(0, 280, 200, 40); // Adjusted bounds
	        viewhotels.setBackground(new Color(0, 0, 102));
	        viewhotels.setForeground(Color.WHITE);
	        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        viewhotels.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        viewhotels.addActionListener(this);
	        p2.add(viewhotels);

	        bookhotel = new JButton("Book Hotels");
	        bookhotel.setBounds(0, 320, 200, 40); // Adjusted bounds
	        bookhotel.setBackground(new Color(0, 0, 102));
	        bookhotel.setForeground(Color.WHITE);
	        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        bookhotel.setMargin(new Insets(0, 0, 0, 80)); // Adjusted margin
	        bookhotel.addActionListener(this);	       
	        p2.add(bookhotel);

	        viewbookedhotel = new JButton("View Booked Hotel");
	        viewbookedhotel.setBounds(0, 360, 200, 40); // Adjusted bounds
	        viewbookedhotel.setBackground(new Color(0, 0, 102));
	        viewbookedhotel.setForeground(Color.WHITE);
	        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        viewbookedhotel.setMargin(new Insets(0, 0, 0, 50)); // Adjusted margin
	        viewbookedhotel.addActionListener(this);	
	        p2.add(viewbookedhotel);

	         destinations = new JButton("Destinations");
	        destinations.setBounds(0, 400, 200, 40); // Adjusted bounds
	        destinations.setBackground(new Color(0, 0, 102));
	        destinations.setForeground(Color.WHITE);
	        destinations.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        destinations.setMargin(new Insets(0, 0, 0, 70)); // Adjusted margin
	        destinations.addActionListener(this);
	        p2.add(destinations);

	         payments = new JButton("Payments");
	        payments.setBounds(0, 440, 200, 40); // Adjusted bounds
	        payments.setBackground(new Color(0, 0, 102));
	        payments.setForeground(Color.WHITE);
	        payments.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        payments.setMargin(new Insets(0, 0, 0, 80)); // Adjusted margin
	        p2.add(payments);

	        calculators = new JButton("Calculators");
	        calculators.setBounds(0, 480, 200, 40); // Adjusted bounds
	        calculators.setBackground(new Color(0, 0, 102));
	        calculators.setForeground(Color.WHITE);
	        calculators.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        calculators.setMargin(new Insets(0, 0, 0, 80)); // Adjusted margin
	        p2.add(calculators);

	        notepad = new JButton("Notepad");
	        notepad.setBounds(0, 520, 200, 40); // Adjusted bounds
	        notepad.setBackground(new Color(0, 0, 102));
	        notepad.setForeground(Color.WHITE);
	        notepad.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        notepad.setMargin(new Insets(0, 0, 0, 80)); // Adjusted margin
	        p2.add(notepad);

	      about = new JButton("About");
	        about.setBounds(0, 560, 200, 40); // Adjusted bounds
	        about.setBackground(new Color(0, 0, 102));
	        about.setForeground(Color.WHITE);
	        about.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Adjusted font size
	        about.setMargin(new Insets(0, 0, 0, 90)); // Adjusted margin
	        p2.add(about);

	        URL i4 = getClass().getResource("/icons/home.jpg");
	        ImageIcon i5 = new ImageIcon(i4);
	        Image i6 = i5.getImage();
	        Image i7 = i6.getScaledInstance(1300, 800, Image.SCALE_DEFAULT); // Adjusted size
	        ImageIcon i8 = new ImageIcon(i7);
	        JLabel image1 = new JLabel(i8);
	        image1.setBounds(0, 0, 1300, 800); // Adjusted bounds
	        add(image1);

	        JLabel text = new JLabel("Travel and Tourism Management System");
	        text.setBounds(300, 50, 1200, 50); // Adjusted bounds
	        text.setForeground(Color.WHITE);
	        text.setFont(new Font("Raleway", Font.PLAIN, 40)); // Adjusted font size
	        image1.add(text);

	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == addPersonalDetails) {
	            new AddCustomer(username);
	        }else if(ae.getSource()==viewPersonalDetails) {
	        	new ViewCustomer(username);
	        }else if(ae.getSource()== updatePersonalDetails) {
	        	new UpdateCustomer(username);
	        }else if(ae.getSource()==checkPackages ) {
	        	new CheckPackage();
	    }else if(ae.getSource()==bookPackages ) {
        	new BookPackage(username);
    }else if(ae.getSource()==viewPackages ) {
    	new ViewPackage(username);
    }else if(ae.getSource()==viewhotels ) {
    	new CheckHostels();
    }else if(ae.getSource()==destinations ) {
    	new Destination();
   }else if(ae.getSource()==bookhotel ) {
   	new BookHotels(username);
  }else if(ae.getSource()==viewbookedhotel ) {
	   	new ViewBookedHotel(username);
	  }
	    }

	    public static void main(String[] args) {
	        new Dashboard("");
	    }
	}
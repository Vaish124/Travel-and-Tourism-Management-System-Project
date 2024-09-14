package com.Travel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewPackage extends JFrame implements ActionListener {
    
    JButton back;

    ViewPackage(String username) {
        setBounds(400, 100, 850, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 210, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 290, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(330, 360, 100, 25);
        back.addActionListener(this);
        add(back);

        URL imageUrl = getClass().getResource("/icons/bookedDetails.jpg");
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();
        Image i2 = originalImage.getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username= '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }

            query = "select * from bookpackage where username= '" + username + "'";
            rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelprice.setText(rs.getString("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("vaish");
    }
}

package com.Travel;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import javax.swing.*;

public class ViewBookedHotel extends JFrame {
    JButton back;

    ViewBookedHotel(String username) {
        setBounds(400, 200, 1000, 600);
        setLocation(300,100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 400, 30);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30, 90, 150, 25);
        add(lblhotel);

        JLabel labelhotel = new JLabel();
        labelhotel.setBounds(220, 90, 150, 25);
        add(labelhotel);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(330, 450, 100, 25);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        add(back);

        URL imageUrl = getClass().getResource("/icons/bookedDetails.jpg");
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();
        Image i2 = originalImage.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 300);
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

            query = "select * from bookHotel where username= '" + username + "'";
            rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelhotel.setText(rs.getString("hotel"));
                labelpersons.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelprice.setText(rs.getString("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("vaish");
    }
}

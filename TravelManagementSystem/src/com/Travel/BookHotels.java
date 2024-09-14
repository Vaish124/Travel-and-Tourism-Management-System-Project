package com.Travel;

import java.awt.Choice;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookHotels extends JFrame {
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;

    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    BookHotels(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLocation(200, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non-Ac");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username= '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 480, 120, 25);
        add(checkprice);

        bookpackage = new JButton("Book Hotels");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 480, 120, 25);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 480, 120, 25);
        add(back);

        URL imageUrl = getClass().getResource("/icons/book.jpg");
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();
        Image i2 = originalImage.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);

        checkprice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String hotel = chotel.getSelectedItem();
                int costPerPerson = 0;
                int acCost = 0;
                int foodCost = 0;

                try {
                    Conn conn = new Conn();
                    String query = "select costperperson, acroom, foodincluded from hotel where name= '" + hotel + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        costPerPerson = Integer.parseInt(rs.getString("costperperson"));
                        acCost = Integer.parseInt(rs.getString("acroom"));
                        foodCost = Integer.parseInt(rs.getString("foodincluded"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                String acOption = cac.getSelectedItem();
                String foodOption = cfood.getSelectedItem();

                if (acOption.equals("AC")) {
                    costPerPerson += acCost;
                }

                if (foodOption.equals("Yes")) {
                    costPerPerson += foodCost;
                }

                int totalCost = costPerPerson * persons * days;
                labelprice.setText("Rs " + totalCost);
            }
        });

        bookpackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bookHotel(username, hotel, persons, days, ac, food, id, number, phone, price) values('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" + cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')";
                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookHotels("vaish");
    }
}

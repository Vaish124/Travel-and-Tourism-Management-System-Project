package com.Travel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, password;
    JTextField tfusername, tfpassword;
    
    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        URL imageUrl = getClass().getResource("/icons/login.png");
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();
        Image i2 = originalImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblusername.setBounds(60, 20, 100, 25);
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        p2.add(tfusername);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblpassword.setBounds(60, 110, 100, 25);
        p2.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        p2.add(tfpassword);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in login....");
        text.setBounds(270, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                String query = "select * from account where username= '" + username + "' AND password ='" + pass + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
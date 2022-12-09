/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author chamidi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mfirst extends JFrame implements ActionListener{
 
    JButton about, Exit;
    JTextField tfname;
    
    mfirst() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/game.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 500, 500);
        add(image);
        
        JLabel heading = new JLabel("Maths ++");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 55));
        heading.setForeground(new Color(153, 0, 77));
        add(heading);
        
        JLabel name = new JLabel("Enter your Email");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        name.setForeground(new Color(153, 0, 77));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(tfname);
        
        about = new JButton("About");
        about.setBounds(735, 270, 120, 25);
        about.setBackground(new Color(30, 144, 254));
        about.setForeground(Color.WHITE);
        about.addActionListener(this);
        add(about);
        
        Exit = new JButton("Exit");
        Exit.setBounds(915, 270, 120, 25);
        Exit.setBackground(new Color(30, 144, 254));
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        add(Exit);
        
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == about) {
            String name = tfname.getText();
            setVisible(false);
            new mabout(name);
        } else if (ae.getSource() == Exit) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new mfirst();
    }
}


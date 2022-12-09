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

public class mabout extends JFrame implements ActionListener{

    String name;
    JButton start, Exit;
    
    mabout(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Maths ++");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Math game for kid's math skill? How about helping your kids master mathematics with fun" + "<br><br>" +
                "2. Math Games is the perfect way to help child learn math skills the easy way!" + "<br><br>" +
                "3. My educational game for kids is super fun to play and lear!" + "<br><br>" +
                "4. Solve a wide variety of maths problems,learn fun new math tricks to help you master mental math!" + "<br><br>" +
                "5. All of these math games are free to enjoy,and they're subitable for all ages,from kids to adults." + "<br><br>" +
                
            "<html>"
        );
        add(rules);
        
        Exit = new JButton("Exit");
        Exit.setBounds(250, 500, 100, 30);
        Exit.setBackground(new Color(30, 144, 254));
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        add(Exit);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new mquiz(name);
        } else {
            setVisible(false);
            new mfirst();
        }
    }
    
    public static void main(String[] args) {
        new mabout("User");
    }
}


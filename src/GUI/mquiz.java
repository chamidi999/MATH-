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

public class mquiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    mquiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz (1).jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(question);
        
        questions[0][0] = "Combine terms: 12a + 26b -4b – 16a.?";
        questions[0][1] = "-4a + 22b";
        questions[0][2] = "-28a + 30b";
        questions[0][3] = "4a + 22b";
        questions[0][4] = "28a + 30b";

        questions[1][0] = "What is |-26|?";
        questions[1][1] = "26";
        questions[1][2] = "0";
        questions[1][3] = "26";
        questions[1][4] = "1";

        questions[2][0] = "Simplify: (4 – 5) – (13 – 18 + 2).?";
        questions[2][1] = "2";
        questions[2][2] = "-1";
        questions[2][3] = "1";
        questions[2][4] = "-2";

        questions[3][0] = "Factor: 3y(x – 3) -2(x – 3)?";
        questions[3][1] = "(x – 3)(x – 3)";
        questions[3][2] = "(x – 3)(x – 1)";
        questions[3][3] = "(x – 3)(3y – 2)";
        questions[3][4] = "(x – 6)(x – 3)";

        questions[4][0] = "Solve for x: 2x – y = (3/4)x + 6.?";
        questions[4][1] = "(y + 6)/5";
        questions[4][2] = "4(y + 6)/5";
        questions[4][3] = "(y + 6)";
        questions[4][4] = "4(y - 6)/5";

        questions[5][0] = "Find the value of 3 + 2 • (8 – 3)?";
        questions[5][1] = "13";
        questions[5][2] = "25";
        questions[5][3] = "45";
        questions[5][4] = "22";

        questions[6][0] = "20+(90÷2) is equal to?";
        questions[6][1] = "65";
        questions[6][2] = "55";
        questions[6][3] = "66";
        questions[6][4] = "44";

        questions[7][0] = "The product of 82 and 5 is?";
        questions[7][1] = "510";
        questions[7][2] = "410";
        questions[7][3] = "310";
        questions[7][4] = "462";

        questions[8][0] = "The product of 121 x 0 x 200 x 25 is?";
        questions[8][1] = "0";
        questions[8][2] = "1500";
        questions[8][3] = "None of these";
        questions[8][4] = "4000";

        questions[9][0] = "50 times of 8 is equal to?";
        questions[9][1] = "400";
        questions[9][2] = "500";
        questions[9][3] = "630";
        questions[9][4] = "285";
        
        answers[0][1] = "-4a + 22b";
        answers[1][1] = "26";
        answers[2][1] = "2";
        answers[3][1] = "(x – 3)(3y – 2)";
        answers[4][1] = "4(y + 6)/5";
        answers[5][1] = "13";
        answers[6][1] = "65";
        answers[7][1] = "410";
        answers[8][1] = "0";
        answers[9][1] = "400";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.BOLD, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.BOLD, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.BOLD, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.BOLD, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Times New Roman", Font.BOLD, 24));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 24));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new mscore(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new mscore(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new mquiz("User");
    }
}

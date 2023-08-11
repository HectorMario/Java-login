package com.htperez.logic;

import com.htperez.conection.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface  {
    private Database database;
    private JFrame frame;
    private JTextField textUsername;
    private JButton button1;
    private JButton button2;
    private JTextArea textArea1;
    private JPanel loginPanel;
    private JPasswordField txtPassword;


    public Interface() {
        database = new Database();
        button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            txtPassword.setText("");
            textUsername.setText("");
            textArea1.setText("");
        }
    });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String password = txtPassword.getText();
                String username =textUsername.getText();
                System.out.println(password);
                String message = database.conection(username,password);
                if (message != ""){
                    textArea1.setText(message);
                }
            }
        });
    }
public void setVisible(){

    frame =  new JFrame();
    frame.setSize(400, 350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.add(loginPanel);
}
}

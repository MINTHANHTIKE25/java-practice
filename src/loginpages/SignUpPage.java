package loginpages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends MainPage implements ActionListener {
    Button button = new Button("Submit");
    TextField textFieldname;
    TextField textFieldpassword;
    TextField textFieldage;
    TextField textFieldemail;
    TextField textFieldstreet;
    TextField textFieldcity;

    void signpage_layout() {
        frame.setTitle("SignUp");
        for (int i = 0; i < 6; i++) {
            int x = 10;
            int y = 40;
            int lwidth = 70;
            int lheight = 30;
            Label label = new Label();

            switch (i) {
                case 0 -> {
                    textFieldname = new TextField();
                    label.setText("Your name :");
                    label.setBounds(x, y, lwidth+15, lheight);
                    textFieldname.setBounds(x+15 + lwidth + 5, y, lwidth+45, lheight);
                    frame.add(label);
                    frame.add(textFieldname);
                    break;
                }
                case 1 -> {
                    textFieldage = new TextField();
                    label.setText("Your age :");
                    label.setBounds(x, y + lheight + 15, lwidth+15, lheight);
                    textFieldage.setBounds(x + lwidth + 20, y * 2, lwidth, lheight);
                    frame.add(label);
                    frame.add(textFieldage);
                    break;
                }
                case 2 -> {
                    textFieldemail = new TextField();
                    label.setText("Your email :");
                    label.setBounds(x, y + (lheight * 2 + 30), lwidth+15, lheight);
                    textFieldemail.setBounds(x + lwidth + 20, (y * 3) + 10, lwidth + 100, lheight);
                    frame.add(label);
                    frame.add(textFieldemail);
                    break;
                }
                case 3 -> {
                    textFieldpassword = new TextField();
                    label.setText("Your password :");
                    label.setBounds(x, lheight * 4 + y + 10, lwidth+15, lheight);
                    textFieldpassword.setBounds(x + lwidth + 20, lheight * 3 + y * 2, lwidth+50, lheight);
                    frame.add(label);
                    frame.add(textFieldpassword);
                    break;
                }
                case 4 -> {
                    textFieldcity = new TextField();
                    label.setText("Your street :");
                    label.setBounds(x, lheight * 5 + y + 20, lwidth+15, lheight);
                    textFieldcity.setBounds(x + lwidth + 20, lheight * 4 + y * 2 + 10, lwidth + 100, lheight);
                    frame.add(label);
                    frame.add(textFieldcity);
                    break;
                }
                case 5 -> {
                    textFieldstreet = new TextField();
                    label.setText("Your city :");
                    label.setBounds(x, lheight * 6 + y + 25, lwidth+15, lheight);
                    textFieldstreet.setBounds(x + lwidth + 20, lheight * 5 + y * 2 + 20, lwidth, lheight);
                    frame.add(label);
                    frame.add(textFieldstreet);
                    break;
                }
            }
        }
        button.setBounds(10, 435, 70, 50);
        button.setBackground(new Color(100,100,100));
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textFieldname.getText();
        int age = Integer.parseInt(textFieldage.getText());
        String street = textFieldstreet.getText();
        String email = textFieldemail.getText();
        String password = textFieldpassword.getText();
        String city = textFieldcity.getText();
        if (name != null & age != 0 & street != null & email != null & city != null & password != null) {
            ConnectToDatabase connect = new ConnectToDatabase();
            if (!connect.checkfromdatabase1(name, email)) {
                connect.inserting(name, email, age, city, street, password);
                JOptionPane.showMessageDialog(frame, "Signup successful:");
                textFieldstreet.setText(null);
                textFieldcity.setText(null);
                textFieldpassword.setText(null);
                textFieldemail.setText(null);
                textFieldage.setText(null);
                textFieldname.setText(null);
            } else {
                JOptionPane.showMessageDialog(frame, "Your name is already exist.");
                textFieldstreet.setText(null);
                textFieldcity.setText(null);
                textFieldpassword.setText(null);
                textFieldemail.setText(null);
                textFieldage.setText(null);
                textFieldname.setText(null);
            }
        } else {
            System.out.println("ha ha");
        }
    }

    public static void main(String[] args) {
        new SignUpPage().signpage_layout();
    }
}

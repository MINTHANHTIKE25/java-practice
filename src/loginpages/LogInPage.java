package loginpages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends MainPage implements ActionListener {
    Button button = new Button("Submit");
    Label label, label2;
    TextField textFieldemail;
    TextField textFieldpassword;

    void logpage_layout() {
        frame.setTitle("LogIn");
        label = new Label("Your email :");
        label.setBounds(210, 300, 160, 30);
        textFieldemail = new TextField();
        textFieldemail.setBounds(170, 330, 160, 30);
        label2 = new Label("Your password:");
        label2.setBounds(210, 355, 160, 30);
        textFieldpassword = new TextField();
        textFieldpassword.setBounds(170, 385, 160, 30);
        frame.add(label);
        frame.add(textFieldemail);
        frame.add(label2);
        frame.add(textFieldpassword);
        button.setBounds(200, 450, 100, 50);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String useremail = textFieldemail.getText();
        String userpassword = textFieldpassword.getText();
        if (userpassword != null & useremail != null) {
            ConnectToDatabase connect = new ConnectToDatabase();
            if (connect.checkfromdatabase(useremail, userpassword)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                textFieldpassword.setText(null);
                textFieldemail.setText(null);
            }else{
                JOptionPane.showMessageDialog(frame, "LogIn fail.Try again.");
                textFieldemail.setText(null);
                textFieldpassword.setText(null);
            }
        }else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new LogInPage().logpage_layout();
    }
}

package loginpages;

import java.awt.*;

abstract class framing {
    Frame frame = designing_frame();

    Frame designing_frame() {
        Frame frame1 = new Frame();
        frame1.setSize(600, 1000);
        frame1.setBackground(new Color(50,80,100));
        frame1.setVisible(true);
        frame1.setLayout(null);
        return frame1;
    }
}

interface Createable {
    void layout_design();
}

public class MainPage extends framing {
    void creating_layout(Createable creatingLayout) {
        creatingLayout.layout_design();
    };

    void signuppage() {
        creating_layout(() -> {
            Button button = new Button("Click to enter the signup page:");
            button.setBounds(170, 340, 160, 60);
            button.setBackground(Color.white);
            frame.add(button);
            button.addActionListener(e -> {
                SignUpPage.main(null);
            });
        });
    }

    void loginpage() {
        creating_layout(() -> {
            Button button = new Button("Click to enter login page:");
            button.setBounds(170, 420, 160, 60);
            button.setBackground(Color.white);
            frame.add(button);
            button.addActionListener(e -> {
                LogInPage.main(null);
            });
        });
    }

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        mainPage.frame.setTitle("Main ");
        mainPage.loginpage();
        mainPage.signuppage();
    }
}

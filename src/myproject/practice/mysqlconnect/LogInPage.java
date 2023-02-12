package myproject.practice.mysqlconnect;

import java.util.Scanner;

public class LogInPage {
    protected static final String user_email = "[a-zA-Z0-9_]{3,40}" + "@" + "gmail" + "['\'.]" + "com";
    protected static final String password = "[a-zA-Z0-9].{7,15}";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to sign up");
        System.out.println("Enter 2 to log-in");
        int main_in = scanner.nextInt();
        scanner.nextLine();
        if (main_in == 1) {
            System.out.println("!Welcome from sign up");
            int i = 0;
            while (true) {
                String name="";
                while (true) {
                    System.out.println("Enter your name :");
                    name = scanner.nextLine();
                    if (ManipulateData.checking(name)){
                        continue;
                    }else {
                        break;
                    }

                }
                String inemail="";
                while (true){
                    System.out.println("Enter your email :");
                    inemail = scanner.nextLine();
                    if (ManipulateData.checking_email(inemail)){
                        continue;
                    }else {
                        break;
                    }
                }
                System.out.println("Enter your password :");
                String inpass = scanner.nextLine();
                System.out.println("Enter your confirm password :");
                String conpass = scanner.nextLine();
                if (!ManipulateData.checking(name)) {
                    if (inemail.matches(user_email) & inpass.matches(password) & (inpass.equals(conpass))) {
                        ManipulateData.input_database(name, inemail, inpass);
//                    try {
//                        Connection connection = DriverManager.getConnection(Utils.url, Utils.user, Utils.pass);
//                        Statement statement = connection.createStatement();
//                        statement.executeUpdate("insert into users(username,email,password)values(\'" + name + "\',\'" + inemail + "\',\'" + inpass + "\')");
//                    } catch (SQLException ignored) {
//
//                    }
                        break;
                    }
                    if (!inemail.matches(user_email)) {
                        System.out.println("Your email is out of format.");
                    }
                    if (!inpass.equals(conpass)) {
                        System.out.println("Your password is not same:");
                    }
                    if (!inpass.matches(password)) {
                        System.out.println("Your password format is wrong:");
                    }
                }else {
                    continue;
                }
            }
        } else if (main_in == 2) {
            System.out.println("!Welcome from login!");

            for (int i = 0; i < 5; i++) {
                System.out.println("Enter your email :");
                String log_email = scanner.nextLine();
                System.out.println("Enter your password :");
                String log_pass = scanner.nextLine();
                if (log_email.matches(user_email) & log_pass.matches(password)) {
                    ManipulateData.checking(log_email, log_pass);
//                    try {
//                        Connection connection = DriverManager.getConnection(Utils.url, Utils.user, Utils.pass);
//                        Statement statement = connection.createStatement();
//                        ResultSet resultSet = statement.executeQuery("select email,password from users");
//                        while (resultSet.next()) {
//                            if (resultSet.getString("email").equals(log_email) & resultSet.getString("password").equals(log_pass)) {
//                                System.out.println("Log-in successful");
//                                break;
//                            } else {
//                                continue;
//                            }
//                        }
//                    } catch (SQLException ignored) {
//                    }
                    break;
                } else {
                    continue;
                }

            }

        }

    }

}

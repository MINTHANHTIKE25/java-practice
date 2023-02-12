package myproject.practice.mysqlconnect;

import java.sql.*;

public class ManipulateData {
    protected static final String url="assign_practice";
    protected static final String user="root";
    protected static final String pass="";
    protected static void input_database(String name,String inemail,String inpass){
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users(username,email,password)values(\'" + name + "\',\'" + inemail + "\',\'" + inpass + "\')");
        } catch (SQLException ignored) {

        }
    }
    protected static void checking(String log_email,String log_pass){
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email,password from users");
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(log_email) & resultSet.getString("password").equals(log_pass)) {
                    System.out.println("Log-in successful");
                    break;
                } else {
                    continue;
                }
            }
        } catch (SQLException ignored) {
        }
    }
    protected static boolean checking(String username){
        boolean result=true;
        try {
            Connection connection = DriverManager.getConnection(url,user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username from users");
            while (resultSet.next()){
                if (resultSet.getString("username").equals(username)){
                    System.out.println("Ur name exist in our database");
                    result=true;
                    break;
                }else {
                    result=false;
                    continue;
                }
            }
        }catch (SQLException ignored){
        }
    return result;
    }
    protected static boolean checking_email(String email){
        boolean result=true;
        try {
            Connection connection = DriverManager.getConnection(url, user,pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email from users");
            while (resultSet.next()){
                if (resultSet.getString("email").equals(email)){
                    System.out.println("Ur email exist in our database");
                    result=true;
                    break;
                }else {
                    result=false;
                    continue;
                }
            }
        }catch (SQLException ignored){
        }
        return result;
    }
}

package loginpages;

import java.sql.*;

public class ConnectToDatabase {
    String url = "jdbc:mysql://localhost:3306/my_practice";
    String user = "root";
    String password = "";

    void inserting(String name, String email, int age, String city, String street, String userpassword) {
        //loading the mysql server
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            return;
        }
        //connection to database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String checking = "";
        String insert = "insert into user_record(username,age,password,email,street,city) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        //inserting to database;
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, userpassword);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, street);
            preparedStatement.setString(6, city);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        //closing the mysql
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

    void creating() {
        //load the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        //connection to database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        String create = "create table user_record(users_id int(12) not null auto_increment," +
                "username varchar(255) not null," +
                "age int(12) not null," +
                "password varchar(255) not null," +
                "email varchar(255) not null," +
                "street varchar(255) not null,city varchar(255) not null,primary key (users_id))";
        //creating table
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(create);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        //closing connection
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean checkfromdatabase(String inuseremail, String inuserpassword) {
        boolean result = true;
        //loading database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        //connecting database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //selecting database
        String selectSql = "select email,password from user_record";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(inuseremail) & resultSet.getString("password").equals(inuserpassword)) {
                     result=true;
                     break;
                }else {
                    result=false;
                    continue;
                }
            }
        } catch (SQLException ignored) {
        }
        return result;
    }

    boolean checkfromdatabase1(String inusername, String inuseremail) {
        boolean result = true;
        //loading database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        //connecting database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //selecting database
        String selectSql = "select username,email from user_record";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(inusername) || resultSet.getString("email").equals(inuseremail)) {
                    result = true;
                    break;
                } else {
                    result = false;
                    continue;
                }
            }
        } catch (SQLException ignored) {
        }
        return result;
    }
//    public static void main(String[] args) {
////        new ConnectToDatabase().creating();
//    }
}

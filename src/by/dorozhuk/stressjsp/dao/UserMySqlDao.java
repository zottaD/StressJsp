package by.dorozhuk.stressjsp.dao;

import by.dorozhuk.stressjsp.connections.MySqlConnector;
import by.dorozhuk.stressjsp.entity.User;

import java.sql.*;

public class UserMySqlDao {
    public static User login(User user) {
        try(Connection connection = MySqlConnector.getConnection()){
            String username = user.getUsermane();
            String pass = user.getPass();
// http://www.javaportal.ru/java/tutorial/tutorialJDBC/preparedstatement.html for queries with params
            String sql = "SELECT * FROM users WHERE username='" + username +
                    "' AND pass='" + pass + "'";

            System.out.println("User name is " + username);
            System.out.println("Password is " + pass);
            System.out.println("Query: "+ sql);

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            boolean isNotEmpty = result.next();

            if (!isNotEmpty){
                System.out.println("not registered");
                user.setValid(false);
            } else {
                String firstName = result.getString("firstname");
                String lastname = result.getString("lastname");
                String email = result.getString("email");

                System.out.println("Darova" + firstName);
                user.setFirstname(firstName);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setValid(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void Registration(User user){
        try(Connection connection = MySqlConnector.getConnection()){
            String username = user.getUsermane();
            String pass = user.getPass();
            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            String email = user.getEmail();

            boolean isDupl = false;

            Statement statement = connection.createStatement();
//             you can select user by name without loop in java
            ResultSet resultSet = statement.executeQuery("SELECT username, email FROM users");
            while (resultSet.next()){
                if (resultSet.getString("username").equals(username)){
                    user.setValid(true);
                }
                if (resultSet.getString("email").equals(email)){
                    user.setDupl(true);
                }
            }
            if (!user.isDupl() && !user.isValid()){
                String sql = "INSERT INTO users (username, pass, firstname, lastname, email) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, firstname);
                preparedStatement.setString(4, lastname);
                preparedStatement.setString(5, email);
                preparedStatement.execute();
                System.out.println("zaregano");
            } else {
                System.out.println("login or pass dupl");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

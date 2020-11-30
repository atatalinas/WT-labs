package dao.impl;

import com.mysql.cj.jdbc.Driver;
import dao.DaoException;
import dao.UserDAO;
import entity.InvalidUserTypeException;
import entity.User;
import entity.UserData;

import java.sql.*;

import static entity.UserType.fromInt;

public class SQLUserDAO implements UserDAO {
    private static final String url = "jdbc:mysql://localhost:3306/auto?useUnicode=true&serverTimezone=UTC";
    private static Statement statement = null;

    static {
        final String userName = "user";
        final String password = "password";
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User authentification(String login, String password) throws DaoException {

        final String query = "SELECT id, name, login, password, email, phone_number, user_type from users where login = '" + login + "';";
        try {
            ResultSet result = statement.executeQuery(query);
            result.next();
            if (result.getString("password").equals(password))
                return new User(result.getInt("id"),
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("email"),
                        result.getString("phone_number"),
                        fromInt(result.getInt("user_type")));
            else
                return null;
        } catch (SQLException | InvalidUserTypeException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean registration(UserData userData) throws DaoException {
        try {
            final String query = new StringBuilder("INSERT INTO users (name, login, password, email, phone_number, user_type) VALUES (")
                    .append("'").append(userData.getName()).append("',")
                    .append("'").append(userData.getLogin()).append("',")
                    .append("'").append(userData.getPassword()).append("',")
                    .append("'").append(userData.getEmail()).append("',")
                    .append("'").append(userData.getPhoneNumber()).append("',")
                    .append("'").append(userData.getUserType().toInt()).append("');").toString();
            statement.execute(query);
            System.out.println("Got it!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        }
    }
}

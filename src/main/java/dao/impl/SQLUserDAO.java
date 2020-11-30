package dao.impl;

import dao.DaoException;
import dao.UserDAO;
import entity.User;
import entity.UserData;

import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

    @Override
    public User authentification(String login, String password)  throws DaoException {

        try {
            throw new SQLException();
        }catch (SQLException e) {
            throw new DaoException(e);
        }

        //return null;
    }

    @Override
    public boolean registration(UserData userData) throws DaoException {
        try {
            throw new SQLException();
        }catch (SQLException e) {
            throw new DaoException(e);
        }

        //return null;
    }
}

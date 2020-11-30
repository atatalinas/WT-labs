package dao;

import entity.User;
import entity.UserData;

public interface UserDAO {

    User authentification (String login, String password) throws DaoException;

    boolean registration (UserData userData) throws DaoException;


}
package dao;

import dao.impl.SQLUserDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();


    private DAOProvider () {}

    public UserDAO getUserDAO() {
        return userDAO;
    }

       public static DAOProvider getInstance() {
        return instance;
    }

}
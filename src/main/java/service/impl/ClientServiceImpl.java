package service.impl;

import dao.DAOProvider;
import dao.DaoException;
import dao.UserDAO;
import entity.User;
import entity.UserData;
import service.ClientService;
import service.ServiceException;
import service.validation.CredentialsValidator;

public class ClientServiceImpl implements ClientService{

    @Override
    public User authorization(String login, String password) throws ServiceException {

        if(!CredentialsValidator.isCorrect(login, password)) {
            throw new ServiceException("message");

        }

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        User user = null;

        try {
            user = userDAO.authentification(login, password);
        }catch (DaoException e){
            throw new ServiceException(e);
        }

        return user;
    }


    @Override
    public boolean registration(UserData user) throws ServiceException{

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            return userDAO.registration(user);
        }catch (DaoException e){
            throw new ServiceException(e);

        }

    }
}
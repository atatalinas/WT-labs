package service;

import entity.User;
import entity.UserData;

public interface ClientService {

    User authorization (String login, String password) throws ServiceException;

    boolean registration (UserData user) throws ServiceException;
}
package controller.command.impl;

import controller.command.Command;
import entity.InvalidUserTypeException;
import entity.UserData;
import entity.UserType;
import service.ClientService;
import service.ServiceException;
import service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PARAMETER_NAME = "name";
    private static final String PARAMETER_PHONE_NUMBER = "phone_number";
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_USER_TYPE = "user_type";


    private static final String AUTH_PAGE = "/SignIn.jsp";
    private static final String REGISTRATION_PAGE = "/SignUp.jsp";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login;
        String password;
        String email;
        String name;
        String phoneNumber;
        UserType userType;
        login = request.getParameter(PARAMETER_LOGIN);
        password = request.getParameter(PARAMETER_PASSWORD);
        email = request.getParameter(PARAMETER_EMAIL);
        name = request.getParameter(PARAMETER_NAME);
        phoneNumber = request.getParameter(PARAMETER_PHONE_NUMBER);
        try {
            userType = UserType.fromString(request.getParameter(PARAMETER_USER_TYPE));
        } catch (InvalidUserTypeException e) {
            e.printStackTrace();
            userType = null;
        }
        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService service = provider.getClientService();

        UserData userData = new UserData();

        String page;
        int create;

        userData.setName(name);
        userData.setPhoneNumber(phoneNumber);
        userData.setEmail(email);
        userData.setLogin(login);
        userData.setPassword(password);
        userData.setUserType(userType);
        try {
            boolean result = service.registration(userData);
            request.setAttribute("login", login);
            page = AUTH_PAGE;

        } catch (ServiceException e) {
            request.setAttribute("error", "Error. Try again!");
            page = REGISTRATION_PAGE;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}

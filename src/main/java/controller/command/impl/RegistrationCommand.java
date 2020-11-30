package controller.command.impl;

import controller.command.Command;
import entity.UserData;
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
    private static final String PARAMETER_SURNAME = "surname";
    private static final String PARAMETER_EMAIL = "email";



    private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
    private static final String INDEX_PAGE = "/index.jsp";
    private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";
    private static final String USER_PAGE = "/WEB-INF/jsp/userPage.jsp";



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login;
        String password;
        String email;
        String name;
        String surname;

        login = request.getParameter(PARAMETER_LOGIN);
        password = request.getParameter(PARAMETER_PASSWORD);
        email = request.getParameter(PARAMETER_EMAIL);
        name = request.getParameter(PARAMETER_NAME);
        surname = request.getParameter(PARAMETER_SURNAME);

        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService service = provider.getClientService();

        UserData userData = new UserData();

        String page;
        int create;

        userData.setName(name);
        userData.setSurname(surname);
        userData.setEmail(email);
        userData.setLogin(login);
        userData.setPassword(password);

        try {
            boolean result = service.registration(userData);
            page = "stub";
            //to do

        } catch (ServiceException e) {
            request.setAttribute("error", "Error. Try again!");
            page = REGISTRATION_PAGE;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}

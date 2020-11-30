package controller.command.impl;


import controller.command.Command;
import entity.User;
import service.ClientService;
import service.ServiceException;
import service.ServiceProvider;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorizationCommand implements Command {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    private static final String MAIN_PAGE = "/main.jsp";
    private static final String DEFAULT_PAGE = "/SignIn.jsp";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;

        login = request.getParameter(PARAMETER_LOGIN);
        password = request.getParameter(PARAMETER_PASSWORD);

        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService service = provider.getClientService();

        User user = null;
        String page;

        try {

            user = service.authorization(login, password);

            if (user==null) {
                request.setAttribute("error", "login or password error");
                page = DEFAULT_PAGE;
            }else {
                request.setAttribute("user", user);
                page = MAIN_PAGE;
            }

        } catch (ServiceException e) {
            request.setAttribute("error", "login or password error");
            page = DEFAULT_PAGE;
            // log
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
package ua.mieshkov.ivan.controller.filter;


import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import ua.mieshkov.ivan.model.entities.User;
import ua.mieshkov.ivan.model.exception.IncorrectDataInputException;
import ua.mieshkov.ivan.model.exception.LoginAlreadyExistsException;
import ua.mieshkov.ivan.model.services.UserRegistrationService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.mieshkov.ivan.string.container.RegexContainer.*;
import static ua.mieshkov.ivan.string.container.StringContainer.*;

public class RegistrationFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(RegistrationFilter.class.getSimpleName());
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding(encoding);

        final String nameUkr = request.getParameter("userNameUkr");
        final String nameEn = request.getParameter("userNameEn");
        final String login = request.getParameter("userLogin");
        final String password = request.getParameter("userPassword");
        final String gender = request.getParameter("userGender");
        final String email = request.getParameter("userEmail");

        try {
            checkByRegex(nameUkr, UKR_NAME_REGEX, USER_NAME_UKR_INCORRECT);
            checkByRegex(nameEn, LAT_NAME_REGEX, USER_NAME_LAT_INCORRECT);
            checkByRegex(login, LOGIN_PASSWORD_REGEX, LOGIN_INCORRECT);
            checkByRegex(password, LOGIN_PASSWORD_REGEX, PASSWORD_INCORRECT);
            checkByRegex(email, EMAIL_REGEX, EMAIL_INCORRECT);

        } catch (IncorrectDataInputException e) {
            request.setAttribute("warning", e.getMessage());
            LOGGER.error("Incorrect input data on registration page");
            request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
        }

        final String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(nameUkr, nameEn, login, hashPassword,
                gender, email, CLIENT_ROLE);

        try {
            new UserRegistrationService().register(user);
        } catch (LoginAlreadyExistsException e) {
            request.setAttribute("warning", LOGIN_EXISTS);
            LOGGER.warn("Attempt to register already registered user");
            request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
        }

        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    @Override
    public void destroy() {
    }

    private void checkByRegex(String dataToCheck, String regex,
                              String warning) throws IncorrectDataInputException {
        if(!dataToCheck.matches(regex)) {
            throw new IncorrectDataInputException(warning);
        }
    }
}
package ua.mieshkov.ivan.controller.command;

import javax.servlet.http.HttpServletRequest;

import static ua.mieshkov.ivan.string.container.StringContainer.LOGIN_PAGE;

public class Login implements Command{
    @Override
    public String execute(HttpServletRequest req) {
        return LOGIN_PAGE;
    }

    @Override
    public boolean checkRole(String role) {
        return true;
    }

}

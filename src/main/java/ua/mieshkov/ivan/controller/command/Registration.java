package ua.mieshkov.ivan.controller.command;

import javax.servlet.http.HttpServletRequest;

import static ua.mieshkov.ivan.string.container.StringContainer.REGISTRATION_PAGE;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return REGISTRATION_PAGE;
    }

    @Override
    public boolean checkRole(String role) {
        return true;
    }
}
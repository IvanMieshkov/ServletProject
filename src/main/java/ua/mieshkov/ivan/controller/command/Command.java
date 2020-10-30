package ua.mieshkov.ivan.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest req);

    boolean checkRole(String role);
}

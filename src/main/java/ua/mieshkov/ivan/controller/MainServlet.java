package ua.mieshkov.ivan.controller;

import ua.mieshkov.ivan.controller.command.Command;
import ua.mieshkov.ivan.controller.command.Login;
import ua.mieshkov.ivan.controller.command.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put("registration", new Registration());
        commands.put("login", new Login());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();
        path = path.replaceAll(".*/", "");
        path = path.replaceAll("\\?*", "");

        String role = (String) req.getSession().getAttribute("role");

        Command command = commands.getOrDefault(path, commands.get("menu"));
        String page;
        if(command.checkRole(role)) {
            page = command.execute(req);
        } else {
            page = "view/errors/error403.jsp";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

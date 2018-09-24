package com.gmail.rogov.controller;

import com.gmail.rogov.controller.command.impl.LoginCommand;
import com.gmail.rogov.controller.command.impl.UsersCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gmail.rogov.controller.command.Command;
import com.gmail.rogov.controller.command.impl.ItemsCommand;
import com.gmail.rogov.controller.model.CommandEnum;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    final Logger logger = LogManager.getLogger(DispatcherServlet.class);

    private static final Map<CommandEnum, Command> commands = new HashMap<>();

    @Override
    public void init() {
        logger.debug("DispatcherServlet init!");
        commands.put(CommandEnum.LOGIN, new LoginCommand());
        commands.put(CommandEnum.USERS, new UsersCommand());
        commands.put(CommandEnum.ITEMS, new ItemsCommand());
    }

    @Override
    public void destroy() {
        logger.debug("DispatcherServlet destroy!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("command");
        Command commandAction = null;
        try {
            commandAction = commands.get(CommandEnum.getCommand(command));
        } catch (IllegalArgumentException e) {
            logger.error("Errore: ", e);

        }
        if (commandAction != null) {
            try {
                String page = commandAction.execute(request, response);
                if (page != null) {
                    getServletContext().getRequestDispatcher(page).forward(request, response);
                }
            } catch (Exception e) {
                logger.error("Errore: ", e);

            }
        } else {
            logger.debug("Command " + command + " does not exists!");
        }
    }
}

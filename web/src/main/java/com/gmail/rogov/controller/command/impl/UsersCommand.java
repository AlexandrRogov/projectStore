package com.gmail.rogov.controller.command.impl;


import com.gmail.rogov.dao.config.HibernateConfigurationManager;
import com.gmail.rogov.service.UserService;
import com.gmail.rogov.service.impl.UserServiceImpl;
import com.gmail.rogov.service.model.UserDTO;
import com.gmail.rogov.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<UserDTO> users = userService.findAll();
        request.setAttribute("users", users);
        return HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.USERS_PAGE_PATH);

    }
}

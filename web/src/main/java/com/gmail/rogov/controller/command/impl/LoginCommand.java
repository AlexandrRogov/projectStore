package com.gmail.rogov.controller.command.impl;

import com.gmail.rogov.dao.config.HibernateConfigurationManager;
import com.gmail.rogov.service.UserService;
import com.gmail.rogov.service.impl.UserServiceImpl;
import com.gmail.rogov.service.model.UserDTO;
import com.gmail.rogov.controller.command.Command;
import com.gmail.rogov.controller.util.UserPrincipalConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && !email.equals("")) {
            UserDTO userByUsername = userService.findUserByEmail(email);
            if (userByUsername != null) {
                if (userByUsername.getPassword().equals(password.trim())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", UserPrincipalConverter.toUserPrincipal(userByUsername));
//                    switch (userByUsername.getRoleId()) {
//                        case 1L:
//                            response.sendRedirect("/dispatcher?command=items");
//                            break;
//                        case 2L:
//                            response.sendRedirect("/dispatcher?command=users");
//                            break;
//                        default:
//                            response.sendRedirect("/dispatcher?command=login");
//                            break;
//                    }
                    return null;
                } else {
                    request.setAttribute("error", "Username or password is not correct!");
                    return HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.LOGIN_PAGE_PATH);
                }
            } else {
                request.setAttribute("error", "Username or password is not correct!");
                return HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.LOGIN_PAGE_PATH);
            }
        } else {
            return HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.LOGIN_PAGE_PATH);
        }
    }
}

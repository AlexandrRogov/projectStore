package com.gmail.rogov.controller.command.impl;

import com.gmail.rogov.dao.config.HibernateConfigurationManager;
import com.gmail.rogov.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.ITEMS_PAGE_PATH);
    }
}

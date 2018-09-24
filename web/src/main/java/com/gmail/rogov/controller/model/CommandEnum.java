package com.gmail.rogov.controller.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum CommandEnum {
    LOGIN,
    USERS,
    ADDUSER,
    UPDATEUSER,
    DELETEUSER, ITEMS;

    public static CommandEnum getCommand(String command) {

        final Logger logger = LogManager.getLogger(CommandEnum.class);


        try {
            return CommandEnum.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Command does not found ");
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}

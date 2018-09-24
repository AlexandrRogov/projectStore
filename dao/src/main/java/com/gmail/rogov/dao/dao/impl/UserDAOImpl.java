package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.UserDAO;
import com.gmail.rogov.dao.dao.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericDaoImpl<User> implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    public UserDAOImpl() {
        super(User.class);
    }

}

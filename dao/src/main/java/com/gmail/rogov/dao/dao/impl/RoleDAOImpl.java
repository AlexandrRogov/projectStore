package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.RoleDAO;
import com.gmail.rogov.dao.dao.model.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends GenericDaoImpl<Role> implements RoleDAO {

    private static final Logger logger = LogManager.getLogger(RoleDAOImpl.class);

    public RoleDAOImpl() {
        super(Role.class);
    }
}


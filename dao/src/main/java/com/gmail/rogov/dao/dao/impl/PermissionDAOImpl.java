package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.PermissionDAO;
import com.gmail.rogov.dao.dao.model.Permission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionDAOImpl extends GenericDaoImpl<Permission> implements PermissionDAO {

    private static final Logger logger = LogManager.getLogger(PermissionDAOImpl.class);

    public PermissionDAOImpl() {
        super(Permission.class);
    }
}

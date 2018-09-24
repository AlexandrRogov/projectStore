package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.ProfileDAO;
import com.gmail.rogov.dao.dao.model.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAOImpl extends GenericDaoImpl<Profile> implements ProfileDAO {

    private static final Logger logger = LogManager.getLogger(ProfileDAOImpl.class);

    public ProfileDAOImpl() {
        super(Profile.class);
    }
}

package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.AuditDAO;
import com.gmail.rogov.dao.dao.model.Audit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class AuditDAOImpl extends GenericDaoImpl<Audit> implements AuditDAO {

    private static final Logger logger = LogManager.getLogger(AuditDAOImpl.class);

    public AuditDAOImpl() {
        super(Audit.class);
    }
}

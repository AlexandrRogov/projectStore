package com.gmail.rogov.dao.dao.impl;


import com.gmail.rogov.dao.dao.DiscountDAO;
import com.gmail.rogov.dao.dao.model.Discount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountDAOImpl extends GenericDaoImpl<Discount> implements DiscountDAO {

    private static final Logger logger = LogManager.getLogger(DiscountDAOImpl.class);

    public DiscountDAOImpl() {
        super(Discount.class);
    }
}

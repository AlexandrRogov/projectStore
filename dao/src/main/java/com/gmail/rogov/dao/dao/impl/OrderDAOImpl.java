package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.OrderDAO;
import com.gmail.rogov.dao.dao.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends GenericDaoImpl<Order> implements OrderDAO {

    private static final Logger logger = LogManager.getLogger(OrderDAOImpl.class);

    public OrderDAOImpl() {
        super(Order.class);
    }
}

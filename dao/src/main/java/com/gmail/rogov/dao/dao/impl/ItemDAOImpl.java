package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.ItemDAO;
import com.gmail.rogov.dao.dao.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl extends GenericDaoImpl<Item> implements ItemDAO {

    private static final Logger logger = LogManager.getLogger(ItemDAOImpl.class);


    public ItemDAOImpl() {
        super(Item.class);
    }
}

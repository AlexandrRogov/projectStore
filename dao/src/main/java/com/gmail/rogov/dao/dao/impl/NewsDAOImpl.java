package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.NewsDAO;
import com.gmail.rogov.dao.dao.model.News;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAOImpl extends GenericDaoImpl<News> implements NewsDAO {

    private static final Logger logger = LogManager.getLogger(NewsDAOImpl.class);

    public NewsDAOImpl() {
        super(News.class);
    }

}

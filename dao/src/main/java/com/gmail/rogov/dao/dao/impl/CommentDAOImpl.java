package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.CommentDAO;
import com.gmail.rogov.dao.dao.model.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl extends GenericDaoImpl<Comment> implements CommentDAO {

    private static final Logger logger = LogManager.getLogger(CommentDAOImpl.class);

    public CommentDAOImpl() {
        super(Comment.class);
    }
}

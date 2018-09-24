package com.gmail.rogov.service.impl;


import com.gmail.rogov.dao.dao.UserDAO;
import com.gmail.rogov.dao.dao.impl.UserDAOImpl;
import com.gmail.rogov.dao.dao.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.gmail.rogov.service.UserService;
import com.gmail.rogov.service.converter.impl.entityImpl.UserConverter;
import com.gmail.rogov.service.converter.impl.dtoImpl.UserDTOConverter;
import com.gmail.rogov.service.model.UserDTO;
import com.gmail.rogov.dao.dao.util.HibernateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    private UserDAO userDao = new UserDAOImpl();
    private UserDTOConverter userDTOConverter = new UserDTOConverter();
    private UserConverter userConverter = new UserConverter();

    @Override
    public UserDTO create(UserDTO userDTO) {
        Session session = userDao.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            User user = userConverter.toEntity(userDTO);
            userDao.create(user);
            transaction.commit();
            return userDTOConverter.toDTO(user);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to save user! ", e);
        }
        return userDTO;
    }


    @Override
    public UserDTO update(UserDTO user) {

        return null;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO findUserById(Long userId) {
        Session session = userDao.getCurrentSession();
        List<UserDTO> userDTO = new ArrayList<>();
        UserDTO user = new UserDTO();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                session.beginTransaction();
            }
            transaction.begin();
            String hql = "from t_user as u where u.id =:userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);

            user = userDTOConverter.toDTO((User) query.uniqueResult());
            return user;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findUserById  User! ", e);
        }
        return user;
    }

    @Override
    public UserDTO delete(UserDTO user) {
        return null;
    }


    @Override
    public List<UserDTO> findAll() {
        Session session = userDao.getCurrentSession();
        List<UserDTO> userDTO = new ArrayList<>();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                session.beginTransaction();
                transaction.begin();
            }
            String hql = "from" + User.class.getSimpleName();
            Query query = session.createQuery(hql);
            userDTO = userDTOConverter.toDTOList(query.list());
            transaction.commit();
            return userDTO;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findAll  User! ", e);
        }
        return userDTO;
    }
}

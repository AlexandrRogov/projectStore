package com.gmail.rogov.service.impl;

import com.gmail.rogov.dao.dao.ItemDAO;
import com.gmail.rogov.dao.dao.impl.ItemDAOImpl;
import com.gmail.rogov.dao.dao.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.gmail.rogov.service.ItemService;
import com.gmail.rogov.service.converter.impl.dtoImpl.ItemDTOConverter;
import com.gmail.rogov.service.converter.impl.entityImpl.ItemConverter;
import com.gmail.rogov.service.model.ItemDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);

    private ItemDAO itemDAO = new ItemDAOImpl();
    private ItemConverter itemConverter = new ItemConverter();
    private ItemDTOConverter itemDTOConverter = new ItemDTOConverter();

    @Override
    public ItemDTO create(ItemDTO itemDTO) {
        Session session = itemDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Item item = itemConverter.toEntity(itemDTO);
            itemDAO.create(item);
            transaction.commit();
            return itemDTOConverter.toDTO(item);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to save item! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return itemDTO;
    }

    @Override
    public ItemDTO delete(ItemDTO itemDTO) {
        Session session = itemDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Item item = itemConverter.toEntity(itemDTO);
            itemDAO.delete(item);
            transaction.commit();
            return itemDTOConverter.toDTO(item);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to delete item! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return itemDTO;
    }

    @Override
    public ItemDTO findOne(Long id) {
        Session session = itemDAO.getCurrentSession();
        ItemDTO itemDTO = new ItemDTO();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Item item = itemDAO.findOne(id);
            itemDTO = itemDTOConverter.toDTO(item);
            transaction.commit();
            return itemDTO;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findOne item! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return itemDTO;
    }

    @Override
    public ItemDTO update(ItemDTO itemDTO) {

        Session session = itemDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Item item = itemConverter.toEntity(itemDTO);
            itemDAO.update(item);
            transaction.commit();
            return itemDTOConverter.toDTO(item);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to update item! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return itemDTO;
    }

    @Override
    public Set<ItemDTO> findAll() {
        Session session = itemDAO.getCurrentSession();
        Set<ItemDTO> items = new HashSet<>();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            items = new HashSet<>(itemDTOConverter.toDTOList(itemDAO.findAll()));
            transaction.commit();
            return items;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findAll Items! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return items;
    }

    @Override
    public Set<ItemDTO> findSetItemInParametrs(BigDecimal start, BigDecimal finish) {
        Session session = itemDAO.getCurrentSession();
        Set<ItemDTO> items = new HashSet<>();
        List itemList = new ArrayList<>();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String hql = "select i from Item as i where i.price between :start and  :finish";
            Query query = session.createQuery(hql);
            query.setParameter("start", start);
            query.setParameter("finish", finish);
            itemList=query.list();
            items = new HashSet<>(itemDTOConverter.toDTOList(itemList));
            transaction.commit();
            return items;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findSetItemInParametrs! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return items;
    }


}

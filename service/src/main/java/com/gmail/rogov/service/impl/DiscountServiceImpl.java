package com.gmail.rogov.service.impl;

import com.gmail.rogov.dao.dao.DiscountDAO;
import com.gmail.rogov.dao.dao.ItemDAO;
import com.gmail.rogov.dao.dao.impl.DiscountDAOImpl;
import com.gmail.rogov.dao.dao.impl.ItemDAOImpl;
import com.gmail.rogov.dao.dao.model.Discount;
import com.gmail.rogov.dao.dao.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.gmail.rogov.service.DiscountService;
import com.gmail.rogov.service.converter.impl.dtoImpl.DiscountDTOConverter;
import com.gmail.rogov.service.converter.impl.dtoImpl.ItemDTOConverter;
import com.gmail.rogov.service.converter.impl.entityImpl.DiscountConverter;
import com.gmail.rogov.service.model.DiscountDTO;
import com.gmail.rogov.dao.dao.util.HibernateUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class DiscountServiceImpl implements DiscountService {

    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
    private DiscountDAO discountDAO = new DiscountDAOImpl();
    private DiscountConverter discountConverter = new DiscountConverter();
    private DiscountDTOConverter discountDTOConverter = new DiscountDTOConverter();
    private ItemDAO itemDAO = new ItemDAOImpl();
    private ItemDTOConverter itemDTOConverter = new ItemDTOConverter();

    @Override
    public DiscountDTO create(DiscountDTO discountDTO) {
        Session session = discountDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Discount discount = discountConverter.toEntity(discountDTO);
            discountDAO.create(discount);
            transaction.commit();

            return discountDTOConverter.toDTO(discount);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to save discount! ", e);
        } finally {
            session.close();
        }
        return discountDTO;
    }


    @Override
    public DiscountDTO delete(DiscountDTO discountDTO) {
        return null;
    }

    @Override
    public DiscountDTO findDiscountByPercent(Integer percent) {
        Session session = itemDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String hql = "select d from Discount as d where d.percent=:percent";
            Query query = session.createQuery(hql);
            query.setParameter("percent", percent);
            DiscountDTO discount = discountDTOConverter.toDTO((Discount) query.uniqueResult());
            transaction.commit();
            return discount;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findItemsWithDiscount ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return null;
    }

    @Override
    public DiscountDTO update(DiscountDTO discountDTO) {
        Session session = discountDAO.getCurrentSession();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Discount discount = discountConverter.toEntity(discountDTO);
            discountDAO.update(discount);
            transaction.commit();
            return discountDTOConverter.toDTO(discount);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to update discount! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return discountDTO;
    }

    @Override
    public DiscountDTO findOne(Long id) {
        Session session = discountDAO.getCurrentSession();
        DiscountDTO discountDTO = new DiscountDTO();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Discount discount = discountDAO.findOne(id);
            discountDTO = discountDTOConverter.toDTO(discount);
            transaction.commit();
            return discountDTO;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findOne discount! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return discountDTO;
    }

    @Override
    public Set<DiscountDTO> findAll() {
        Session session = discountDAO.getCurrentSession();
        Set<DiscountDTO> discounts = new HashSet<>();
        try {
            Transaction transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            discounts = new HashSet<>(discountDTOConverter.toDTOList(discountDAO.findAll()));
            transaction.commit();
            return discounts;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            logger.error("Failed to findAll discounts! ", e);
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return discounts;
    }

}

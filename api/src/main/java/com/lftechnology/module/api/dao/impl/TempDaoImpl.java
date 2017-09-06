package com.lftechnology.module.api.dao.impl;

import com.lftechnology.module.api.exception.SaveEntityException;
import com.lftechnology.module.api.exception.UpdateEntityException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.lftechnology.module.api.dao.TempDao;
import com.lftechnology.module.api.model.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TempDaoImpl implements TempDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Temp save(Temp temp) throws SaveEntityException {
        try {
            Integer id = (Integer) sessionFactory.getCurrentSession().save(temp);
            return (Temp) sessionFactory.getCurrentSession().get(Temp.class, id);
        } catch (HibernateException e) {
            throw new SaveEntityException("Fail to save doctorAssignment");
        }
    }

    @Override
    @Transactional
    public Temp update(Temp temp) throws UpdateEntityException {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(temp);
            return temp;
        } catch (HibernateException e) {
            throw new UpdateEntityException("Fail to Update doctorAssignment");
        }
    }

    @Override
    public Temp getTempByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Temp.class, "temp");
        criteria.add(Restrictions.eq("uuid", uuid));
        List list = criteria.list();
        return list.size() > 0 ? (Temp) list.get(0) : null;
    }

    public List<Temp> getAllTemps() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Temp.class, "temp");
        return criteria.list();
    }
}

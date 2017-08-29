package com.lftechnology.module.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.lftechnology.module.api.dao.TempDao;
import com.lftechnology.module.api.model.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TempDaoImpl implements TempDao {
    @Autowired
    private SessionFactory sessionFactory;

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

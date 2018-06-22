package com.juzss.crm.dao.impl;

import com.juzss.crm.dao.BaseDictDao;
import com.juzss.crm.dao.CustomerDao;
import com.juzss.crm.domain.BaseDict;
import com.juzss.crm.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {
    @Autowired
    public void setDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", dict_type_code);
        return list;
    }
}

package com.juzss.crm.dao.impl;

import com.juzss.crm.dao.SaleVisitDao;
import com.juzss.crm.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class SaleVisitDaoImpl extends HibernateDaoSupport implements SaleVisitDao {
    @Override
    public Integer findCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
        if(list.size() > 0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<SaleVisit> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize) {
//         清空查询方式，使其按照默认的查询方式进行
        criteria.setProjection(null);
        return (List<SaleVisit>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
    }

    @Override
    public void save(SaleVisit saleVisit) {
        this.getHibernateTemplate().save(saleVisit);
    }
}

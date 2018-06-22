package com.juzss.crm.dao.impl;

import com.juzss.crm.dao.LinkManDao;
import com.juzss.crm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

//    public LinkManDaoImpl() {
//        super(LinkMan.class);
//    }
//    public LinkManDaoImpl() {
//        super(LinkMan.class);
//    }
//    @Override
//    public Integer findCount(DetachedCriteria criteria) {
//        criteria.setProjection(Projections.rowCount());
//        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
//        if(list.size() > 0){
//            return list.get(0).intValue();
//        }
//        return null;
//    }
//
//    @Override
//    public List<LinkMan> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize) {
//        // 清空查询方式，使其按照默认的查询方式进行
//        criteria.setProjection(null);
//        return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
//    }
//
//    @Override
//    public void save(LinkMan linkMan) {
//        this.getHibernateTemplate().save(linkMan);
//    }
//
//    @Override
//    public LinkMan findById(Long lkm_id) {
//        return this.getHibernateTemplate().get(LinkMan.class,lkm_id);
//    }
//
//    @Override
//    public void update(LinkMan linkMan) {
//       this.getHibernateTemplate().update(linkMan);
//    }
//
//    @Override
//    public void delete(LinkMan linkMan) {
//        this.getHibernateTemplate().delete(linkMan);
//    }
}

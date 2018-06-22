package com.juzss.crm.dao.impl;

import com.juzss.crm.dao.CustomerDao;
import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.LinkMan;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl  extends BaseDaoImpl<Customer> implements CustomerDao {
//    public CustomerDaoImpl() {
//        super(Customer.class);
//    }
//    @Override
//    public Long findByCount(DetachedCriteria criteria) {
//        criteria.setProjection(Projections.rowCount());
//        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
//        if(list!=null && list.size()>0) {
//            return list.get(0);
//        }
//        return  0L;
//    }
//
//    @Override
//    public List<Customer> findByCriteria(DetachedCriteria criteria, Integer curPage, Integer pageSize) {
////         QBC查询：如果指定了投影，后续所有的查询都会按照投影查询，改回默认值，按照字段查询
//        criteria.setProjection(null);
//        // 参数一：获取当前页从第几条开始检索；参数二：当前页最多显示的记录数
//        Integer firstResult = (curPage - 1) * pageSize;
//        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria,firstResult,pageSize);
//        return list;
//    }
//
//    @Override
//    public Customer findById(Long cust_id) {
//        return this.getHibernateTemplate().get(Customer.class, cust_id);
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//    }
//    @Autowired
//    public void setDi(SessionFactory sessionFactory){
//        this.setSessionFactory(sessionFactory);
//    }
//
//    @Override
//    public void save(Customer customer) {
//          this.getHibernateTemplate().save(customer);
//    }
//
//    @Override
//    public Long findByCount(DetachedCriteria criteria) {
//        criteria.setProjection(Projections.rowCount());
//        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
//        if(list!=null && list.size()>0){
//            return list.get(0);
//        }
//        return 0L;
//    }
//
//    @Override
//    public List<Customer> findByCriteria(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
//        // QBC查询：如果指定了投影，后续所有的查询都会按照投影查询，改回默认值，按照字段查询
//        criteria.setProjection(null);
//        // 参数一：获取当前页从第几条开始检索；参数二：当前页最多显示的记录数
//        Integer firstResult = (currPage - 1) * pageSize;
//        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria,firstResult,pageSize);
//        return list;
//    }
//
//    @Override
//    public Customer findById(Long cust_id) {
//        return this.getHibernateTemplate().get(Customer.class, cust_id);
//    }
//
//    @Override
//    public void delete(Customer customer) {
//       this.getHibernateTemplate().delete(customer);
//    }
//
//    @Override
//    public void update(Customer customer) {
//        this.getHibernateTemplate().update(customer);
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//    }


}

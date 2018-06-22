package com.juzss.crm.dao;

import com.juzss.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer>{
//    Long findByCount(DetachedCriteria criteria);
//
//    List<Customer> findByCriteria(DetachedCriteria criteria, Integer currPage, Integer pageSize);
//    void save(Customer customer);
//
//    Long findByCount(DetachedCriteria criteria);
//
//    List<Customer> findByCriteria(DetachedCriteria criteria, Integer curPage, Integer pageSize);
//
//    Customer findById(Long cust_id);

    @Override
    List<Customer> findAll();
//
//    void delete(Customer customer);
//
//    void update(Customer customer);
//
//
//    List<Customer> findAll();
}

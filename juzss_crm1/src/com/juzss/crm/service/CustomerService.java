package com.juzss.crm.service;

import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);

    PageBean<Customer> findByPage(DetachedCriteria criteria, Integer curPage, Integer pageSize);

    Customer findById(Long cust_id);

    void delete(Customer customer);

    void update(Customer customer);

    List<Customer> findAll();
}

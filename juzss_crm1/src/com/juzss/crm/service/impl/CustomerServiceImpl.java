package com.juzss.crm.service.impl;

import com.juzss.crm.dao.CustomerDao;
import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    private  Integer begin;
    @Override
    public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer curPage, Integer pageSize) {
        // 封装结果集
        PageBean<Customer> pageBean = new PageBean<>();
        // 当前页
        pageBean.setCurrPage(curPage);

        // 每页最多显示的记录数
        pageBean.setPageSize(pageSize);

        // 总记录数
        // 使用QBC的查询条件，查询总记录数
        Integer count = customerDao.findCount(criteria);
        pageBean.setTotalCount(count.intValue());

        // 总页数
        Double c = count.doubleValue(); // 7/3=2.3=3   9/3=3=3
        double totalPage = Math.ceil(c/pageSize); //math.ceil(x)返回大于等于参数x的最小整数,即对浮点数向上取整.
        pageBean.setTotalPage((int) totalPage);
        // 结果集
        begin = (curPage - 1) * pageSize;
        List<Customer> list = customerDao.findByPage(criteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
     /**
      * 业务层根据ID查询客户的方法:
      * */
    @Override
    public Customer findById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

}

package com.juzss.crm.service.impl;

import com.juzss.crm.dao.SaleVisitDao;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.domain.SaleVisit;
import com.juzss.crm.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户拜访模块业务层的实现类
 */
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
    //注入dao

    @Autowired
    private SaleVisitDao saleVisitDao;

//    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
//        this.saleVisitDao = saleVisitDao;
//    }

    @Override
    public PageBean<SaleVisit> findByPage(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
        PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();

        //设置参数:
        //设置当前页数
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数:
        pageBean.setPageSize(pageSize);

        //设置总记录数
        Integer totalCount = saleVisitDao.findCount(criteria);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        double  tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //设置每页显示数据的集合

        Integer begin = (currPage - 1) * pageSize;

        List<SaleVisit> list = saleVisitDao.findByPage(criteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(SaleVisit saleVisit) {
        saleVisitDao.save(saleVisit);
    }
}

package com.juzss.crm.service;

import com.juzss.crm.domain.PageBean;
import com.juzss.crm.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    PageBean<SaleVisit> findByPage(DetachedCriteria criteria, Integer currPage, Integer pageSize);

    void save(SaleVisit saleVisit);
}

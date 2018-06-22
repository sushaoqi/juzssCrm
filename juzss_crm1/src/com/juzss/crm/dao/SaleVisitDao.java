package com.juzss.crm.dao;

import com.juzss.crm.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface SaleVisitDao {
    Integer findCount(DetachedCriteria criteria);

    List<SaleVisit> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize);

    void save(SaleVisit saleVisit);
}

package com.juzss.crm.dao;

import com.juzss.crm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
     void save(T t);
     void update(T t);
     void delete(T t);
     T findById(Serializable id);
     Integer findCount(DetachedCriteria detachedCriteria);
      List<T> findByPage(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);
      List<T> findAll();

//     List<LinkMan> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize);
//
//     Integer findCount(DetachedCriteria criteria);
//
//     LinkMan findById(Long lkm_id);
}

package com.juzss.crm.service;

import com.juzss.crm.domain.LinkMan;
import com.juzss.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {

    PageBean<LinkMan> findByPage(DetachedCriteria criteria, Integer currPage, Integer pageSize);

    void save(LinkMan linkMan);

    LinkMan findById(Long lkm_id);

    void update(LinkMan linkMan);

    void delete(LinkMan linkMan);
}

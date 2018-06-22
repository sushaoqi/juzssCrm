package com.juzss.crm.service.impl;

import com.juzss.crm.dao.LinkManDao;
import com.juzss.crm.domain.LinkMan;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户模块业务层的实现类
 * */

@Transactional
public class LinkManServiceImpl implements LinkManService  {
    @Autowired
    private LinkManDao linkManDao;

//    public void setLinkManDao(LinkManDao linkManDao) {
//        this.linkManDao = linkManDao;
//    }

    @Override
    public PageBean<LinkMan> findByPage(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
        PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
        // 设置当前页数:
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数：
        pageBean.setPageSize(pageSize);
        // 设置总记录数:
        Integer totalCount = linkManDao.findCount(criteria);
        pageBean.setTotalCount(totalCount);
        // 设置总页数：
        double tc = totalCount;
        Double num = Math.ceil(tc /pageSize);
        pageBean.setTotalPage(num.intValue());
        // 设置每页显示数据的集合:
        // 设置当前页从第几条开始检索。
        Integer begin = (currPage - 1) * pageSize;
        List<LinkMan> list = linkManDao.findByPage(criteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    @Override
    public LinkMan findById(Long lkm_id) {
        return linkManDao.findById(lkm_id);
    }

    @Override
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    @Override
    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }
}

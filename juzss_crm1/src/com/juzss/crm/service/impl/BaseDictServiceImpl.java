package com.juzss.crm.service.impl;

import com.juzss.crm.dao.BaseDictDao;
import com.juzss.crm.dao.CustomerDao;

import com.juzss.crm.domain.BaseDict;
import com.juzss.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    BaseDictDao baseDictDao;


    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }
}

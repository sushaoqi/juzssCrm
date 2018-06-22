package com.juzss.crm.dao;

import com.juzss.crm.domain.BaseDict;

import java.util.List;


public interface BaseDictDao {

    List<BaseDict> findByTypeCode(String dict_type_code);
}

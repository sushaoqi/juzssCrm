package com.juzss.crm.web.action;

import com.juzss.crm.domain.BaseDict;
import com.juzss.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    BaseDict baseDict = new BaseDict();

    @Override
    public BaseDict getModel() {
        return baseDict;
    }

    @Autowired
    BaseDictService baseDictService;

    /**
     * 使用编号,获取数字字典的值
     *使用数据字典的编号,获取当前编号对应的集合
     * ajax不需要返回页面的
     * */

    public String findByTypeCode() throws Exception{
        // 使用数据字典的编号，获取当前编号对应的集合
        String dict_type_code = baseDict.getDict_type_code();
        List<BaseDict> list = baseDictService.findByTypeCode(dict_type_code);
        // 如何将list转换成json的形式返回
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
        // 响应数据到页面
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return NONE;
    }
}

package com.juzss.crm.web.action;

import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.domain.SaleVisit;
import com.juzss.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 客户拜访模块的Action类
 */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    //创建模型驱动类对象

    private  SaleVisit saleVisit = new SaleVisit();

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }

    //注入业务层

    @Autowired
    private SaleVisitService saleVisitService;

//    public void setSaleVisitService(SaleVisitService saleVisitService) {
//        this.saleVisitService = saleVisitService;
//    }


    // 接收拜访截止时间:

    private Date visit_end_time;

    public Date getVisit_end_time() {
        return visit_end_time;
    }

    public void setVisit_end_time(Date visit_end_time) {
        this.visit_end_time = visit_end_time;
    }
    // 接收分页的数据:

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        if(currPage == null){
            currPage = 1;
        }else{
            this.currPage = currPage;
        }
    }

    // 接收每页显示记录数:
    private Integer pageSize = 3;

    public void setPageSize(Integer pageSize) {
        if(pageSize == null){
            this.pageSize = 3;
        }else{
            this.pageSize = pageSize;
        }
    }

    /**
     * 分页查询拜访记录的方法:findByPage
     */
    public String findByPage(){
        //创建离线查询对象
        DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
        //设置条件
        if(saleVisit.getVisit_time() != null){
            criteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
        }
        if(saleVisit.getVisit_time() != null){
            criteria.add(Restrictions.le("visit_time",visit_end_time));
        }

        System.out.println("saleVisit==========="+criteria);
        //调用业务层的方法
        PageBean<SaleVisit> pageBean = saleVisitService.findByPage(criteria,currPage,pageSize);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findByPage";
    }


    /**
     * 跳转到添加页面的方法:saveUI
     */
    public String saveUI(){
        return "saveUI";
    }

    /**
     * 保存客户拜访记录的方法:save
     */

      public String save(){
          saleVisitService.save(saleVisit);
          return "saveSuccess";
      }




}

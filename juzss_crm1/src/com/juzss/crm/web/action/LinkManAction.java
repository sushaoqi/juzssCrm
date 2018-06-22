package com.juzss.crm.web.action;

import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.LinkMan;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.service.CustomerService;
import com.juzss.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户模块的Action类
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    // 模型驱动使用的对象:

    private LinkMan linkMan = new LinkMan();
    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    // 注入业务层:

    @Autowired
    private LinkManService linkManService;

    @Autowired
    private CustomerService customerService;

//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }



    public String saveUI(){
        //直接完成查询:查询所有客户的信息
        List<Customer> list = customerService.findAll();
        // 将list存入到值栈中，带到页面上:
        ActionContext.getContext().getValueStack().set("list",list);
        return  "saveUI";
    }

    /**
     * 接收当前页数
     */

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
     * 分页查询客户数据：
     */
    public String findByPage(){
        // 调用业务层完成查询：
        // 创建一个离线条件查询对象:
        DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
        // 设置联系人的名称:
        if(StringUtils.isNotBlank(linkMan.getLkm_name())){
            // 添加条件:
            criteria.add(Restrictions.like("lkm_name", linkMan.getLkm_name(),MatchMode.ANYWHERE));
        }
        // 设置性别:
        if(StringUtils.isNotBlank(linkMan.getLkm_gender())){
            // 添加条件
            criteria.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
        }
        // 调用业务层查询:
        PageBean<LinkMan> pageBean = linkManService.findByPage(criteria,currPage,pageSize);
        // 将pageBean带到页面：
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findByPage";
    }

    /*
    * 保存联系人的方法
    * */

    public String save(){
        //调用业务层：
        linkManService.save(linkMan);
        return  "saveSuccess";
    }

     /**
      * 编辑联系人的方法:edit
      * */
     public String edit(){
         //根据ID查询联系人的信息
         linkMan = linkManService.findById(linkMan.getLkm_id());
         //查询所有的客户:
         List<Customer> list = customerService.findAll();
         //将数据压入中:
         ActionContext.getContext().getValueStack().push(linkMan);
         ActionContext.getContext().getValueStack().set("list",list);
         return "editSuccess";
     }

    /**
     * 修改联系人：update
     */
    public String update(){
        linkManService.update(linkMan);
        return "updateSuccess";
    }


    /**
     * 删除联系人:delete
     */
     public String delete(){
         linkMan = linkManService.findById(linkMan.getLkm_id());
         linkManService.delete(linkMan);
         return "deleteSuccess";
     }


}
package com.juzss.crm.web.action;


import com.juzss.crm.domain.Customer;
import com.juzss.crm.domain.PageBean;
import com.juzss.crm.service.CustomerService;
import com.juzss.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
   Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    @Autowired
    CustomerService customerService;

    // 当前页
    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        if(currPage == null){
            currPage = 1;
        }
        this.currPage = currPage;
    }

    private Integer pageSize = 3;

    public void setPageSize(Integer pageSize) {
        if(pageSize==null){
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

   /**
    * 文件上传提供的三个属性:
    * 文件类型：代表上传文件
    * 字符串类型：代表文件名称
    * 字符串类型：代表文件类型
    * */
    private String uploadFileName;
    private File upload;
    private  String uploadContentType;

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    /*
     * 跳转到客户新增的页面
     * */

    public String saveUI(){
        return "saveUI";
    }

    /**
     * 保存客户的方法
     * @throws IOException
     * 完成文件上传:
     * 设置上传路径
     * 获得唯一文件名:
     * 根据唯一文件名获得目录分离路径:
     * 拼接路径
     */
    public String save() throws IOException {
        if(upload != null){
            String path = "C:/upload";
            String uuidFileName = UploadUtils.getUUIDFileName(uploadFileName);
            String realPath = UploadUtils.getPath(uuidFileName);
            String str = path + realPath;
            File file = new File(str);
            if(!file.exists()){
                file.mkdirs();
            }
            File dastFile = new File(str + "/" + uuidFileName);
            FileUtils.copyFile(upload,dastFile);

            //设置图片路径
            customer.setCust_image(str+"/"+uuidFileName);
        }
        customerService.save(customer);
        return "save";
    }



    // 查询客户信息（分页）

    public String findByPage(){
        // 查询所有（后续改成条件查询）
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        // 设置名称
        if(StringUtils.isNotBlank(customer.getCust_name())){
            criteria.add(Restrictions.like("cust_name", customer.getCust_name(),MatchMode.ANYWHERE));
        }
        // 设置客户的来源
        if(customer.getBaseDictSource()!=null && StringUtils.isNotBlank(customer.getBaseDictSource().getDict_id())){
            criteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
        }
        // 设置客户的级别
        if(customer.getBaseDictLevel()!=null && StringUtils.isNotBlank(customer.getBaseDictLevel().getDict_id())){
            criteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
        }
        // 设置客户的行业
        if(customer.getBaseDictIndustry()!=null && StringUtils.isNotBlank(customer.getBaseDictIndustry().getDict_id())){
            criteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
        }



        // 传递分页的参数，离线的对象
        PageBean<Customer> pageBean = customerService.findByPage(criteria,currPage,pageSize);
        // 将对象压入到栈顶
        ServletActionContext.getContext().getValueStack().push(pageBean);
        return "findByPage";
    }

    /*
    * 客户删除的方法:delete
    * 根据ID查询客户。
    * 删除图片
    *
    * **/

    public String delete(){
        customer = customerService.findById(customer.getCust_id());
        String cust_image = customer.getCust_image();
        if(cust_image != null){
            File file = new File(cust_image);
            if(file.exists()){
                file.delete();
            }
        }
        //删除客户:
        customerService.delete(customer);
        return  "deleteSuccess";
    }

    /***
     * 编辑客户的方法:edit
     * 根据id查询,跳转页面,回显数据
     * 将customer传递到页面
     * 两种方式:一种,手动压栈。二种,因为模型驱动的对象,默认在栈顶
     * 如果使用第一种方式:回显数据:  <s:property value="cust_name" /> <s:name="cust_name" value="">
     * 如果使用第二种方式:回显数据:<s:property value="model.cust_name"/>
     */
    public String edit(){
        customer = customerService.findById(customer.getCust_id());
        ActionContext.getContext().getValueStack().push(customer);
        return "editSuccess";
    }

    /**
     *
     * 修改客户的方法
     */
    public String update() throws IOException {
        //完成文件上传
        //删除原有图片
        // 完成文件上传:
        if(upload != null){
            // 删除原有图片
            String cust_image = customer.getCust_image();
            if(cust_image != null){
                File file = new File(cust_image);
                if(file.exists()){
                    file.delete();
                }
            }
            // 上传新图片
            String path = "C:/upload";
            // 获得唯一文件名:
            String uuidFileName = UploadUtils.getUUIDFileName(uploadFileName);
            // 根据唯一文件名获得目录分离路径：
            String realPath = UploadUtils.getPath(uuidFileName);
            // 拼接路径:
            String str = path+realPath;
            File file = new File(str);
            if(!file.exists()){
                file.mkdirs();
            }
            File destFile = new File(str+"/"+uuidFileName);
            FileUtils.copyFile(upload, destFile);
            // 设置图片路径:
            customer.setCust_image(str+"/"+uuidFileName);
        }
        // 修改客户
        customerService.update(customer);
        return "updateSuccess";
    }


    /**
     * 查询所有客户的方法:findAll
     */
    public String findAll() throws IOException {
        //调用业务层查询
        List<Customer> list = customerService.findAll();
        //将list转化成JSON
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"linkMans","baseDictSource","baseDictLevel","baseDictIndustry"});
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        System.out.println(jsonArray.toString());
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return  NONE;
    }
}

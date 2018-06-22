package com.juzss.crm.web.action;

import com.juzss.crm.domain.User;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.juzss.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.IOException;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User>{


	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	@Autowired
	private UserService userService;

	// 登录注册
	public String regist(){
		userService.save(user);
		return  SUCCESS;
	}

	/*
	* 登录
	* */

	public String login(){
		//使用用户名完成数据校验,返回User,如果匹配成功,将user存放到
		//session,如果匹配不成功,在login.jsp上输出错误信息
        User u = userService.findCodeByPassword(user);
        //登录失败
		if(u == null){
			//校验机制
			this.addActionError("您输入的用户名和密码错误!");
			return "errorLogin";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("exist_user",u);
			return "login";
		}
	}

	/**
	 * 查询所有客户的方法:findAll
	 */
	public  String findAll() throws IOException {
		// 调用业务层:
		List<User> list = userService.findAll();
		// 将list转成JSON
		JSONArray jsonArray = JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}

}

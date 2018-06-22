package com.juzss.crm.service.impl;

import com.juzss.crm.dao.UserDao;
import com.juzss.crm.domain.User;
import com.juzss.crm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.juzss.crm.service.UserService;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	  UserDao userDao;
	
	@Override
	public void save(User user) {
		// 完成md5的密码加密
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		// 将状态设置为1,1表示正常，（0，完成邮件激活）
		user.setUser_state("1");
		userDao.save(user);
	}



//	@Override
//	public User login(User user) {
//		user.setUser_password(MD5Utils.md5(user.getUser_password()));
//		return  userDao.login(user);
//	}

	@Override
	public User findCodeByPassword(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.findByCodeAndPassword(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
}

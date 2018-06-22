package com.juzss.crm.service;

import com.juzss.crm.domain.User;

import java.util.List;

public interface UserService {

	void save(User user);


    User findCodeByPassword(User user);

    List<User> findAll();
}

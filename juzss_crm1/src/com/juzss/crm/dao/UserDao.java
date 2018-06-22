package com.juzss.crm.dao;

import com.juzss.crm.domain.User;

import java.util.List;

public interface UserDao {

	void save(User user);

    User findByCodeAndPassword(User user);

    List<User> findAll();
}

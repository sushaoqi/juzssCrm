package com.juzss.crm.dao.impl;

import java.util.List;

import com.juzss.crm.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;



import com.juzss.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    public void setDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public User findByCodeAndPassword(User user) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ? and user_state = ?", user.getUser_code(),user.getUser_password(),"1");
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.getHibernateTemplate().find("from User");
    }
}

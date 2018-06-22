package com.juzss.crm.dao.impl;

import com.juzss.crm.dao.BaseDao;
import com.juzss.crm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 通用的DAO的实现类
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class clazz;
    public BaseDaoImpl() {
        // 获得子类的Class对象：
        Class c = this.getClass();
        // 通过子类的Class获得带有泛型的父类:
        Type type = c.getGenericSuperclass();
        // 将type转成参数化的类型:
        System.out.println(type);
        ParameterizedType pType = (ParameterizedType) type;
        // 获得实际类型参数
        Type[] types = pType.getActualTypeArguments();
        this.clazz = (Class) types[0];
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }
    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }
    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }
    @Override
    public T findById(Serializable id) {
        return (T) this.getHibernateTemplate().get(this.clazz, id);
    }

    @Override
    public Integer findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size() > 0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from "+this.clazz.getSimpleName());
    }
}

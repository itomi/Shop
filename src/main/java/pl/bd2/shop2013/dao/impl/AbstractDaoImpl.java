package pl.bd2.shop2013.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bd2.shop2013.dao.IAbstractDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 05.08.13
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDaoImpl<T extends Serializable> implements IAbstractDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    private final Class<T> type;
    protected Criteria criteria;

    public AbstractDaoImpl(Class<T> type) {
        this.type = type;
    }

    public AbstractDaoImpl() {
        ParameterizedType daoType = (ParameterizedType) getClass().getGenericSuperclass();
        type = (Class<T>) daoType.getActualTypeArguments()[0];
    }

    @Override
    public void create(T obj) {
        currentSession().save(obj);
    }

    @Override
    public void update(T obj) {
        currentSession().update(obj);
    }

    @Override
    public void delete(T obj) {
        currentSession().delete(obj);
    }

    @Override
    public List<T> findItems() {
        criteria = currentSession().createCriteria(type);
        return criteria.list();
    }

    @Override
    public T getItemById(Long id) {
        criteria = currentSession().createCriteria(type);
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.uniqueResult();

    }

    Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}

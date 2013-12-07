package pl.bd2.shop2013.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd2.shop2013.dao.IAbstractDao;
import pl.bd2.shop2013.service.IAbstractService;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 05.08.13
 * Time: 12:31
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public abstract class AbstractServiceImpl<T extends Serializable> implements IAbstractService<T> {

    protected abstract IAbstractDao<T> getDao();


    @Override
    public void create(T object) {
        getDao().create(object);
    }

    @Override
    public T getItemById(Long id) {
        return getDao().getItemById(id);
    }

    @Override
    public List<T> findItems() {
        return getDao().findItems();
    }

    @Override
    public void update(T object) {
        getDao().update(object);
    }

    @Override
    public void delete(T object) {
        getDao().delete(object);
    }


}

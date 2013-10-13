package pl.solsoft.shop2013.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 05.08.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public interface IAbstractDao<T extends Serializable> {

    public void create(T obj);

    public void update(T obj);

    public void delete(T obj);

    public List<T> findItems();

    public T getItemById(Long id);
}

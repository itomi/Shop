package pl.solsoft.shop2013.service;

import pl.solsoft.shop2013.domain.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 05.08.13
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 */
public interface IAbstractService<T extends Serializable> {

    public void create(T obj);

    public T getItemById(Long id);

    public List<T> findItems();

    public void update(T obj);

    public void delete(T obj);
}

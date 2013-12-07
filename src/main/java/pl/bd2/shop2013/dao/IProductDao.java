package pl.bd2.shop2013.dao;

import pl.bd2.shop2013.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public interface IProductDao extends IAbstractDao<Product> {

    public List<Product> findProducts(int start, Long categoryId);

    List<Product> findProductsByText(String search);
}

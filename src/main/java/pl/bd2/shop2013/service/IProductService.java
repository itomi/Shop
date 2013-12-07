package pl.bd2.shop2013.service;

import pl.bd2.shop2013.domain.Product;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public interface IProductService extends IAbstractService<Product> {

    public List<Product> findProducts(int start, Long categoryId);

    public boolean changeQuantities(Map <Long, Integer> map);

    public void updateQuantities(Map <Long, Integer> map);

    public List<Product> findProductsByText(String search);
}

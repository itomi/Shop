package pl.bd2.shop2013.dao.impl;

import org.springframework.stereotype.Repository;
import pl.bd2.shop2013.dao.IProductDao;
import pl.bd2.shop2013.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements IProductDao {

    @Override
    public List<Product> findProducts(int start, Long categoryId) {
        final int maxSizePage = 6;
        return (List<Product>) currentSession()
                .createSQLQuery(
                        "select * from products prod, category_product_relation rel" +
                                " where rel.category_id = " + categoryId +
                                " and prod.id = rel.product_id").addEntity(Product.class)
                .setFirstResult(start)
                .setMaxResults(maxSizePage + 1)
                .list();
    }

    @Override
    public List<Product> findProductsByText(String search) {

        return (List<Product>) currentSession()
                .createSQLQuery(
                        "select * from products " +
                                "where name like %" + search + "%"
                ).addEntity(Product.class)
                .list();
    }

}

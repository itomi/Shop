package pl.solsoft.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solsoft.shop2013.dao.IAbstractDao;
import pl.solsoft.shop2013.dao.IProductDao;
import pl.solsoft.shop2013.domain.Product;
import pl.solsoft.shop2013.service.IProductService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<Product> implements IProductService {

    @Autowired
    IProductDao productDao;

    @Override
    protected IAbstractDao<Product> getDao() {
        return productDao;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Product> findProducts(int start, Long categoryId) {
        return productDao.findProducts(start, categoryId);
    }

    @Override
    public boolean changeQuantities(Map<Long, Integer> map) {

        if (map.isEmpty()) return false;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {

            Product product = productDao.getItemById(entry.getKey());
            Integer q = product.getQuantity() - entry.getValue();

            if (q < 0) return false;

            product.setQuantity(q);
        }

        return true;
    }

    @Override
    public void updateQuantities(Map<Long, Integer> map) {
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            Product product = productDao.getItemById(entry.getKey());
            productDao.update(product);
        }
    }

    @Override
    public List<Product> findProductsByText(String search) {
        return productDao.findProductsByText(search);
    }
}

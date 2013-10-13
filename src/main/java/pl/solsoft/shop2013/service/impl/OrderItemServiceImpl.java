package pl.solsoft.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solsoft.shop2013.dao.IAbstractDao;
import pl.solsoft.shop2013.dao.IOrderItemDao;
import pl.solsoft.shop2013.domain.OrderItem;
import pl.solsoft.shop2013.service.IOrderItemService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<OrderItem> implements IOrderItemService {

    @Autowired
    IOrderItemDao orderItemDao;

    @Override
    protected IAbstractDao<OrderItem> getDao() {
        return orderItemDao;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<OrderItem> findOrderItems(Long orderId) {
        return orderItemDao.findOrderItems(orderId);
    }

    @Override
    public boolean isProductInOrderItems(Long id) {
        return orderItemDao.isProductInOrderItems(id);
    }
}

package pl.bd2.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd2.shop2013.dao.IAbstractDao;
import pl.bd2.shop2013.dao.IOrderDao;
import pl.bd2.shop2013.domain.Order;
import pl.bd2.shop2013.service.IOrderService;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order> implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Override
    protected IAbstractDao<Order> getDao() {
        return orderDao;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

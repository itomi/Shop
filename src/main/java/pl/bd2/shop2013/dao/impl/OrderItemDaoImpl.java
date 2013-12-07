package pl.bd2.shop2013.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.bd2.shop2013.dao.IOrderItemDao;
import pl.bd2.shop2013.domain.OrderItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class OrderItemDaoImpl extends AbstractDaoImpl<OrderItem> implements IOrderItemDao {
    @Override
    public List<OrderItem> findOrderItems(Long orderId) {
        Criteria criteria = currentSession().createCriteria(OrderItem.class);
        criteria.add(Restrictions.eq("order.id", orderId));
        return criteria.list();
    }

    @Override
    public boolean isProductInOrderItems(Long id) {
        Criteria criteria = currentSession().createCriteria(OrderItem.class);
        criteria.add(Restrictions.eq("product.id", id));

        if (criteria.list().size() == 0)
            return false;

        return true;
    }
}

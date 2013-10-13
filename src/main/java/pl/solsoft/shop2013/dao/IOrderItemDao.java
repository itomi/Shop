package pl.solsoft.shop2013.dao;

import pl.solsoft.shop2013.domain.OrderItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderItemDao extends IAbstractDao<OrderItem> {

    public List<OrderItem> findOrderItems(Long orderId);

    public boolean isProductInOrderItems(Long id);
}

package pl.solsoft.shop2013.service;

import pl.solsoft.shop2013.domain.OrderItem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderItemService extends IAbstractService<OrderItem> {
    public List<OrderItem> findOrderItems(Long orderId);

    public boolean isProductInOrderItems(Long id);
}

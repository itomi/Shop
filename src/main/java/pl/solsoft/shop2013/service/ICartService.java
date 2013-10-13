package pl.solsoft.shop2013.service;

import pl.solsoft.shop2013.domain.CartItem;
import pl.solsoft.shop2013.domain.Order;
import pl.solsoft.shop2013.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.08.13
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public interface ICartService {
    public void addCartItem(CartItem cartItem);
    public void deleteCartItem(int index);
    public List<CartItem> findCartItemList();
    public void clearCartItems();
    public Order convertToOrder(Date date, User user);
    public Map<Long, Integer> findProductQuantities();
}

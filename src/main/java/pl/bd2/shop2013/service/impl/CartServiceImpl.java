package pl.bd2.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bd2.shop2013.domain.Cart;
import pl.bd2.shop2013.domain.CartItem;
import pl.bd2.shop2013.domain.Order;
import pl.bd2.shop2013.domain.User;
import pl.bd2.shop2013.service.ICartService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.08.13
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    Cart cart;

    @Override
    public void addCartItem(CartItem cartItem)
    {
        List<CartItem> cartItemList = cart.getCartItemList();
        for (CartItem c : cartItemList)
        {
            if (c.getProductId() == cartItem.getProductId())
            {
                int newQuantity = c.getQuantity() + cartItem.getQuantity();
                c.incQuantity(newQuantity);
                return;
            }
        }

        cartItemList.add(cartItem);
    }

    @Override
    public void deleteCartItem(int index)
    {
        cart.getCartItemList().remove(index);
    }
    @Override
    public List<CartItem> findCartItemList(){
        return cart.getCartItemList();
    }
    @Override
    public void clearCartItems()
    {
        cart.getCartItemList().clear();
    }

    @Override
    public Order convertToOrder(Date date, User aUser)
    {
        Order order = new Order(date, aUser, getTotal(), cart.getCartItemList());

        return order;
    }

    @Override
    public Map<Long, Integer> findProductQuantities()
    {
        Map <Long, Integer> result = new HashMap<Long, Integer>();
        List<CartItem> cartItemList = cart.getCartItemList();

        for (CartItem c : cartItemList)
        {
            result.put(c.getProductId(), c.getQuantity());
        }

        return result;
    }

    private double getTotal()
    {
        double result = 0;
        List<CartItem> cartItemList = cart.getCartItemList();

        for (CartItem c : cartItemList)
        {
            result += c.getProductPrice() * c.getQuantity();
        }

        return result;
    }

}

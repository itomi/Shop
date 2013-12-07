package pl.bd2.shop2013.domain;

import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cart extends AbstractShopNonPersistent{

    private List<CartItem> cartItemList = new ArrayList<CartItem>();

    /**
     * Getters & Setters
     */

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}

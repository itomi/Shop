package pl.solsoft.shop2013.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 09.08.13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "OrderItem")
@Table(name = "ORDER_ITEMS")
public class OrderItem extends AbstractShopPersistent {

    @OneToOne
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    private Order order;

    public OrderItem()
    {

    }

    public OrderItem(CartItem cartItem, Order aOrder)
    {
        product = cartItem.getProduct();
        quantity = cartItem.getQuantity();
        order = aOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

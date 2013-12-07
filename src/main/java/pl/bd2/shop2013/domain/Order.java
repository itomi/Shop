package pl.bd2.shop2013.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name = "ORDER")
@Table(name = "ORDERS")
public class Order extends AbstractShopPersistent {

    @Column(name = "DATE")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @Column(name = "TOTAL")
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

    public Order()
    {

    }

    public Order(Date aOrderDate, User aUser, Double aTotal, List<CartItem> list)
    {
        orderDate = aOrderDate;
        user = aUser;
        total = aTotal;

        for (CartItem c : list)
        {
            OrderItem orderItem = new OrderItem(c, this);
            orderItemList.add(orderItem);
        }
    }

    /**
     * Getters and Setters
     */

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}

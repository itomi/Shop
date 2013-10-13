package pl.solsoft.shop2013.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CartItem extends AbstractShopNonPersistent {

    private Product product;

    private int quantity;

    public CartItem()
    {

    }

    public CartItem(Product aProduct, Integer aQuantity)
    {
        product = aProduct;
        quantity = aQuantity;
    }

    /**
     * Getters and Setters
     */

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /* Logic */

    public Long getProductId()
    {
        return product.getId();
    }

    public Integer getProductQuantity()
    {
        return product.getQuantity();
    }

    public void incQuantity(int l)
    {
        quantity += l;
    }

    public Double getProductPrice()
    {
        return product.getPrice();
    }
}

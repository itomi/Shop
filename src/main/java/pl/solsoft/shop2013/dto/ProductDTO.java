package pl.solsoft.shop2013.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.solsoft.shop2013.domain.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 12.08.13
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class ProductDTO implements IAbstractDTO<Product> {

    @NotEmpty(message = "Enter product name")
    private String name;

    @NotNull(message = "Enter product price")
    @Min(value = 0, message = "Price can't be lower than 0")
    private Double price;

    @NotNull(message = "Enter product quantity")
    @Min(value = 0, message = "Quantity can't be lowe than 0")
    private Integer quantity;

    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public Product createObject() {
        Product p = new Product();

        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);

        return p;
    }
}

package pl.bd2.shop2013.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 09.08.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "CategoryProductRelation")
@Table(name = "CATEGORY_PRODUCT_RELATION")
public class CategoryProductRelation extends AbstractShopPersistent {

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

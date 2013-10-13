package pl.solsoft.shop2013.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name = "CATEGORY")
@Table(name = "CATEGORIES")
public class Category extends AbstractShopPersistent {

    @Column(name = "NAME")
    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "ID_PARENT_CATEGORY", referencedColumnName = "ID", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private Category parentCategory;

    /**
     * Getters and Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}

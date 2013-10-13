package pl.solsoft.shop2013.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.solsoft.shop2013.domain.Category;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 13.08.13
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDTO implements IAbstractDTO<Category>,Serializable {
    @NotEmpty(message = "Enter category name")
    private String name;
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public Category createObject() {
        Category cat = new Category();
        cat.setName(name);

        return cat;
    }
}

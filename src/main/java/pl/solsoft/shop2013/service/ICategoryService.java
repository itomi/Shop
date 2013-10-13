package pl.solsoft.shop2013.service;

import pl.solsoft.shop2013.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryService extends IAbstractService<Category> {

    public List<Category> findCategoriesByParentId(Long parentId);

    public void assignChildCategories(Category category);

    public List<Category> findRootCategories();

    Category getParentIdOfCategoryId(Long parentId);
}

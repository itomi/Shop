package pl.solsoft.shop2013.dao;

import pl.solsoft.shop2013.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryDao extends IAbstractDao<Category> {

    public List<Category> findCategoriesByParentId(Long parentId);

    public List<Category> findRootCategories();

    Category getParentIdOfCategoryId(Long categoryId);
}

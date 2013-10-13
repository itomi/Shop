package pl.solsoft.shop2013.dao.impl;

import org.springframework.stereotype.Repository;
import pl.solsoft.shop2013.dao.ICategoryDao;
import pl.solsoft.shop2013.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CategoryDaoImpl extends AbstractDaoImpl<Category> implements ICategoryDao {

    @Override
    public List<Category> findCategoriesByParentId(Long parentId) {
        return (List<Category>) currentSession().createSQLQuery("SELECT * FROM categories " +
                "WHERE id_parent_category = " + parentId).addEntity(Category.class).list();
    }

    @Override
    public List<Category> findRootCategories() {
        return (List<Category>) currentSession().createSQLQuery("SELECT * FROM categories " +
                "WHERE id_parent_category is NULL").addEntity(Category.class).list();
    }

    @Override
    public Category getParentIdOfCategoryId(Long categoryId) {
        return (Category)currentSession().createSQLQuery("select * from categories " +
                "where id = " +
                    "(select id_parent_category " +
                    "from categories where id = " + categoryId + ")").addEntity(Category.class).uniqueResult() ;
    }
}

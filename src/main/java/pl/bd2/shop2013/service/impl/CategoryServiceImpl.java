package pl.bd2.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd2.shop2013.dao.IAbstractDao;
import pl.bd2.shop2013.dao.ICategoryDao;
import pl.bd2.shop2013.domain.Category;
import pl.bd2.shop2013.service.ICategoryService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    @Override
    protected IAbstractDao<Category> getDao() {
        return categoryDao;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Category> findCategoriesByParentId(Long parentId) {
        return categoryDao.findCategoriesByParentId(parentId);
    }

    @Override
    public void assignChildCategories(Category category) {
        List<Category> list = findCategoriesByParentId(category.getId());

        Category parent = category.getParentCategory();

        for (Category cat : list) {
            cat.setParentCategory(parent);
            categoryDao.update(cat);
        }
    }

    @Override
    public List<Category> findRootCategories() {
        return categoryDao.findRootCategories();
    }

    @Override
    public Category getParentIdOfCategoryId(Long categoryId) {
        return categoryDao.getParentIdOfCategoryId(categoryId);
    }
}

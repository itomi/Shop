package pl.bd2.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd2.shop2013.dao.IAbstractDao;
import pl.bd2.shop2013.dao.ICategoryProductRelationDao;
import pl.bd2.shop2013.domain.Category;
import pl.bd2.shop2013.domain.CategoryProductRelation;
import pl.bd2.shop2013.domain.Product;
import pl.bd2.shop2013.service.ICategoryProductRelationService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 12.08.13
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class CategoryProductRelationServiceImpl extends AbstractServiceImpl<CategoryProductRelation>
        implements ICategoryProductRelationService {
    @Autowired
    ICategoryProductRelationDao categoryProductRelationDao;

    @Override
    protected IAbstractDao<CategoryProductRelation> getDao() {
        return categoryProductRelationDao;
    }


    @Override
    public void createRelations(Category aCat, Product aProd) {
        CategoryProductRelation catProdR = new CategoryProductRelation();
        catProdR.setCategory(aCat);
        catProdR.setProduct(aProd);
        categoryProductRelationDao.create(catProdR);

        Category parent;
        while ((parent = catProdR.getCategory().getParentCategory()) != null) {
            catProdR = new CategoryProductRelation();
            catProdR.setCategory(parent);
            catProdR.setProduct(aProd);
            categoryProductRelationDao.create(catProdR);
        }
    }

    @Override
    public List<CategoryProductRelation> findRelations(Long id, String field) {
        return categoryProductRelationDao.findRelations(id, field);
    }

    @Override
    public void deleteRelations(Long id, String field) {
        List<CategoryProductRelation> relList = findRelations(id, field);

        for (CategoryProductRelation tRel : relList) {
            categoryProductRelationDao.delete(tRel);
        }
    }
}

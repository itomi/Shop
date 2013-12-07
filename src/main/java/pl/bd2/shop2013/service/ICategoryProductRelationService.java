package pl.bd2.shop2013.service;

import pl.bd2.shop2013.domain.Category;
import pl.bd2.shop2013.domain.CategoryProductRelation;
import pl.bd2.shop2013.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 12.08.13
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryProductRelationService extends IAbstractService<CategoryProductRelation> {

    public void createRelations(Category aCat, Product aProd);

    public List<CategoryProductRelation> findRelations(Long id, String field);

    public void deleteRelations(Long id, String field);
}

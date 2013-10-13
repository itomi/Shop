package pl.solsoft.shop2013.dao;

import pl.solsoft.shop2013.domain.CategoryProductRelation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 12.08.13
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryProductRelationDao extends IAbstractDao<CategoryProductRelation> {

    public List<CategoryProductRelation> findRelations(Long id, String field);
}

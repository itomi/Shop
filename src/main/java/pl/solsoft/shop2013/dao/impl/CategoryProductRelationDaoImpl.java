package pl.solsoft.shop2013.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.solsoft.shop2013.dao.ICategoryProductRelationDao;
import pl.solsoft.shop2013.domain.CategoryProductRelation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 12.08.13
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CategoryProductRelationDaoImpl extends AbstractDaoImpl<CategoryProductRelation>
        implements ICategoryProductRelationDao {
    @Override
    public List<CategoryProductRelation> findRelations(Long id, String field) {
        Criteria criteria = currentSession().createCriteria(CategoryProductRelation.class);
        criteria.add(Restrictions.eq(field + ".id", id));
        return criteria.list();
    }
}

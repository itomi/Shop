package pl.solsoft.shop2013.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.solsoft.shop2013.dao.IUserDao;
import pl.solsoft.shop2013.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao {

    @Override
    public User readByUsername(String username) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}

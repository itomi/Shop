package pl.bd2.shop2013.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.bd2.shop2013.dao.IAuthorityDao;
import pl.bd2.shop2013.domain.Authority;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AuthorityDaoImpl extends AbstractDaoImpl<Authority> implements IAuthorityDao {
    @Override
    public Authority getUserAuthority(String username) {
        criteria = currentSession().createCriteria(Authority.class);
        criteria.add(Restrictions.eq("username", username));
        return (Authority) criteria.uniqueResult();
    }

    @Override
    public Authority assignAuthority(String username) {
        Authority auth = new Authority();
        auth.setUsername(username);        //set username
        auth.setAuthority("ROLE_USER"); //set role user
        return auth;
    }
}

package pl.bd2.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bd2.shop2013.dao.IAbstractDao;
import pl.bd2.shop2013.dao.IAuthorityDao;
import pl.bd2.shop2013.domain.Authority;
import pl.bd2.shop2013.service.IAuthorityService;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class AuthorityServiceImpl extends AbstractServiceImpl<Authority> implements IAuthorityService {

    @Autowired
    IAuthorityDao authorityDao;

    @Override
    protected IAbstractDao<Authority> getDao() {
        return authorityDao;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Authority assignAuthority(String username) {
        return authorityDao.assignAuthority(username);
    }

    @Override
    public Authority getUserAuthority(String username) {
        return authorityDao.getUserAuthority(username);
    }
}

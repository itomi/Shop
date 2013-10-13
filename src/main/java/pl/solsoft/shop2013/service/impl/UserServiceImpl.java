package pl.solsoft.shop2013.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solsoft.shop2013.dao.IAbstractDao;
import pl.solsoft.shop2013.dao.IUserDao;
import pl.solsoft.shop2013.domain.Authority;
import pl.solsoft.shop2013.domain.User;
import pl.solsoft.shop2013.service.IUserService;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<User> implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public void deleteUserByName(String username) {
        User user = userDao.readByUsername(username);
        userDao.delete(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.readByUsername(username);
        return user;
    }

    @Override
    public void create(User user, Authority authority) {
        user.setEnabled(true); //account activated
        user.setAuthority(authority);
        userDao.create(user);
    }

    @Override
    protected IAbstractDao<User> getDao() {
        return userDao;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

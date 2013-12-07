package pl.bd2.shop2013.dao;

import pl.bd2.shop2013.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDao extends IAbstractDao<User> {

    User readByUsername(String username);
}

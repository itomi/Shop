package pl.bd2.shop2013.service;

import pl.bd2.shop2013.domain.Authority;
import pl.bd2.shop2013.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService extends IAbstractService<User> {
    void deleteUserByName(String username);

    User getUserByUsername(String username);

    void create(User user, Authority authority);
}

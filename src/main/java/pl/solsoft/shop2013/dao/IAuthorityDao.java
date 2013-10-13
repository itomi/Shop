package pl.solsoft.shop2013.dao;

import pl.solsoft.shop2013.domain.Authority;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public interface IAuthorityDao extends IAbstractDao<Authority> {
    public Authority getUserAuthority(String username);
    public Authority assignAuthority(String username);
}

package pl.solsoft.shop2013.service;

import pl.solsoft.shop2013.domain.Authority;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 05.08.13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public interface IAuthorityService extends IAbstractService<Authority> {

    public Authority assignAuthority(String username);
    public Authority getUserAuthority(String username);
}

package pl.bd2.shop2013.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name = "AUTHORITY")
@Table(name = "AUTHORITIES")
public class Authority extends AbstractShopPersistent {

    @Column(name = "username")
    private String username;

    @Column(name = "AUTHORITY")
    private String authority;

    @OneToOne(mappedBy = "authority")
    private User user;

    /**
     * Getters & Setters
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
package pl.solsoft.shop2013.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pl.solsoft.shop2013.validation.ConfirmUserPassword;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artekemovski
 * Date: 8/5/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name = "USER")
@Table(name = "USERS")
@ConfirmUserPassword
public class User extends AbstractShopPersistent {

    @Column(name = "USERNAME", unique = true)
    @Size(min = 3, message = "Login is too short")
    private String username;

    @Column(name = "PASSWORD")
    @Size(min = 4, message = "Password is too short")
    @NotEmpty(message = "Please enter password")
    private String password;

    @Transient
    @NotEmpty(message = "Please re-enter password")
    private String conpasswd;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "FIRST_NAME")
    @NotEmpty(message = "Enter your first name")
    private String firstname;

    @Column(name = "LAST_NAME")
    @NotEmpty(message = "Enter your last name")
    private String lastname;

    @Column(name = "ADDRESS")
    @NotEmpty(message = "Enter your address")
    private String address;

    @Column(name = "EMAIL")
    @Email(message = "Please set correct email address")
    @NotEmpty(message = "Enter your email address")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Authority authority;

    @Transient
    private Cart cart;

    /**
     * Getters and Setters
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpasswd() {
        return conpasswd;
    }

    public void setConpasswd(String conpasswd) {
        this.conpasswd = conpasswd;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
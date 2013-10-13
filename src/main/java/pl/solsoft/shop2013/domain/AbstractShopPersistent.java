package pl.solsoft.shop2013.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 09.08.13
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class AbstractShopPersistent extends AbstractShopObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

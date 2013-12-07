package pl.bd2.shop2013.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vequen
 * Date: 13.08.13
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public interface IAbstractDTO<T extends Serializable> {
    public T createObject();
}

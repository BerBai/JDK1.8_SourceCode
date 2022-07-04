package com.ber.learn.arrayList.model;

import java.io.Serializable;

/**
 * @author: ber
 * @date: 2022/7/4 0004 16:23
 * -------------------------------
 * Github：https://github.com/berbai
 * Blog：https://blog.csdn.net/Ber_Bai
 */
public class Address implements Serializable, Cloneable {
    public final long serialVersionUID = 1578511564815489L;

    private String city;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return city;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

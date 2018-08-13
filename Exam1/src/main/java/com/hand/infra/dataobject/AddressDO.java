package com.hand.infra.dataobject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="address")
public class AddressDO {

    @Column(name="address_id")
    private Integer id;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

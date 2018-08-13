package com.hand.infra.dataobject;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="customer")
public class CustomerDO {

    @Id
    @Column(name="customer_id")
    private Integer id;

    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

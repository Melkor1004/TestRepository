package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "asignmentcustomer")
public class AsignmentcustomerEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "customerid", insertable = false, updatable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "staffid", insertable = false, updatable = false)
    private UserEntity staff;
}

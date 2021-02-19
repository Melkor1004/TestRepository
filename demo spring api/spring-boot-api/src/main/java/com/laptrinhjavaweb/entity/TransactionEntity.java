package com.laptrinhjavaweb.entity;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

    @Column(name = "note")
    private String note;

    @Column(name = "customerid")
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "transactionid")
    private TransactionTypeEntity transactiontype;

    @ManyToOne
    @JoinColumn(name = "customerid", insertable = false, updatable = false)
    private CustomerEntity customer;

}

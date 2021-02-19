package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transactiontype")
public class TransactionTypeEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "transactiontype")
    private List<TransactionEntity> transactions;

}

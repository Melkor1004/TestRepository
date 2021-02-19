package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAnyAttribute;

@Entity
@Table(name = "asignmentbuilding")
public class AsignmentBuildingEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "buildingid", insertable = false, updatable = false)
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "staffid", insertable = false, updatable = false)
    private UserEntity staff;
}

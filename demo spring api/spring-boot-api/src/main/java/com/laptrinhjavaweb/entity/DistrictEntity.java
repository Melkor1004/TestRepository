package com.laptrinhjavaweb.entity;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public String getCode() {
        return code;
    }

    @OneToMany(mappedBy = "district")
    private List<BuildingEntity> Buildings;

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BuildingEntity> getBuildings() {
        return Buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        Buildings = buildings;
    }
}

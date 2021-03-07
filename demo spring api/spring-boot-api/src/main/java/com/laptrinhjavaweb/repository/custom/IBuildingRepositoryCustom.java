package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buildingForSearch.BuildingSearch;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IBuildingRepositoryCustom {
    List<BuildingEntity> findAllCustom(BuildingSearch building);

    String printStringSql(BuildingSearch building);
}

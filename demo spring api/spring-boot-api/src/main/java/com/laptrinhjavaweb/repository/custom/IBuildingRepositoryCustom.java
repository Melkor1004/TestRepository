package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IBuildingRepositoryCustom {
    List<BuildingEntity> findAll(String nameOfBuilding, String streetOfBuilding, Integer rentpriceFrom, Integer rentpriceTo,
                                 String codeOfDistrict, String[] codeOfRenttype, Long staffId, Integer rentAreaValueTo,
                                 Integer rentAreaValueFrom);
}

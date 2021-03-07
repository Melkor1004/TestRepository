package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.buildingForSearch.BuildingSearch;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.repository.custom.IBuildingRepositoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private IBuildingRepositoryCustom buildingCustom;
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		return buildingService.save(newBuilding);
	}

	@PostMapping("/test")
	private void printString(@RequestBody BuildingSearch building){
		buildingCustom.printStringSql(building);
	}
}

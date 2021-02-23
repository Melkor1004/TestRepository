package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
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
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		return buildingService.save(newBuilding);
	}

	@GetMapping
	public void testGetParameters(@RequestParam Map<String, String> allParas){

		Set<String> keySet = allParas.keySet();

		Iterator itr = keySet.iterator();

		while (itr.hasNext()){
			System.out.println("key is : " + itr.next() + " value : " + allParas.get(itr.next()));
		}

	}
}

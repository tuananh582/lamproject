package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.service.BuildingService;

@RestController
@RequestMapping("/api/buildings")

public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;
	@GetMapping()
	public Object getBuidings(@RequestParam (name = "name")String nameBuilding,@RequestParam(name = "numberOfBasement")Long numberOfBasement) {
		
			
		List<BuildingResponseDTO> results = buildingService.find(nameBuilding,numberOfBasement);
		
		return results;
	}
	
}

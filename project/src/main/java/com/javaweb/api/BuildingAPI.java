package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.dto.DistrictReponseDTO;
import com.javaweb.dto.request.BuildingResDTO;
import com.javaweb.repository.service.BuildingService;
import com.javaweb.repository.service.DistrictService;

@RestController
@RequestMapping("/api/buildings")

public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;
	private DistrictService districtService;

	//@GetMapping()
	public Object getBuidings(@ModelAttribute BuildingResDTO buldingResdto) {

		List<BuildingResponseDTO> results = buildingService.find(buldingResdto);
		return results;
	}

	//@GetMapping()
	public ResponseEntity<List<DistrictReponseDTO>> getDistrict(
	        @RequestParam(name = "districtid", required = false) Long districtId,
	        @RequestParam(name = "code", required = false) String code,
	        @RequestParam(name = "name", required = false) String name) {
	    List<DistrictReponseDTO> results = districtService.findall(districtId, code, name);
	    if (results.isEmpty()) {
	        return null;
	    }
	    
	    return ResponseEntity.ok(results); 
	}
}

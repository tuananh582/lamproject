package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@GetMapping()
	public Object getBuilding(@RequestParam(required = false) Map<String, Object>params,@RequestParam(name = "typecode",required = false)List<String>typeCode,@RequestParam(value = "districtid", required = false) Long districtid) {

		 if (districtid != null) {
		        params.put("districtid", districtid);
		    }
		    
		    // Đảm bảo typeCodes không null
		    if (typeCode == null) {
		    	typeCode = new ArrayList<>();
		    }
		List<BuildingResponseDTO> results = buildingService.findAll(params,typeCode);

		return results;
	}

	
}

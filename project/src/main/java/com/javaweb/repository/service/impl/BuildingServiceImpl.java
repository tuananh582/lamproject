package com.javaweb.repository.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.dto.request.BuildingResDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	
	
	
	
	@Override
	public List<BuildingResponseDTO> find(BuildingResDTO buidlingresDTO) {
		// TODO Auto-generated method stub
		
		List<BuildingEntity>buildingEntities = buildingRepository.findall(buidlingresDTO);
		
		
		
		
		
		//filter
		
		
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for (BuildingEntity buildingEntity : buildingEntities) {
			 BuildingResponseDTO buildingResponse = new BuildingResponseDTO();
			    buildingResponse.setName(buildingEntity.getName());
			    buildingResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + buildingEntity.getDistrictName());
			    buildingResponse.setFloorArea(buildingEntity.getFloorArea());
			    buildingResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
			    buildingResponse.setRentPrice(buildingEntity.getRentPrice());
			    buildingResponse.setBrokeragefree(buildingEntity.getBrokeragefee());
			    buildingResponse.setServicefree(buildingEntity.getServicefee());
			    buildingResponse.setManagerPhonenumber(buildingEntity.getManagerPhonenumber());
			    buildingResponse.setManagerName(buildingEntity.getManagerName());
			    buildingResponse.setLevel(buildingEntity.getLevel());
			    results.add(buildingResponse);
		}
		return results;

		
	}

	
	

	
	
	
	

}

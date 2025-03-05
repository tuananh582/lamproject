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
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildindEntities = buildingRepository.findall(params, typeCode);

		// filter
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for (BuildingEntity buildingEntity : buildindEntities) {
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			buildingResponseDTO.setId(buildingEntity.getId());
			buildingResponseDTO.setName(buildingEntity.getName());
			buildingResponseDTO.setNumberOfbasement(buildingEntity.getNumberOfbasement());
			buildingResponseDTO.setRentPrice(buildingEntity.getRentPrice());
			buildingResponseDTO.setAddress(
			buildingEntity.getStreet() + "," + buildingEntity.getWard() + "," + buildingEntity.getDistrictId());
			results.add(buildingResponseDTO);
		}

		return results;
		
	}

	
	

	
	
	
	

}

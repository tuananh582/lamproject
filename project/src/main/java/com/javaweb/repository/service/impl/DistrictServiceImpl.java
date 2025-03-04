package com.javaweb.repository.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.dto.DistrictReponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.service.DistrictService;

public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	
	
	@Override
	public List<DistrictReponseDTO> findall(Long Id, String Code, String Name) {
		// TODO Auto-generated method stub
		List<DistrictEntity> districtentities = districtRepository.find(Id, Code, Name);
		List<DistrictReponseDTO> results = new ArrayList<>();
		
		for(DistrictEntity districtEntity : districtentities) {
			DistrictReponseDTO districtResponse = new DistrictReponseDTO();
			districtResponse.setId(districtEntity.getId());
			districtResponse.setCode(districtEntity.getCode());
			districtResponse.setName(districtEntity.getName());
			results.add(districtResponse);
			
		}
		
		return results;
	}

}

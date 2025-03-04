package com.javaweb.repository.service;

import java.util.List;
import java.util.Map;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.dto.request.BuildingResDTO;

public interface BuildingService {
	List<BuildingResponseDTO> find(BuildingResDTO buidlingresDTo);

	
}

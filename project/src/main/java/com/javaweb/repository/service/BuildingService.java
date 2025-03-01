package com.javaweb.repository.service;

import java.util.List;
import java.util.Map;

import com.javaweb.dto.BuildingResponseDTO;

public interface BuildingService {
	List<BuildingResponseDTO> find(String nameBuilding, Long numberOfBasement);
}

package com.javaweb.repository.service;

import java.util.List;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.dto.DistrictReponseDTO;

public interface DistrictService {
	List<DistrictReponseDTO> findall(Long Id , String Code, String Name);
}

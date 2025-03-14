package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.entity.BuildingEntity;
@Repository
public interface BuildingRepository {
	List<BuildingEntity> findall(Map<String, Object>params,List<String>typeCode);
}

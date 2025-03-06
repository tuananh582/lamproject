package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.dto.request.BuildingResDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.utils.StringUtil;
import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository
	


public class BuildingRepositoryImpl implements BuildingRepository {

	private void buildingJoin(Map<String, Object> params, List<String> typeCode, StringBuilder join) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.isnotBlank(staffId)) {
			join.append(" join assignmentbuilding asb on asb.buildingid = b.id");
		}
		if (!typeCode.isEmpty()) {
			join.append(" join buildingrenttype brt on brt.buildingid = b.id");
			join.append(" join renttype rt on rt.id = brt.renttypeid");
		}
		String rentAreaFrom = (String) params.get("rentAreaFrom");
		String rentAreaTo = (String) params.get("rentAreaTo");
		if (StringUtil.isnotBlank(rentAreaFrom) || StringUtil.isnotBlank(rentAreaTo)) {
			join.append("join rentarea on rentarea.buildingid = b.id");
		}
	}
	private void buildCondition(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
		for (Map.Entry<String, Object> items : params.entrySet()) {
			String key = items.getKey();
			if (!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
					&& !key.startsWith("rentPrice")) {
				Object value = items.getValue();
				if (StringUtil.isnotBlank(value.toString())) {
					if (StringUtil.isNumber(value.toString())) {
						where.append(" AND b." + key + " = " + value.toString());
					} else {
						where.append(" AND b." + key + " Like '%" + value.toString() + "%'");
					}
				}
			}
		}
		String staffId = (String) params.get("staffId");
		if (StringUtil.isnotBlank(staffId)) {
			where.append(" AND asb.staffid = "+staffId);
		}
		String rentAreaFrom = (String) params.get("rentAreaFrom");
		String rentAreaTo = (String) params.get("rentAreaTo");
		if (StringUtil.isnotBlank(rentAreaFrom) ) {
			where.append(" AND rentarea.value >= "+rentAreaFrom);
		}
		if(StringUtil.isnotBlank(rentAreaTo)) {
			where.append(" AND rentarea.value <= "+rentAreaTo);
		}
		if(!typeCode.isEmpty()) {
			where.append(" AND rt.code IN (");
			for(int i = 0;i<typeCode.size();i++) {
				where.append("'"+typeCode.get(i)+"'");
				if(i<typeCode.size()-1) {
					where.append(",");
				}
			}
			where.append(")");
		}
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		String rentPriceTo = (String) params.get("rentPriceTo");
		if (StringUtil.isnotBlank(rentPriceFrom) ) {
			where.append(" AND b.rentprice >= "+rentPriceFrom);
		}
		if(StringUtil.isnotBlank(rentPriceTo)) {
			where.append(" AND b.rentprice  <= "+rentPriceTo);
		}
	}
	
	
	@Override
	public List<BuildingEntity> findall(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		StringBuilder where = new StringBuilder(" WHERE 1=1");
		buildingJoin(params, typeCode, sql);
		buildCondition(params, typeCode, where);
		sql.append(where).append(" GROUP BY b.id");
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			System.out.print("Connected database successfully");
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getLong("districtid"));
				building.setNumberOfbasement(rs.getLong("numberofbasement"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setRentPrice(rs.getLong("rentprice"));
				results.add(building);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.print("Connected database failed");
			ex.printStackTrace();
		}
		return results;
	}

	
		
}

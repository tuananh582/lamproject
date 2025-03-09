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
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.javaweb.dto.request.BuildingResDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.utils.StringUtil;
import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository

public class BuildingRepositoryImpl implements BuildingRepository {

	private void appendJoins(Map<String, Object> filters, List<String> typeCodes, StringBuilder query) {
		if (StringUtil.isnotBlank((String) filters.get("staffId"))) {
			query.append(" JOIN assignmentbuilding ab ON ab.buildingid = b.id");
		}
		if (!typeCodes.isEmpty()) { // Chỉ JOIN renttype nếu có typeCodes
			query.append(" JOIN buildingrenttype brt ON brt.buildingid = b.id");
			query.append(" JOIN renttype rt ON rt.id = brt.renttypeid");
		}
		if (filters.containsKey("rentAreaFrom") || filters.containsKey("rentAreaTo")) {
			query.append(" JOIN rentarea ra ON ra.buildingid = b.id");
		}
	}

	private void appendConditions(Map<String, Object> filters, List<String> typeCodes, StringBuilder conditions) {
	    filters.forEach((key, value) -> {
	    	  if (value != null && !value.toString().isBlank() && !key.equals("staffId") && !key.equals("typeCodes")
	                  && !key.startsWith("rentArea") && !key.startsWith("rentPrice") && !key.equals("typecode")) {
	              conditions.append(" AND b.").append(key);
	              
	              // Nếu là districtid, xử lý như một số nguyên
	              if (key.equals("districtid")) {
	                  conditions.append(" = ").append(value);
	              } else {
	                  conditions.append(StringUtil.isNumber(value.toString()) ? " = " + value : " LIKE '%" + value + "%'");
	              }
	          }
	      });

	    Optional.ofNullable(filters.get("staffId"))
	            .ifPresent(staffId -> conditions.append(" AND ab.staffid = ").append(staffId));

	    Optional.ofNullable(filters.get("rentAreaFrom"))
	            .ifPresent(area -> conditions.append(" AND ra.value >= ").append(area));
	    Optional.ofNullable(filters.get("rentAreaTo"))
	            .ifPresent(area -> conditions.append(" AND ra.value <= ").append(area));

	    if (!typeCodes.isEmpty()) {
	        conditions.append(" AND rt.code IN ('").append(String.join("','", typeCodes)).append("')");
	    }

	    Optional.ofNullable(filters.get("rentPriceFrom"))
	            .ifPresent(price -> conditions.append(" AND b.rentprice >= ").append(price));
	    Optional.ofNullable(filters.get("rentPriceTo"))
	            .ifPresent(price -> conditions.append(" AND b.rentprice <= ").append(price));
	}

	@Override
	public List<BuildingEntity> findall(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.*, " + "d.name AS district_name, "
				+ "GROUP_CONCAT(DISTINCT ra.value ORDER BY ra.value SEPARATOR ', ') AS rent_values, "
				+ "GROUP_CONCAT(DISTINCT b.rentprice SEPARATOR ', ') AS rent_prices " + "FROM building b "
				+ "JOIN district d ON b.districtid = d.id " + "LEFT JOIN rentarea ra ON ra.buildingid = b.id ");

		appendJoins(params, typeCode, sql);

		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		appendConditions(params, typeCode, where);

		sql.append(where).append(" GROUP BY b.id, d.name");

		System.out.println("SQL Query: " + sql); // Debug SQL

		List<BuildingEntity> results = new ArrayList<>();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			System.out.println("Connected to database successfully");

			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getLong("districtid"));
				building.setNumberOfbasement(rs.getLong("numberofbasement"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setRentPrice(rs.getLong("rentprice"));
				building.setFloorarea(rs.getLong("floorarea"));
				building.setDistrictName(rs.getString("district_name"));
				building.setManagerName(rs.getString("managername"));
				building.setManagerPhonenumber(rs.getString("managerphonenumber"));
				building.setBrokeragefee(rs.getLong("brokeragefee"));
				building.setServicefee(rs.getLong("servicefee"));
				building.setRentValues(rs.getString("rent_values"));
				building.setRentPrices(rs.getString("rent_prices"));
				results.add(building);
			}
		} catch (SQLException ex) {
			System.out.println("Database connection failed");
			ex.printStackTrace();
		}
		return results;
	}
}

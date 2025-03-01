package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	@Override
	public List<BuildingEntity> findall(String namebuilDing, Long numberOfBasements) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b WHERE 1=1");
		if (namebuilDing != null && !namebuilDing.equals("")) {
			sql.append(" AND b.name LIKE '%" + namebuilDing + "%'");
		}
		if (numberOfBasements != null) {
			sql.append(" AND b.numberofbasement = " + numberOfBasements);
		}
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
				building.setDirection(rs.getString("direction"));
				building.setFloorarea(rs.getLong("floorarea"));
				building.setManagername(rs.getString("managername"));
				building.setManagerphonenumber(rs.getString("managerphonenumber"));
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

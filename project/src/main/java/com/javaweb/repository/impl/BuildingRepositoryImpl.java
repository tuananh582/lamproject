package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.dto.request.BuildingResDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	@Override
	public List<BuildingEntity> findall(BuildingResDTO buildingresDTO) {
		 StringBuilder sql = new StringBuilder(
	                "SELECT b.id, b.name, b.districtid, b.numberofbasement, b.floorarea, " +
	                "b.brokeragefee, b.level, b.managerphonenumber, b.managername, b.ward, b.street, " +
	                "b.servicefee, b.rentprice, d.name AS district_name, a.staffid, " +
	                "GROUP_CONCAT(DISTINCT rt.code) AS buildingtype " + 
	                "FROM building b " +
	                "LEFT JOIN district d ON b.districtid = d.id " +
	                "LEFT JOIN assignmentbuilding a ON b.id = a.buildingid " +
	                "LEFT JOIN estatebasic.user u ON a.staffid = u.id " +
	                "LEFT JOIN rentarea r ON b.id = r.buildingid " +
	                "LEFT JOIN buildingrenttype brt ON b.id = brt.buildingid " +
	                "LEFT JOIN renttype rt ON brt.renttypeid = rt.id " +
	                "WHERE 1=1 ");

	        if (buildingresDTO.getName() != null) {
	            sql.append(" AND b.name LIKE '%").append(buildingresDTO.getName()).append("%'");
	        }
	         if (buildingresDTO.getDistrictid() != null) {
	            sql.append(" AND b.districtid = ").append(buildingresDTO.getDistrictid());
	        }
	         if (buildingresDTO.getNumberOfBasement() != null) {
	            sql.append(" AND b.numberofbasement = ").append(buildingresDTO.getNumberOfBasement());
	        }
	         if (buildingresDTO.getFloorArea() != null) {
	            sql.append(" AND b.floorarea = ").append(buildingresDTO.getFloorArea());
	        }
	         if (buildingresDTO.getBrokeragefee() != null) {
	            sql.append(" AND b.brokeragefee = ").append(buildingresDTO.getBrokeragefee());
	        }
	         if (buildingresDTO.getLevel() != null) {
	            sql.append(" AND b.level = ").append(buildingresDTO.getLevel());
	        }
	         if (buildingresDTO.getManagerPhonenumber() != null) {
	            sql.append(" AND b.managerphonenumber = ").append(buildingresDTO.getManagerPhonenumber());
	        }
	         if (buildingresDTO.getManagerName() != null) {
	            sql.append(" AND b.managername LIKE '%").append(buildingresDTO.getManagerName()).append("%'");
	        }
	         if (buildingresDTO.getServicefee() != null) {
	            sql.append(" AND b.servicefee = ").append(buildingresDTO.getServicefee());
	        }
	         if (buildingresDTO.getAreaFrom() != null && buildingresDTO.getAreaTo() != null) {
	            sql.append(" AND r.value BETWEEN ").append(buildingresDTO.getAreaFrom())
	               .append(" AND ").append(buildingresDTO.getAreaTo());
	        }
	         if (buildingresDTO.getPriceFrom() != null && buildingresDTO.getPriceTo() != null) {
	            sql.append(" AND b.rentprice BETWEEN ").append(buildingresDTO.getPriceFrom())
	               .append(" AND ").append(buildingresDTO.getPriceTo());
	        }
	         if (buildingresDTO.getBuildingtype() != null) {
	            sql.append(" AND rt.code = '").append(buildingresDTO.getBuildingtype()).append("'");
	        }
	         if (buildingresDTO.getStaffid() !=null) {
	        	sql.append(" AND staffid = ").append(buildingresDTO.getStaffid());
	        }
	        else {
	        	 sql.append(" GROUP BY b.id, b.name, b.districtid, b.numberofbasement, b.floorarea, b.ward, b.street, " +
		                   "b.brokeragefee, b.level, b.managerphonenumber, b.managername, " +
		                   "b.servicefee, b.rentprice, d.name,a.staffid");
	        }
	       
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			System.out.print("Connected database successfully");
			while (rs.next()) {
				 BuildingEntity building = new BuildingEntity();

	                building.setName(rs.getString("name"));
	                building.setFloorArea(rs.getLong("floorarea"));
	                building.setNumberOfBasement(rs.getLong("numberofbasement"));
	                building.setRentPrice(rs.getLong("rentprice"));
	                building.setWard(rs.getString("ward"));
	                building.setStreet(rs.getString("street"));
	                building.setDistrictId(rs.getLong("districtid"));
	                building.setDistrictName(rs.getNString("district_name"));
	                building.setBrokeragefee(rs.getLong("brokeragefee"));
	                building.setLevel(rs.getLong("level"));
	                building.setManagerName(rs.getString("managername"));
	                building.setManagerPhonenumber(rs.getLong("managerphonenumber"));
	                building.setBuildingtype(Arrays.asList("buildingtype"));
	                building.setStaffid(rs.getLong("staffid"));
	              
	                	
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

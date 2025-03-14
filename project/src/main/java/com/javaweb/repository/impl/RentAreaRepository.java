package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository
public class RentAreaRepository {
	 public List<String> findRentAreasByBuildingId(Long buildingId) {
	        List<String> rentAreas = new ArrayList<>();
	        String sql = "SELECT value FROM rentarea WHERE buildingid = ?";
	        
	        try (Connection con = ConnectionDriverUtils.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setLong(1, buildingId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                rentAreas.add(rs.getString("value"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rentAreas;
	    }
}

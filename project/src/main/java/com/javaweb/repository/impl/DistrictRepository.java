package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.utils.ConnectionDriverUtils;

@Repository
public class DistrictRepository {
	 public String findNameById(Long districtId) {
	        String sql = "SELECT name FROM district WHERE id = ?";
	        try (Connection con = ConnectionDriverUtils.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setLong(1, districtId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return rs.getString("name");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}

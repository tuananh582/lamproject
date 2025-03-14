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
public class RentTypeRepository {
	public List<String> findRentTypesByBuildingId(Long buildingId) {
        List<String> rentTypes = new ArrayList<>();
        String sql = "SELECT rt.code FROM renttype rt JOIN buildingrenttype brt ON rt.id = brt.renttypeid WHERE brt.buildingid = ?";
        
        try (Connection con = ConnectionDriverUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, buildingId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rentTypes.add(rs.getString("code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }
}

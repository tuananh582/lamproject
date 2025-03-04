package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.utils.ConnectionDriverUtils;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public List<DistrictEntity> find(Long id, String code, String name) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT d.* FROM district d WHERE 1=1");
		 if (id != null) {
	            sql.append(" where id = " + id);
	        }
		 List<DistrictEntity> results = new ArrayList<DistrictEntity>();
		 try (Connection con = ConnectionDriverUtils.getConnection();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql.toString())) {
			 while (rs.next()) {
	                DistrictEntity district = new DistrictEntity();
	                district.setId(rs.getLong("id"));
	                district.setName(rs.getString("name"));
	                district.setCode(rs.getString("code"));
	                results.add(district);
	            }
			 
		 } catch (SQLException ex) {
	            System.out.println("Kết nối database thất bại...");
	            ex.printStackTrace();
	        }
		 
		 return results;
	}

}

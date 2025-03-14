package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.utils.ConnectionDriverUtils;
import com.javaweb.repository.utils.StringUtil;

public class BuildingRepositoryImpl implements BuildingRepository {
	
	 private final DistrictRepository districtRepository;
	    private final RentAreaRepository rentAreaRepository;
	    private final RentTypeRepository rentTypeRepository;

	    public BuildingRepositoryImpl(DistrictRepository districtRepository,
	                                  RentAreaRepository rentAreaRepository,
	                                  RentTypeRepository rentTypeRepository) {
	        this.districtRepository = districtRepository;
	        this.rentAreaRepository = rentAreaRepository;
	        this.rentTypeRepository = rentTypeRepository;
	    }

	    private void appendConditions(Map<String, Object> filters, StringBuilder conditions) {
	        filters.forEach((key, value) -> {
	            if (value != null && !value.toString().isBlank() && !key.equals("staffId")
	                    && !key.startsWith("rentArea") && !key.startsWith("rentPrice") && !key.equals("typecode")) {
	                conditions.append(" AND ").append(key);

	                if (key.equals("districtid")) {
	                    conditions.append(" = ").append(value);
	                } else {
	                    conditions.append(StringUtil.isNumber(value.toString()) ? " = " + value : " LIKE '%" + value + "%'");
	                }
	            }
	        });

	        Optional.ofNullable(filters.get("rentPriceFrom"))
	                .ifPresent(price -> conditions.append(" AND rentprice >= ").append(price));
	        Optional.ofNullable(filters.get("rentPriceTo"))
	                .ifPresent(price -> conditions.append(" AND rentprice <= ").append(price));
	    }
	

	@Override
	public List<BuildingEntity> findall(Map<String, Object> params, List<String> typeCode) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1=1 ");
        appendConditions(params, sql);

        System.out.println("SQL Query: " + sql);

        List<BuildingEntity> results = new ArrayList<>();
        try (Connection con = ConnectionDriverUtils.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql.toString())) {

            while (rs.next()) {
                BuildingEntity building = new BuildingEntity();
                building.setId(rs.getLong("id"));
                building.setName(rs.getString("name"));
                building.setDistrictId(rs.getLong("districtid"));
                building.setNumberOfbasement(rs.getLong("numberofbasement"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setRentPrice(rs.getLong("rentprice"));
                building.setFloorarea(rs.getLong("floorarea"));
                building.setManagerName(rs.getString("managername"));
                building.setManagerPhonenumber(rs.getString("managerphonenumber"));
                building.setBrokeragefee(rs.getLong("brokeragefee"));
                building.setServicefee(rs.getLong("servicefee"));

                // Lấy thông tin từ các repository khác
                building.setDistrictName(districtRepository.findNameById(building.getDistrictId()));
                building.setRentValues(String.join(", ", rentAreaRepository.findRentAreasByBuildingId(building.getId())));
                building.setRentPrices(String.join(", ", rentTypeRepository.findRentTypesByBuildingId(building.getId())));

                results.add(building);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
	}

}

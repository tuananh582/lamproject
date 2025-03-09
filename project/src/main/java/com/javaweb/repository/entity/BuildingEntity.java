package com.javaweb.repository.entity;

import java.util.List;

public class BuildingEntity {
	private String name;
	private Long numberOfbasement;
	private Long rentPrice;
	private Long districtId;
	private String street;
	private String ward;
	private Long id;
	private Long servicefee;
	private Long brokeragefee;
	private Long level;
	private Long staffid;
	private String managerPhonenumber;
	private Long floorArea;

	private String districtName;

	private String managerName;
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Long getServicefee() {
		return servicefee;
	}
	public void setServicefee(Long servicefee) {
		this.servicefee = servicefee;
	}
	public Long getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Long brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	public Long getStaffid() {
		return staffid;
	}
	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}
	public String getManagerPhonenumber() {
		return managerPhonenumber;
	}
	public void setManagerPhonenumber(String managerPhonenumber) {
		this.managerPhonenumber = managerPhonenumber;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Long floorarea) {
		this.floorarea = floorarea;
	}
	public Long getRentarea() {
		return rentarea;
	}
	public void setRentarea(Long rentarea) {
		this.rentarea = rentarea;
	}
	public String getRentValues() {
		return rentValues;
	}
	public void setRentValues(String rentValues) {
		this.rentValues = rentValues;
	}
	public String getRentPrices() {
		return rentPrices;
	}
	public void setRentPrices(String rentPrices) {
		this.rentPrices = rentPrices;
	}
	private Long floorarea;
	private Long rentarea;
	private String rentValues;
	private String rentPrices;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumberOfbasement() {
		return numberOfbasement;
	}
	public void setNumberOfbasement(Long numberOfbasement) {
		this.numberOfbasement = numberOfbasement;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	

}

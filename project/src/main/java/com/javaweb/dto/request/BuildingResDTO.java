package com.javaweb.dto.request;

import java.util.List;

public class BuildingResDTO {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(Long priceFrom) {
		this.priceFrom = priceFrom;
	}

	public Long getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Long priceTo) {
		this.priceTo = priceTo;
	}

	public Long getAreaFrom() {
		return AreaFrom;
	}

	public void setAreaFrom(Long areaFrom) {
		AreaFrom = areaFrom;
	}

	public Long getAreaTo() {
		return AreaTo;
	}

	public void setAreaTo(Long areaTo) {
		AreaTo = areaTo;
	}

	public Long getManagerPhonenumber() {
		return managerPhonenumber;
	}

	public void setManagerPhonenumber(Long managerPhonenumber) {
		this.managerPhonenumber = managerPhonenumber;
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

	public Long getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	public List<String> getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(List<String> buildingtype) {
		this.buildingtype = buildingtype;
	}

	public Long getStaffid() {
		return staffid;
	}

	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}

	private String name;
	private Long numberOfBasement;
	private Long rentPrice;
	private Long floorArea;
	private String address;
	private String managerName;
	private Long priceFrom;
	private Long priceTo;
	private Long AreaFrom;
	private Long AreaTo;
	private Long managerPhonenumber;
	private Long servicefee;
	private Long brokeragefee;
	private Long level;
	private Long districtid;
	private String districtName;
	private String street;
	private String ward;
	private List<String> buildingtype;
	private Long staffid;

}

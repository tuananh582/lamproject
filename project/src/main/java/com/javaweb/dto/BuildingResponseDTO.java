package com.javaweb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingResponseDTO {
	private String name;

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

	public Long getManagerPhonenumber() {
		return managerPhonenumber;
	}

	public void setManagerPhonenumber(Long managerPhonenumber) {
		this.managerPhonenumber = managerPhonenumber;
	}

	public Long getServicefree() {
		return servicefree;
	}

	public void setServicefree(Long servicefree) {
		this.servicefree = servicefree;
	}

	public Long getBrokeragefree() {
		return brokeragefree;
	}

	public void setBrokeragefree(Long brokeragefree) {
		this.brokeragefree = brokeragefree;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public List<String> getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(List<String> buildingtype) {
		this.buildingtype = buildingtype;
	}

	private Long numberOfBasement;
	private Long rentPrice;
	private Long floorArea;
	@JsonProperty(value = "Address _building")
	private String address;
	private String managerName;
	private Long managerPhonenumber;
	private Long servicefree;
	private Long brokeragefree;
	private Long level;
	private List<String> buildingtype;
}

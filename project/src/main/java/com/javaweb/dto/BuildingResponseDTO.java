package com.javaweb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingResponseDTO {
	private Long id;
	private String name;
	private Long numberOfbasement;
	private Long rentPrice;
	@JsonProperty(value = "Address_building")
	private String address;
	private String managerName;
	private String managerPhoneNumber;
	private Long servicefree;
	private Long floorArea;
	private Long districtId;
	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	private String rentPrices;
	public String getRentPrices() {
		return rentPrices;
	}

	public void setRentPrices(String rentPrices) {
		this.rentPrices = rentPrices;
	}

	private Long brokeragefree;
	private String rentValues;
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
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

	public String getRentValues() {
		return rentValues;
	}

	public void setRentValues(String rentValues) {
		this.rentValues = rentValues;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

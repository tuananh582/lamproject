package com.javaweb.repository.entity;

import java.util.List;

public class BuildingEntity {
	private Long id;
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
	private String name;
	private Long numberOfbasement;
	private Long rentPrice;
	private Long districtId;
	private String street;
	private String ward;

}

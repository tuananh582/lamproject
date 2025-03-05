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

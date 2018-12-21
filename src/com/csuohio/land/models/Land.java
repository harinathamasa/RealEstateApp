package com.csuohio.land.models;

public class Land {
	private String parcelId;
	private Long salesAmount;
	private Long totalLand;
	private String water;
	private String gas;
	private String electricity;
	private float similarity;
	private String parcelAddr;
	private String parcelType;

	public String getParcelAddr() {
		return parcelAddr;
	}

	public void setParcelAddr(String parcelAddr) {
		this.parcelAddr = parcelAddr;
	}

	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}

	public Long getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(Long salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Long getTotalLand() {
		return totalLand;
	}

	public void setTotalLand(Long totalLand) {
		this.totalLand = totalLand;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getElectricity() {
		return electricity;
	}

	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}
}

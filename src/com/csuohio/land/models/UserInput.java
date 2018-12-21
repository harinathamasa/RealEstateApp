package com.csuohio.land.models;


public class UserInput {

	private String city;
	private String landCategory;
	private boolean isSquareFeet = false;
	private boolean isAcre = false;
	
	private int squareFeet;
	private int acre;
	private int lowerRange;
	private int higherRange;
	private Amenities emenities;
	
	public Amenities getEmenities() {
		return emenities;
	}
	public void setEmenities(Amenities emenities) {
		this.emenities = emenities;
	}
	public int getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}
	public int getAcre() {
		return acre;
	}
	public void setAcre(int acre) {
		this.acre = acre;
	}
	public int getLowerRange() {
		return lowerRange;
	}
	public void setLowerRange(int lowerRange) {
		this.lowerRange = lowerRange;
	}
	public int getHigherRange() {
		return higherRange;
	}
	public void setHigherRange(int higherRange) {
		this.higherRange = higherRange;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLandCategory() {
		return landCategory;
	}
	public void setLandCategory(String landCategory) {
		this.landCategory = landCategory;
	}
	public boolean isSquareFeet() {
		return isSquareFeet;
	}
	public void setSquareFeet(boolean isSquareFeet) {
		this.isSquareFeet = isSquareFeet;
	}
	public boolean isAcre() {
		return isAcre;
	}
	public void setAcre(boolean isAcre) {
		this.isAcre = isAcre;
	}

	
}

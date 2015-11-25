package com.flk.safety.detail.vo;

public class Subway_CrimeVO {
	int id;
	String category;
	String station;
	String latitude;
	String longitude;
	int theft;
	int sexual_violence;
	int violence;
	String source;
	String year;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getTheft() {
		return theft;
	}
	public void setTheft(int theft) {
		this.theft = theft;
	}
	public int getSexual_violence() {
		return sexual_violence;
	}
	public void setSexual_violence(int sexual_violence) {
		this.sexual_violence = sexual_violence;
	}
	public int getViolence() {
		return violence;
	}
	public void setViolence(int violence) {
		this.violence = violence;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}

package com.flk.safety.detail.vo;

public class TrafficVO {
	int id;
	String category;
	String location;
	String latitude;
	String longitude;
	int occurrence;
	int casualties;
	int dead;
	int jungsang;
	int gyengsang;
	int busin;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public int getOccurrence() {
		return occurrence;
	}
	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}
	public int getCasualties() {
		return casualties;
	}
	public void setCasualties(int casualties) {
		this.casualties = casualties;
	}
	public int getDead() {
		return dead;
	}
	public void setDead(int dead) {
		this.dead = dead;
	}
	public int getJungsang() {
		return jungsang;
	}
	public void setJungsang(int jungsang) {
		this.jungsang = jungsang;
	}
	public int getGyengsang() {
		return gyengsang;
	}
	public void setGyengsang(int gyengsang) {
		this.gyengsang = gyengsang;
	}
	public int getBusin() {
		return busin;
	}
	public void setBusin(int busin) {
		this.busin = busin;
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

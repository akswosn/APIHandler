package com.flk.safety.detail.vo;

public class Range_CrimeVO {
	int id;
	String category;
	int location_no;
	int larceny;
	double larceny_count;
	int murder;
	double murder_count;
	int robbery;
	double robbery_count;
	int rape;
	double rape_count;
	int violence;
	double violence_count;
	String source;
	String year;
	String rating;
	String location;
	String sub_location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSub_location() {
		return sub_location;
	}
	public void setSub_location(String sub_location) {
		this.sub_location = sub_location;
	}
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
	public int getLocation_no() {
		return location_no;
	}
	public void setLocation_no(int location_no) {
		this.location_no = location_no;
	}
	public int getLarceny() {
		return larceny;
	}
	public void setLarceny(int larceny) {
		this.larceny = larceny;
	}
	public double getLarceny_count() {
		return larceny_count;
	}
	public void setLarceny_count(double larceny_count) {
		this.larceny_count = larceny_count;
	}
	public int getMurder() {
		return murder;
	}
	public void setMurder(int murder) {
		this.murder = murder;
	}
	public double getMurder_count() {
		return murder_count;
	}
	public void setMurder_count(double murder_count) {
		this.murder_count = murder_count;
	}
	public int getRobbery() {
		return robbery;
	}
	public void setRobbery(int robbery) {
		this.robbery = robbery;
	}
	public double getRobbery_count() {
		return robbery_count;
	}
	public void setRobbery_count(double robbery_count) {
		this.robbery_count = robbery_count;
	}
	public int getRape() {
		return rape;
	}
	public void setRape(int rape) {
		this.rape = rape;
	}
	public double getRape_count() {
		return rape_count;
	}
	public void setRape_count(double rape_count) {
		this.rape_count = rape_count;
	}
	public int getViolence() {
		return violence;
	}
	public void setViolence(int violence) {
		this.violence = violence;
	}
	public double getViolence_count() {
		return violence_count;
	}
	public void setViolence_count(double violence_count) {
		this.violence_count = violence_count;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

}

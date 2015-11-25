package com.flk.safety.detail.vo;

import com.flk.safety.common.BaseVO;

public class Range_EnvironmentVO extends BaseVO{
	int id;
	String category;
	int location_no;
	String category_name;
	String name;
	String measurement_date;
	String atmosphere;
	String atmosphere_rating;
	String substance;
	String nitrogen_dioxide;
	String ozone;
	String carbon_monoxide;
	String sourcesulfur_dioxide;
	String dust;
	String source;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasurement_date() {
		return measurement_date;
	}
	public void setMeasurement_date(String measurement_date) {
		this.measurement_date = measurement_date;
	}
	public String getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}
	public String getAtmosphere_rating() {
		return atmosphere_rating;
	}
	public void setAtmosphere_rating(String atmosphere_rating) {
		this.atmosphere_rating = atmosphere_rating;
	}
	public String getSubstance() {
		return substance;
	}
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	public String getNitrogen_dioxide() {
		return nitrogen_dioxide;
	}
	public void setNitrogen_dioxide(String nitrogen_dioxide) {
		this.nitrogen_dioxide = nitrogen_dioxide;
	}
	public String getOzone() {
		return ozone;
	}
	public void setOzone(String ozone) {
		this.ozone = ozone;
	}
	public String getCarbon_monoxide() {
		return carbon_monoxide;
	}
	public void setCarbon_monoxide(String carbon_monoxide) {
		this.carbon_monoxide = carbon_monoxide;
	}
	public String getSourcesulfur_dioxide() {
		return sourcesulfur_dioxide;
	}
	public void setSourcesulfur_dioxide(String sourcesulfur_dioxide) {
		this.sourcesulfur_dioxide = sourcesulfur_dioxide;
	}
	public String getDust() {
		return dust;
	}
	public void setDust(String dust) {
		this.dust = dust;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
}

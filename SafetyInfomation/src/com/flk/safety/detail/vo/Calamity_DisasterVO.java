package com.flk.safety.detail.vo;

import com.flk.safety.common.BaseVO;


public class Calamity_DisasterVO extends BaseVO {
	int id;
	String category;
	String address;
	String latitude;
	String longitude;
	String type;
	String facility_name;
	String facility_type;
	String water_system;
	String specified_date;
	String reason;
	String risk;
	String propulsion;
	String organ;
	String organ_tel;
	String source;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getFacility_type() {
		return facility_type;
	}
	public void setFacility_type(String facility_type) {
		this.facility_type = facility_type;
	}
	public String getWater_system() {
		return water_system;
	}
	public void setWater_system(String water_system) {
		this.water_system = water_system;
	}
	public String getSpecified_date() {
		return specified_date;
	}
	public void setSpecified_date(String specified_date) {
		this.specified_date = specified_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getPropulsion() {
		return propulsion;
	}
	public void setPropulsion(String propulsion) {
		this.propulsion = propulsion;
	}
	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	public String getOrgan_tel() {
		return organ_tel;
	}
	public void setOrgan_tel(String organ_tel) {
		this.organ_tel = organ_tel;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}

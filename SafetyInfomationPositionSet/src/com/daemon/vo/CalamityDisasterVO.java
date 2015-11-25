/*
 * com.daemon.vo.CalamityDisasterVO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 재난 - 재해 위험 지구
 * 
 * Create Date 2012. 10. 16.
 * @version	1.00 2012. 10. 16.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 16.			최초.
 */

public class CalamityDisasterVO extends CommonVO
{
	private int id;					//고유번호
	private String category;		//구분
	private String address;			//주소
	private String latitude;		//위도
	private String longitude;		//경도
	private String type;			//유형
	private String facilityName;	//시설명
	private String facilityType;	//시설물 유형
	private String waterSystem;	//수계명
	private String specifiedDate;	//지정일자
	private String reason;			//지정사유
	private String risk;			//위험요인
	private String propulsion;		//추진상황
	private String organ;			//시설관리기관			
	private String organTel;		//시설관리기관 연락처
	private String source;			//출처
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}
	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	/**
	 * @return the facilityType
	 */
	public String getFacilityType() {
		return facilityType;
	}
	/**
	 * @param facilityType the facilityType to set
	 */
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	/**
	 * @return the waterSystem
	 */
	public String getWaterSystem() {
		return waterSystem;
	}
	/**
	 * @param waterSystem the waterSystem to set
	 */
	public void setWaterSystem(String waterSystem) {
		this.waterSystem = waterSystem;
	}
	/**
	 * @return the specifiedDate
	 */
	public String getSpecifiedDate() {
		return specifiedDate;
	}
	/**
	 * @param specifiedDate the specifiedDate to set
	 */
	public void setSpecifiedDate(String specifiedDate) {
		this.specifiedDate = specifiedDate;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the risk
	 */
	public String getRisk() {
		return risk;
	}
	/**
	 * @param risk the risk to set
	 */
	public void setRisk(String risk) {
		this.risk = risk;
	}
	/**
	 * @return the propulsion
	 */
	public String getPropulsion() {
		return propulsion;
	}
	/**
	 * @param propulsion the propulsion to set
	 */
	public void setPropulsion(String propulsion) {
		this.propulsion = propulsion;
	}
	/**
	 * @return the organ
	 */
	public String getOrgan() {
		return organ;
	}
	/**
	 * @param organ the organ to set
	 */
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	/**
	 * @return the organTel
	 */
	public String getOrganTel() {
		return organTel;
	}
	/**
	 * @param organTel the organTel to set
	 */
	public void setOrganTel(String organTel) {
		this.organTel = organTel;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	
}

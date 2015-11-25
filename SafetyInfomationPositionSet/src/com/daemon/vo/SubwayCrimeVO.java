/*
 * com.daemon.vo.SubwayCrime
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 범죄 - 지하철역 범죄
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

public class SubwayCrimeVO extends CommonVO
{
	private int id;				//고유번호
	private String category;	//구분
	private String station;		//역사명
	private String latitude;	//위도
	private String longitude;	//경도
	private int theft;			//절도
	private int sexualViolence;	//성폭력처벌특례법위반
	private int violence;		//폭력
	private String source;			//출처
	private String year;			//년도
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
	 * @return the station
	 */
	public String getStation() {
		return station;
	}
	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
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
	 * @return the theft
	 */
	public int getTheft() {
		return theft;
	}
	/**
	 * @param theft the theft to set
	 */
	public void setTheft(int theft) {
		this.theft = theft;
	}
	/**
	 * @return the sexualViolence
	 */
	public int getSexualViolence() {
		return sexualViolence;
	}
	/**
	 * @param sexualViolence the sexualViolence to set
	 */
	public void setSexualViolence(int sexualViolence) {
		this.sexualViolence = sexualViolence;
	}
	/**
	 * @return the violence
	 */
	public int getViolence() {
		return violence;
	}
	/**
	 * @param violence the violence to set
	 */
	public void setViolence(int violence) {
		this.violence = violence;
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
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
}

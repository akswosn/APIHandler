/*
 * com.daemon.vo.TrafficVO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 교통
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

public class TrafficVO
{
	private int id;				//고유번호
	private String category;	//구분
	private String location;	//위치
	private String latitude;	//위도
	private String longitude;	//경도
	private int occurrence;		//발생건수
	private int casualties;		//사상자수
	private int dead;			//사망자수
	private int jungsang;		//중상자수
	private int gyengsang;		//경상자수
	private int busin;			//부신자수
	private String source;		//출처
	private String year;		//년도
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the occurrence
	 */
	public int getOccurrence() {
		return occurrence;
	}
	/**
	 * @param occurrence the occurrence to set
	 */
	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}
	/**
	 * @return the casualties
	 */
	public int getCasualties() {
		return casualties;
	}
	/**
	 * @param casualties the casualties to set
	 */
	public void setCasualties(int casualties) {
		this.casualties = casualties;
	}
	/**
	 * @return the dead
	 */
	public int getDead() {
		return dead;
	}
	/**
	 * @param dead the dead to set
	 */
	public void setDead(int dead) {
		this.dead = dead;
	}
	/**
	 * @return the jungsang
	 */
	public int getJungsang() {
		return jungsang;
	}
	/**
	 * @param jungsang the jungsang to set
	 */
	public void setJungsang(int jungsang) {
		this.jungsang = jungsang;
	}
	/**
	 * @return the gyengsang
	 */
	public int getGyengsang() {
		return gyengsang;
	}
	/**
	 * @param gyengsang the gyengsang to set
	 */
	public void setGyengsang(int gyengsang) {
		this.gyengsang = gyengsang;
	}
	/**
	 * @return the busin
	 */
	public int getBusin() {
		return busin;
	}
	/**
	 * @param busin the busin to set
	 */
	public void setBusin(int busin) {
		this.busin = busin;
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

/*
 * com.flk.safety.map.vo.GUMapVO
 *
 * Created on 2012. 10. 18.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.vo;

import com.flk.safety.common.BaseVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 18.
 * @version	1.00 2012. 10. 18.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 18.			최초.
 */

public class GUMapVO extends BaseVO
{
	private int code_no;
	private String location;
	private String latitude;
	private String longitude;
	private int range_crime_id;
	private String range_crime_rating;
	private String range_crime_category;
	private int range_environment_id;
	private String range_environment_rating;
	private String range_environment_category;
	private int range_traffic_id;
	private String range_traffic_rating;
	private String range_traffic_category;
	
	/**
	 * @return the code_no
	 */
	public int getCode_no() {
		return code_no;
	}
	/**
	 * @param code_no the code_no to set
	 */
	public void setCode_no(int code_no) {
		this.code_no = code_no;
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
	 * @return the range_crime_id
	 */
	public int getRange_crime_id() {
		return range_crime_id;
	}
	/**
	 * @param range_crime_id the range_crime_id to set
	 */
	public void setRange_crime_id(int range_crime_id) {
		this.range_crime_id = range_crime_id;
	}
	/**
	 * @return the range_crime_rating
	 */
	public String getRange_crime_rating() {
		return range_crime_rating;
	}
	/**
	 * @param range_crime_rating the range_crime_rating to set
	 */
	public void setRange_crime_rating(String range_crime_rating) {
		this.range_crime_rating = range_crime_rating;
	}
	/**
	 * @return the range_environment_id
	 */
	public int getRange_environment_id() {
		return range_environment_id;
	}
	/**
	 * @param range_environment_id the range_environment_id to set
	 */
	public void setRange_environment_id(int range_environment_id) {
		this.range_environment_id = range_environment_id;
	}
	/**
	 * @return the range_environment_rating
	 */
	public String getRange_environment_rating() {
		return range_environment_rating;
	}
	/**
	 * @param range_environment_rating the range_environment_rating to set
	 */
	public void setRange_environment_rating(String range_environment_rating) {
		this.range_environment_rating = range_environment_rating;
	}
	/**
	 * @return the range_traffic_id
	 */
	public int getRange_traffic_id() {
		return range_traffic_id;
	}
	/**
	 * @param range_traffic_id the range_traffic_id to set
	 */
	public void setRange_traffic_id(int range_traffic_id) {
		this.range_traffic_id = range_traffic_id;
	}
	/**
	 * @return the range_traffic_rating
	 */
	public String getRange_traffic_rating() {
		return range_traffic_rating;
	}
	/**
	 * @param range_traffic_rating the range_traffic_rating to set
	 */
	public void setRange_traffic_rating(String range_traffic_rating) {
		this.range_traffic_rating = range_traffic_rating;
	}
	/**
	 * @return the range_crime_category
	 */
	public String getRange_crime_category() {
		return range_crime_category;
	}
	/**
	 * @param range_crime_category the range_crime_category to set
	 */
	public void setRange_crime_category(String range_crime_category) {
		this.range_crime_category = range_crime_category;
	}
	/**
	 * @return the range_environment_rcategory
	 */
	public String getRange_environment_category() {
		return range_environment_category;
	}
	/**
	 * @param range_environment_rcategory the range_environment_rcategory to set
	 */
	public void setRange_environment_category(String range_environment_category) {
		this.range_environment_category = range_environment_category;
	}
	/**
	 * @return the range_traffic_category
	 */
	public String getRange_traffic_category() {
		return range_traffic_category;
	}
	/**
	 * @param range_traffic_category the range_traffic_category to set
	 */
	public void setRange_traffic_category(String range_traffic_category) {
		this.range_traffic_category = range_traffic_category;
	}
	
}

/*
 * com.daemon.vo.FoodSanitaryViolation
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 식품/안전 - 식품 위생법 위반업소
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

public class FoodSanitaryViolationVO extends CommonVO
{
	private int id;				//고유번호
	private String category;	//구분
	private String location;	//소재지
	private String latitude;	//위도
	private String longitude;	//경도
	private String type;		//업종명
	private String name;		//업소명
	private String disposal;	//처분사항
	private String violetionDate;//위반일자
	private String disposalDate;//처분확정일자
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the disposal
	 */
	public String getDisposal() {
		return disposal;
	}
	/**
	 * @param disposal the disposal to set
	 */
	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}
	/**
	 * @return the violetionDate
	 */
	public String getVioletionDate() {
		return violetionDate;
	}
	/**
	 * @param violetionDate the violetionDate to set
	 */
	public void setVioletionDate(String violetionDate) {
		this.violetionDate = violetionDate;
	}
	/**
	 * @return the disposalDate
	 */
	public String getDisposalDate() {
		return disposalDate;
	}
	/**
	 * @param disposalDate the disposalDate to set
	 */
	public void setDisposalDate(String disposalDate) {
		this.disposalDate = disposalDate;
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

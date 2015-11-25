/*
 * com.flk.safety.map.vo.MapParam
 *
 * Created on 2012. 11. 1.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.vo;
/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 1.
 * @version	1.00 2012. 11. 1.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 1.			최초.
 */

public class MapParam
{
	private String latitude;
	private String longitude;
	
	private double latRange;
	private double lngRange;
	
	public MapParam(){}
	public MapParam(String latitude, String longitude){
		this.latitude = latitude;
		this.longitude = longitude;
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
	 * @return the latRange
	 */
	public double getLatRange() {
		return latRange;
	}
	/**
	 * @param latRange the latRange to set
	 */
	public void setLatRange(double latRange) {
		this.latRange = latRange;
	}
	/**
	 * @return the lngRange
	 */
	public double getLngRange() {
		return lngRange;
	}
	/**
	 * @param lngRange the lngRange to set
	 */
	public void setLngRange(double lngRange) {
		this.lngRange = lngRange;
	}
	
	
}

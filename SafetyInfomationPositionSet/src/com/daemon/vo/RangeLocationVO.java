/*
 * com.daemon.vo.RangeWeather
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 
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

public class RangeLocationVO extends CommonVO
{
	private int location_no;			//고유번호
	private String location;		//위치
	private String sub_location;	//위치
	private String latitude;		//위도
	private String longitude;		//경도

	
	/**
	 * @return the location_no
	 */
	public int getLocation_no() {
		return location_no;
	}
	/**
	 * @param location_no the location_no to set
	 */
	public void setLocation_no(int location_no) {
		this.location_no = location_no;
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
	 * @return the sub_location
	 */
	public String getSub_location() {
		return sub_location;
	}
	/**
	 * @param sub_location the sub_location to set
	 */
	public void setSub_location(String sub_location) {
		this.sub_location = sub_location;
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
	
	
}

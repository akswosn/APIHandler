/*
 * com.daemon.vo.FoodOriginViolation
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.vo;
/**
 * 
 * 식품/안전 - 원산지표시 위반정보 공표
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

public class FoodOriginViolationVO extends CommonVO
{
	private int id;					//고유번호
	private String category;		//구분
	private String address;			//영업소 주소
	private String latitude;		//위도
	private String longitude;		//경도
	private String kind;			//영업의 종류
	private String name;			//영업소 명칭
	private String argicultural;	//위반농수산물 명칭
	private String violetions;		//위반내용
	private String disposalDate;	//처분일자
	private String disposal;		//처분내용
	private String authority;		//처분권자
	
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
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @return the argicultural
	 */
	public String getArgicultural() {
		return argicultural;
	}
	/**
	 * @param argicultural the argicultural to set
	 */
	public void setArgicultural(String argicultural) {
		this.argicultural = argicultural;
	}
	/**
	 * @return the violetions
	 */
	public String getVioletions() {
		return violetions;
	}
	/**
	 * @param violetions the violetions to set
	 */
	public void setVioletions(String violetions) {
		this.violetions = violetions;
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
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}

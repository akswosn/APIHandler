/*
 * com.daemon.vo.RangeEnvironment
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 범위 - 환경 - 대기환경 정보										
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

public class RangeEnvironmentVO 
{
	private int id;					//고유번호
	private String category;		//구분
	private String name;			//측정소명
	private String location;		//경도
	private String measurementDate;	//측정날짜
	private String atmosphere;			//통합대기환경지수
	private String atmosphereRating;//통합대기환경지수등급
	private String substance;			//지수결정물질
	private String nitrogenDioxide;	//이산화질소(단위:ppm)
	private String ozone;			//오존(단위:ppm)
	private String carbonMonoxide;	//일산화탄소(단위:ppm)
	private String sourcesulfurDioxide;	//아황산가스(단위:ppm)
	private String dust;			//미세먼지(단위:㎍/㎥)
	private String source;			//출처
	private String si;				//지역 시
	
	
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
	 * @return the measurementDate
	 */
	public String getMeasurementDate() {
		return measurementDate;
	}


	/**
	 * @param measurementDate the measurementDate to set
	 */
	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = measurementDate;
	}


	/**
	 * @return the atmosphere
	 */
	public String getAtmosphere() {
		return atmosphere;
	}


	/**
	 * @param atmosphere the atmosphere to set
	 */
	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}


	/**
	 * @return the atmosphereRating
	 */
	public String getAtmosphereRating() {
		return atmosphereRating;
	}


	/**
	 * @param atmosphereRating the atmosphereRating to set
	 */
	public void setAtmosphereRating(String atmosphereRating) {
		this.atmosphereRating = atmosphereRating;
	}


	/**
	 * @return the substance
	 */
	public String getSubstance() {
		return substance;
	}


	/**
	 * @param substance the substance to set
	 */
	public void setSubstance(String substance) {
		this.substance = substance;
	}


	/**
	 * @return the nitrogenDioxide
	 */
	public String getNitrogenDioxide() {
		return nitrogenDioxide;
	}


	/**
	 * @param nitrogenDioxide the nitrogenDioxide to set
	 */
	public void setNitrogenDioxide(String nitrogenDioxide) {
		this.nitrogenDioxide = nitrogenDioxide;
	}


	/**
	 * @return the ozone
	 */
	public String getOzone() {
		return ozone;
	}


	/**
	 * @param ozone the ozone to set
	 */
	public void setOzone(String ozone) {
		this.ozone = ozone;
	}


	/**
	 * @return the carbonMonoxide
	 */
	public String getCarbonMonoxide() {
		return carbonMonoxide;
	}


	/**
	 * @param carbonMonoxide the carbonMonoxide to set
	 */
	public void setCarbonMonoxide(String carbonMonoxide) {
		this.carbonMonoxide = carbonMonoxide;
	}


	/**
	 * @return the sourcesulfurDioxide
	 */
	public String getSourcesulfurDioxide() {
		return sourcesulfurDioxide;
	}


	/**
	 * @param sourcesulfurDioxide the sourcesulfurDioxide to set
	 */
	public void setSourcesulfurDioxide(String sourcesulfurDioxide) {
		this.sourcesulfurDioxide = sourcesulfurDioxide;
	}


	/**
	 * @return the dust
	 */
	public String getDust() {
		return dust;
	}


	/**
	 * @param dust the dust to set
	 */
	public void setDust(String dust) {
		this.dust = dust;
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
	 * @return the si
	 */
	public String getSi() {
		return si;
	}


	/**
	 * @param si the si to set
	 */
	public void setSi(String si) {
		this.si = si;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

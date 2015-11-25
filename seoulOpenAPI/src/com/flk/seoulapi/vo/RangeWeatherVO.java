/*
 * com.flk.seoulapi.vo.RangeWeatherVO
 *
 * Created on 2012. 11. 20.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 20.
 * @version	1.00 2012. 11. 20.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 20.			최초.
 */

public class RangeWeatherVO
{
	private int id;
	private int no;
	private String category;
	private String frostbite;
	private String decay;
	private String discomfort;
	private List<Integer> location_no;
	private String ultraviolet_rays;
	private String temperature;
	private String source;
	private String si;
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
	 * @return the frostbite
	 */
	public String getFrostbite() {
		return frostbite;
	}
	/**
	 * @param frostbite the frostbite to set
	 */
	public void setFrostbite(String frostbite) {
		this.frostbite = frostbite;
	}
	/**
	 * @return the decay
	 */
	public String getDecay() {
		return decay;
	}
	/**
	 * @param decay the decay to set
	 */
	public void setDecay(String decay) {
		this.decay = decay;
	}
	/**
	 * @return the discomfort
	 */
	public String getDiscomfort() {
		return discomfort;
	}
	/**
	 * @param discomfort the discomfort to set
	 */
	public void setDiscomfort(String discomfort) {
		this.discomfort = discomfort;
	}
	/**
	 * @return the location_no
	 */
	public List<Integer> getLocation_no() {
		return location_no;
	}
	/**
	 * @param location_no the location_no to set
	 */
	public void setLocation_no(List<Integer> location_no) {
		this.location_no = location_no;
	}
	/**
	 * @return the ultraviolet_rays
	 */
	public String getUltraviolet_rays() {
		return ultraviolet_rays;
	}
	/**
	 * @param ultraviolet_rays the ultraviolet_rays to set
	 */
	public void setUltraviolet_rays(String ultraviolet_rays) {
		this.ultraviolet_rays = ultraviolet_rays;
	}
	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
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
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

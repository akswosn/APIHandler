/*
 * com.flk.safety.map.vo.GuCategoryVO
 *
 * Created on 2012. 11. 6.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.vo;

import com.flk.safety.common.BaseVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 6.
 * @version	1.00 2012. 11. 6.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 6.			최초.
 */

public class GuCategoryVO extends BaseVO
{
	private String category;
	private String category_name;
	private String high_category_name;
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
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the high_category_name
	 */
	public String getHigh_category_name() {
		return high_category_name;
	}
	/**
	 * @param high_category_name the high_category_name to set
	 */
	public void setHigh_category_name(String high_category_name) {
		this.high_category_name = high_category_name;
	}
}

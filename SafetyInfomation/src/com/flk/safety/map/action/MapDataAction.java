/*
 * com.rnx.datastore.action.MapModeAction
 *
 * Created on 2012. 10. 10.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.action;



import net.sf.json.JSONObject;

import com.flk.safety.common.BaseAction;
import com.flk.safety.common.CommUtils;
import com.flk.safety.map.service.MapModeService;
import com.flk.safety.map.vo.MapParam;


/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 10.
 * @version	1.00 2012. 10. 10.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 10.			최초.
 */

public class MapDataAction extends BaseAction
{
	private static final String POSITION_ERROR = "positionErr";
	
	private static final double R_LATITUDE_RANGE = 0.02;	//RANGE 오차 범위 LATITUDE
	private static final double R_LONGITUDE_RANGE = 0.02;	//RANGE 오차범위 LONGITUDE
	private static final double POI_LATITUDE_RANGE = 0.006;	//POI 오차범위 LATITUDE
	private static final double POI_LONGITUDE_RANGE = 0.01;	//POI 오차범위 LONGITUDE
	
	JSONObject poiData;
	JSONObject guData;
	JSONObject categoryData;
	String latitude;
	String longitude;
	
	/**
	 * Map Mode Action
	 * @return
	 */
	public String poiData(){
		m_traceLogger.info("MapDataAction poiData() call");
		//POI 데이터 가져오기
		MapParam param = new MapParam(latitude,longitude);
		param.setLatRange(POI_LATITUDE_RANGE);
		param.setLngRange(POI_LONGITUDE_RANGE);
		poiData = MapModeService.getInstance().selectPoiMapData(param);
		
		if(m_traceLogger.isDebugEnabled()){
			m_traceLogger.debug("poiData Result : " + poiData);
		}
		return SUCCESS;
	}
	
	public String guData(){
		m_traceLogger.info("MapDataAction guData() call");
		MapParam param = new MapParam(latitude,longitude);
		param.setLatRange(R_LATITUDE_RANGE);
		param.setLngRange(R_LONGITUDE_RANGE);
		guData = MapModeService.getInstance().selectGuMapData(param);
		
		if(m_traceLogger.isDebugEnabled()){
			m_traceLogger.debug("guData Result : " + guData);
		}
		return SUCCESS;
	}
	
	public String categoryData(){
		m_traceLogger.info("MapDataAction categoryData() call");
		categoryData = MapModeService.getInstance().selectGuCategoryData();
		
		if(m_traceLogger.isDebugEnabled()){
			m_traceLogger.debug("categoryData Result : " + categoryData);
		}
		return SUCCESS;
	}
	
	/**
	 * @return the categoryData
	 */
	public JSONObject getCategoryData() {
		return categoryData;
	}
	/**
	 * @param categoryData the categoryData to set
	 */
	public void setCategoryData(JSONObject categoryData) {
		this.categoryData = categoryData;
	}
	/**
	 * @param poiData the poiData to set
	 */
	public void setPoiData(JSONObject poiData) {
		this.poiData = poiData;
	}
	/**
	 * @return the poiData
	 */
	public JSONObject getPoiData() {
		return poiData;
	}
	/**
	 * @return the guData
	 */
	public JSONObject getGuData() {
		return guData;
	}
	/**
	 * @param guData the guData to set
	 */
	public void setGuData(JSONObject guData) {
		this.guData = guData;
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

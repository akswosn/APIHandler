/*
 * com.flk.safety.map.service.MapModeService
 *
 * Created on 2012. 10. 17.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.service;

import java.util.List;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.flk.safety.map.dao.MapModeDAO;
import com.flk.safety.map.vo.GUMapVO;
import com.flk.safety.map.vo.GuCategoryVO;
import com.flk.safety.map.vo.MapParam;
import com.flk.safety.map.vo.POIMapVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 17.
 * @version	1.00 2012. 10. 17.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 17.			최초.
 */

public class MapModeService
{
	private static volatile MapModeService	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static MapModeService getInstance() {
		if(m_theInstance == null){
			synchronized(MapModeService.class){
				if(m_theInstance == null){
					m_theInstance = new MapModeService();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	public JSONObject selectGuMapData(MapParam param){
		m_traceLogger.info("MapModeService selectGuMapData() call");
		List<GUMapVO> list = MapModeDAO.getInstance().selectGuMapData(param);
		JSONObject obj = new JSONObject();
		
		try{
			obj.put("guList", list);
		}
		catch(JSONException e){
			m_traceLogger.error("MapModeService selectGuMapData() JSONObject Error : " + e);
		}
		
		return obj;
	}

	public JSONObject selectPoiMapData(MapParam param) {
		m_traceLogger.info("MapModeService selectPoiMapData() call");
		List<POIMapVO> list = MapModeDAO.getInstance().selectPoiMapData(param);
		JSONObject obj = new JSONObject();
		
		try{
			obj.put("poiList", list);
		}
		catch(JSONException e){
			m_traceLogger.error("MapModeService selectPoiMapData() JSONObject Error : " + e);
		}
		
		return obj;
	}
	
	public JSONObject selectGuCategoryData() {
		m_traceLogger.info("MapModeService selectGuCategoryData() call");
		List<GuCategoryVO> list = MapModeDAO.getInstance().selectGuCategoryData();
		JSONObject obj = new JSONObject();
		
		try{
			obj.put("categoryList", list);
		}
		catch(JSONException e){
			m_traceLogger.error("MapModeService selectGuCategoryData() JSONObject Error : " + e);
		}
		return obj;
	}
}

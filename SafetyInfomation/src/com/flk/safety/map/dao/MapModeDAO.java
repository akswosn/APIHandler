/*
 * com.flk.safety.map.dao.MapModeDAO
 *
 * Created on 2012. 10. 17.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.flk.safety.common.SqlMapClientFactory;
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

public class MapModeDAO extends SqlMapClientFactory
{
	private static volatile MapModeDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static MapModeDAO getInstance() {
		if(m_theInstance == null){
			synchronized(MapModeDAO.class){
				if(m_theInstance == null){
					m_theInstance = new MapModeDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	/**
	 * poi 정보 조회
	 * @param param
	 * @return
	 */
	public List<POIMapVO> selectPoiMapData(MapParam param){
		m_traceLogger.info("MapModeDAO selectPoiMapData() call");
		List<POIMapVO> list = null;
		try{
			list = getSqlMapClient().queryForList("map.selectPoiMapData", param);
		}catch (Exception e) {
			printQuery("map.selectPoiMapData", param);
			m_traceLogger.error("MapModeDAO selectPoiMapData : " + e);
		}
		
		return list;
	}
	
	/**
	 * 자치구별 정보 조회
	 * @param param
	 * @return
	 */
	public List<GUMapVO> selectGuMapData(MapParam param) {
		m_traceLogger.info("MapModeDAO selectGuMapData() call");
		List<GUMapVO> list = null;
		try{
			list = getSqlMapClient().queryForList("map.selectGuMapData", param);
		}catch (Exception e) {
			printQuery("map.selectGuMapData", param);
			m_traceLogger.error("MapModeDAO selectGuMapData : " + e);
		}
		return list;
	}
	
	/**
	 * 자치구별 카테고리 목록 조회
	 * @return
	 */
	public List<GuCategoryVO> selectGuCategoryData(){
		m_traceLogger.info("MapModeDAO selectGuCategoryData() call");
		List<GuCategoryVO> list = null;
		try{
			list = getSqlMapClient().queryForList("map.selectGuCategoryData", null);
		}catch (Exception e) {
			printQuery("map.selectGuCategoryData");
			m_traceLogger.error("MapModeDAO selectGuCategoryData : " + e);
		}
		return list;
	}
}

/*
 * com.flk.seoulapi.dao.EnvironmentDAO
 *
 * Created on 2012. 10. 24.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.flk.seoulapi.common.SqlMapBuilder;
import com.flk.seoulapi.vo.FoodCertificationVO;
import com.flk.seoulapi.vo.RangeWeatherVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 24.
 * @version	1.00 2012. 10. 24.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 24.			최초.
 */

public class WeatherDAO extends SqlMapBuilder
{
	private static volatile WeatherDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static WeatherDAO getInstance() {
		if(m_theInstance == null){
			synchronized(WeatherDAO.class){
				if(m_theInstance == null){
					m_theInstance = new WeatherDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	public List<Integer> getWeatherLocationNo(RangeWeatherVO vo){
		List<Integer> list = null;
		
		try{
			list = (List<Integer>)getSqlMapClient().queryForList("Daemon.getWeatherLocationNo", vo);
		}
		catch (Exception e) {
			m_traceLogger.error("getWeatherLocationNo error : " + e);
			printQuery("Daemon.getWeatherLocationNo", vo);
		}
		
		return list;
	}
	
	public int updateWeather(RangeWeatherVO vo){
		int result = 0;
		try{
			result = getSqlMapClient().update("Daemon.updateWeather", vo);
		}
		catch (Exception e) {
			m_traceLogger.error("updateWeather error : " + e);
			printQuery("Daemon.updateWeather", vo);
		}
		return result;
	}

	public void insertWeather(RangeWeatherVO vo) {
		try{
			getSqlMapClient().update("Daemon.insertWeather", vo);
		}
		catch (Exception e) {
			m_traceLogger.error("insertWeather error : " + e);
			printQuery("Daemon.insertWeather", vo);
		}
	}
}

/*
 * com.daemon.dao.FoodOriginViolationDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.FoodCertificationVO;
import com.daemon.vo.FoodOriginViolationVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
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

public class FoodOriginViolationDAO extends SqlMapBuilder
{
	private static volatile FoodOriginViolationDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static FoodOriginViolationDAO getInstance() {
		if(m_theInstance == null){
			synchronized(FoodOriginViolationDAO.class){
				if(m_theInstance == null){
					m_theInstance = new FoodOriginViolationDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<FoodOriginViolationVO> selectFoodOriginViolationAsNotPosition() {
		ArrayList<FoodOriginViolationVO> list = null;
		
		try{
			list = (ArrayList<FoodOriginViolationVO>)
				getSqlMapClient().queryForList("Daemon.selectFoodOriginViolationAsNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("FoodOriginViolationDAO selectFoodOriginViolationAsNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionFoodOriginViolation(FoodOriginViolationVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionFoodOriginViolation", obj);
		}
		catch(Exception e){
			m_traceLogger.error("FoodOriginViolationDAO setPositionFoodOriginViolation Error: " + e);
		}
		
	}
}

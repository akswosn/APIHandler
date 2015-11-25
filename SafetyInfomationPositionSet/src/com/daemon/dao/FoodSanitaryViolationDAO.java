/*
 * com.daemon.dao.FoodSanitaryViolationDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.FoodOriginViolationVO;
import com.daemon.vo.FoodSanitaryViolationVO;

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

public class FoodSanitaryViolationDAO extends SqlMapBuilder
{
	private static volatile FoodSanitaryViolationDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static FoodSanitaryViolationDAO getInstance() {
		if(m_theInstance == null){
			synchronized(FoodSanitaryViolationDAO.class){
				if(m_theInstance == null){
					m_theInstance = new FoodSanitaryViolationDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<FoodSanitaryViolationVO> selectFoodSanitaryViolationAsNotPosition() {
		ArrayList<FoodSanitaryViolationVO> list = null;
		
		try{
			list = (ArrayList<FoodSanitaryViolationVO>)
				getSqlMapClient().queryForList("Daemon.selectFoodSanitaryViolationAsNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("FoodSanitaryViolationDAO selectFoodSanitaryViolationAsNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionFoodFoodSanitaryViolation(FoodSanitaryViolationVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionFoodFoodSanitaryViolation", obj);
		}
		catch(Exception e){
			m_traceLogger.error("FoodSanitaryViolationDAO setPositionFoodFoodSanitaryViolation Error: " + e);
		}
		
	}

}

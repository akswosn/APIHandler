/*
 * com.daemon.dao.FoodCertificationDAO
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

public class FoodCertificationDAO extends SqlMapBuilder
{
	private static volatile FoodCertificationDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static FoodCertificationDAO getInstance() {
		if(m_theInstance == null){
			synchronized(FoodCertificationDAO.class){
				if(m_theInstance == null){
					m_theInstance = new FoodCertificationDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<FoodCertificationVO> selectFoodCertificationAsNotPosition() {
		ArrayList<FoodCertificationVO> list = null;
		
		try{
			list = (ArrayList<FoodCertificationVO>)
				getSqlMapClient().queryForList("Daemon.selectFoodCertificationAsNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("FoodCertificationDAO selectFoodCertificationAsNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionFoodCertification(FoodCertificationVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionFoodCertification", obj);
		}
		catch(Exception e){
			m_traceLogger.error("FoodCertificationDAO setPositionFoodCertification Error: " + e);
		}
	}

}

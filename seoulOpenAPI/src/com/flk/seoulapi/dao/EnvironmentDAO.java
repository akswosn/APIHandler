/*
 * com.flk.seoulapi.dao.EnvironmentDAO
 *
 * Created on 2012. 10. 24.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.dao;

import org.apache.log4j.Logger;

import com.flk.seoulapi.common.SqlMapBuilder;
import com.flk.seoulapi.vo.RangeEnvironmentVO;

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

public class EnvironmentDAO extends SqlMapBuilder
{
	private static volatile EnvironmentDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static EnvironmentDAO getInstance() {
		if(m_theInstance == null){
			synchronized(EnvironmentDAO.class){
				if(m_theInstance == null){
					m_theInstance = new EnvironmentDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	
	public int updateEnvironment(RangeEnvironmentVO vo){
		int result = 0;
		try{
			result = getSqlMapClient().update("Daemon.updateEnvironment", vo);
		}catch (Exception e) {
			m_traceLogger.error("update error : " + e);
			printQuery("Daemon.updateEnvironment", vo);
		}
		
		return result;
	}
	
	
	public void insertEnvironment(RangeEnvironmentVO vo){
		try{
			getSqlMapClient().update("Daemon.insertEnvironment", vo);
		}catch (Exception e) {
			m_traceLogger.error("update error : " + e);
			printQuery("Daemon.updateEnvironment", vo);
		}
	}
}

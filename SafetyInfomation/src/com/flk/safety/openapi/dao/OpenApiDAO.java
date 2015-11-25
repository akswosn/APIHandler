/*
 * com.flk.safety.openapi.dao.OpenApiDAO
 *
 * Created on 2012. 11. 15.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.openapi.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.flk.safety.common.SqlMapClientFactory;
import com.flk.safety.detail.vo.Range_EnvironmentVO;


/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 15.
 * @version	1.00 2012. 11. 15.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 15.			최초.
 */

public class OpenApiDAO extends SqlMapClientFactory
{
	private static volatile OpenApiDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static OpenApiDAO getInstance() {
		if(m_theInstance == null){
			synchronized(OpenApiDAO.class){
				if(m_theInstance == null){
					m_theInstance = new OpenApiDAO();
				}
			}
		}
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	public List<Range_EnvironmentVO> selectEnvironment(){
		m_traceLogger.info("call OpenApiDAO selectEnvironment()");
		List<Range_EnvironmentVO> list = null;
		
		try{
			list = getSqlMapClient().queryForList("openapi.selectEnvironment", null);
		}
		catch(Exception e){
			printQuery("openapi.selectEnvironment");
			m_traceLogger.error("OpenApiDAO selectEnvironment : " + e);
		}
		
		return list;
	}
}

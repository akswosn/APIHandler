/*
 * com.flk.safety.openapi.service.OpenApiService
 *
 * Created on 2012. 11. 15.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.openapi.service;

import java.util.List;

import javax.xml.crypto.dsig.XMLObject;

import org.apache.log4j.Logger;
import org.json.XML;

import com.flk.safety.detail.vo.Range_EnvironmentVO;
import com.flk.safety.openapi.dao.OpenApiDAO;


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

public class OpenApiService
{
	private static volatile OpenApiService	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static OpenApiService getInstance() {
		if(m_theInstance == null){
			synchronized(OpenApiService.class){
				if(m_theInstance == null){
					m_theInstance = new OpenApiService();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	
	public List<Range_EnvironmentVO> selectEnvironment(){
		return OpenApiDAO.getInstance().selectEnvironment();
	}
}

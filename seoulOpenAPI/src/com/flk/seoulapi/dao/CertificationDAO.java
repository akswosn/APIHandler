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
import com.flk.seoulapi.vo.FoodCertificationVO;

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

public class CertificationDAO extends SqlMapBuilder
{
	private static volatile CertificationDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static CertificationDAO getInstance() {
		if(m_theInstance == null){
			synchronized(CertificationDAO.class){
				if(m_theInstance == null){
					m_theInstance = new CertificationDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR
	
	public int selectCertificationAsCount(){
		Integer result = 0;
		
		try{
			result = (Integer)getSqlMapClient().queryForObject("Daemon.selectCertificationAsCount", null);
			
		}catch (Exception e) {
			m_traceLogger.error("selectCertificationAsCount error : " + e);
			printQuery("Daemon.selectCertificationAsCount");
		}
		
		return result.intValue();
	}
	
	public void insertCertification(FoodCertificationVO vo){
		try{
			getSqlMapClient().insert("Daemon.insertCertification", vo);
		}
		catch (Exception e) {
			m_traceLogger.error("insertCertification error : " + e);
			printQuery("Daemon.insertCertification", vo);
		}
	}
	
	public void deleteCertificationAsAll(){
		try{
			getSqlMapClient().delete("Daemon.deleteCertificationAsAll", null);
			
		}catch (Exception e) {
			m_traceLogger.error("deleteCertificationAsAll error : " + e);
			printQuery("Daemon.deleteCertificationAsAll");
		}
	}
}

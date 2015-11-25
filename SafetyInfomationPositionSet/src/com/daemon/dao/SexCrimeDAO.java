/*
 * com.daemon.dao.SexCrimeDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.SexCrimeVO;

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

public class SexCrimeDAO extends SqlMapBuilder
{
	private static volatile SexCrimeDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static SexCrimeDAO getInstance() {
		if(m_theInstance == null){
			synchronized(SexCrimeDAO.class){
				if(m_theInstance == null){
					m_theInstance = new SexCrimeDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<SexCrimeVO> selectSexCrimeAsNotPosition() {
		ArrayList<SexCrimeVO> list = null;
		
		try{
			list = (ArrayList<SexCrimeVO>)
				getSqlMapClient().queryForList("Daemon.selectSexCrimeAsNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("SexCrimeDAO selectSexCrimeAsNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionSexCrime(SexCrimeVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionSexCrime", obj);
		}
		catch(Exception e){
			m_traceLogger.error("SexCrimeDAO setPositionSexCrime Error: " + e);
		}
	}

}
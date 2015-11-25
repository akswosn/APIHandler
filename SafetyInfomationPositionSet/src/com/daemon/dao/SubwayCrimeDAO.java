/*
 * com.daemon.dao.SubwayCrimeDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.SubwayCrimeVO;

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

public class SubwayCrimeDAO extends SqlMapBuilder
{
	private static volatile SubwayCrimeDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static SubwayCrimeDAO getInstance() {
		if(m_theInstance == null){
			synchronized(SubwayCrimeDAO.class){
				if(m_theInstance == null){
					m_theInstance = new SubwayCrimeDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<SubwayCrimeVO> selectSubwayCrimeAsNotPosition() {
		ArrayList<SubwayCrimeVO> list = null;
		
		try{
			list = (ArrayList<SubwayCrimeVO>)
				getSqlMapClient().queryForList("Daemon.selectSubwayCrimeAsNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("SubwayCrimeDAO selectSubwayCrimeAsNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionSubwayCrime(SubwayCrimeVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionSubwayCrime", obj);
		}
		catch(Exception e){
			m_traceLogger.error("SubwayCrimeDAO setPositionSubwayCrime Error: " + e);
		}
	}

}

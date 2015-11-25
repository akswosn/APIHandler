/*
 * com.daemon.dao.CalamityDisasterDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.CalamityDisasterVO;


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

public class CalamityDisasterDAO extends SqlMapBuilder
{
	private static volatile CalamityDisasterDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static CalamityDisasterDAO getInstance() {
		if(m_theInstance == null){
			synchronized(CalamityDisasterDAO.class){
				if(m_theInstance == null){
					m_theInstance = new CalamityDisasterDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<CalamityDisasterVO> selectCalamityDisasterAsNotPosition() {
		ArrayList<CalamityDisasterVO> list = null;
		
		try{
			list = 
				(ArrayList<CalamityDisasterVO>)getSqlMapClient().queryForList("Daemon.selectCalamityDisasterAsNotPosition", null);
		}
		catch(SQLException e){
			m_traceLogger.error("CalamityDisasterDAO selectCalamityDisasterAsNotPosition : " + e);
		}
		
		return list;
	}

	public void setPositionCalamityDisaster(CalamityDisasterVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionCalamityDisaster", obj);
		}
		catch(SQLException e){
			m_traceLogger.error("CalamityDisasterDAO setPositionDisasterAsNotPosition : " + e);
		}
	}
}

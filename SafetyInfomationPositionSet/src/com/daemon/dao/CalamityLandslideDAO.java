/*
 * com.daemon.dao.CalamityLandslideDAO
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
import com.daemon.vo.CalamityLandslideVO;

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

public class CalamityLandslideDAO extends SqlMapBuilder
{
	private static volatile CalamityLandslideDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static CalamityLandslideDAO getInstance() {
		if(m_theInstance == null){
			synchronized(CalamityLandslideDAO.class){
				if(m_theInstance == null){
					m_theInstance = new CalamityLandslideDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<CalamityLandslideVO> selectCalamityLandslideAsNotPosition() {
		ArrayList<CalamityLandslideVO> list = null;
		
		try{
			list = (ArrayList<CalamityLandslideVO>)
				getSqlMapClient().queryForList("Daemon.selectCalamityLandslideAsNotPosition", null);
		}
		catch(SQLException e){
			m_traceLogger.error("CalamityLandslideDAO selectCalamityLandslideAsNotPosition : " + e);
		}
		return list;
	}

	public void setPositionCalamityLandslide(CalamityLandslideVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionCalamityLandslide", obj);
		}
		catch(SQLException e){
			m_traceLogger.error("CalamityLandslideDAO setPositionCalamityDisaster : " + e);
		}
	}
	
	
}

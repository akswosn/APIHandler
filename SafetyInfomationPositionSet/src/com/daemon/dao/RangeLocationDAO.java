/*
 * com.daemon.dao.TrafficDAO
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.common.SqlMapBuilder;
import com.daemon.vo.RangeLocationVO;

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

public class RangeLocationDAO extends SqlMapBuilder
{
	private static volatile RangeLocationDAO	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static RangeLocationDAO getInstance() {
		if(m_theInstance == null){
			synchronized(RangeLocationDAO.class){
				if(m_theInstance == null){
					m_theInstance = new RangeLocationDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public ArrayList<RangeLocationVO> selectRangeLocationNotPosition() {
		ArrayList<RangeLocationVO> list = null;
		
		try{
			list = (ArrayList<RangeLocationVO>)
				getSqlMapClient().queryForList("Daemon.selectRangeLocationNotPosition", null);
		}catch (Exception e) {
			m_traceLogger.error("RangeLocationDAO selectRangeLocationNotPosition Error: " + e);
		}
		
		return list;
	}

	public void setPositionRangeLocation(RangeLocationVO obj) {
		try{
			getSqlMapClient().update("Daemon.setPositionRangeLocation", obj);
		}
		catch(Exception e){
			m_traceLogger.error("RangeLocationDAO setPositionRangeLocation Error: " + e);
		}
	}

}
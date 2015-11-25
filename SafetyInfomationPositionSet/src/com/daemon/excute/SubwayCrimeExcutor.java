/*
 * com.daemon.excute.SubwayCrimeExcutor
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.excute;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.service.ExcuterService;
import com.daemon.util.GoogleAddr2Coord;
import com.daemon.vo.SexCrimeVO;
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

public class SubwayCrimeExcutor implements Executor
{
	private static Logger m_traceLogger = Logger.getLogger("TRACE");
	private ArrayList<SubwayCrimeVO> list;
	
	public SubwayCrimeExcutor(ArrayList<SubwayCrimeVO> list){
		this.list = list;
	}
	/* (non-Javadoc)
	 * @see com.daemon.excute.Executor#execute()
	 */
	@Override
	public void execute() throws Exception {
		
		String searchText ="";
		
		for(SubwayCrimeVO obj : list){
			searchText = obj.getStation();
			GoogleAddr2Coord addr2coord = new GoogleAddr2Coord();
			double[] location = addr2coord.translate(searchText);
			
			m_traceLogger.info("latitude : " + location[0]);
			m_traceLogger.info("longitude : " + location[1]);
			
			obj.setLatitude(location[0]+"");
			obj.setLongitude(location[1]+"");
			
			ExcuterService.getInstance().setPositionSubwayCrime(obj);
		}
	}
}

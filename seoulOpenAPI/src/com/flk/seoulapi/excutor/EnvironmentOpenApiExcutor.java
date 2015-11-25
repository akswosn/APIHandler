/*
 * com.flk.openapi.SeoulOpenApi
 *
 * Created on 2012. 10. 18.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.excutor;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.flk.seoulapi.common.Constant;
import com.flk.seoulapi.common.JsonHttpClient;
import com.flk.seoulapi.common.SqlMapBuilder;
import com.flk.seoulapi.dao.EnvironmentDAO;
import com.flk.seoulapi.vo.RangeEnvironmentVO;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * 
 * Create Date 2012. 10. 18.
 * @version	1.00 2012. 10. 18.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 */

public class EnvironmentOpenApiExcutor implements Executor
{
	public static Logger m_traceLogger = Logger.getLogger("TRACE"); 
	public static final boolean IS_DEBUG_ENALBLE= m_traceLogger.isDebugEnabled();
	
	@Override
	public void execute(String url) {
		try{
			m_traceLogger.info("EnvironmentOpenApiExcutor execute() start");
			
			if(url == null){
				m_traceLogger.error("url key Parse Fail !!");
				return;
			}
			
			String result = "";
			RangeEnvironmentVO vo = null;
			
			result = JsonHttpClient.sendHttpGet(url);
			if(IS_DEBUG_ENALBLE){
				m_traceLogger.debug("SEOUL API environment result : " + result);
			}
			
			if(result != null ){									
				JSONArray ja = null;
				
					JSONObject jo = JSONObject.fromObject(result);
					ja = jo.getJSONObject(Constant.ENVIRONMENT_ROOT).getJSONArray(Constant.COMM_ROOT_LIST);
				
				if(result != null){
					int upCount = 0;
					int inCount = 0;
					for(Iterator i = ja.iterator(); i.hasNext();){
						JSONObject ob = (JSONObject)i.next();
						vo = new RangeEnvironmentVO();
						vo.setCategory(Constant.CATEGORY_RANGE_ENVIRONMENT);
						vo.setLocation(ob.getString(Constant.ENVIRONMENT_MSRSTENAME));
						vo.setName(ob.getString(Constant.ENVIRONMENT_MSRSTENAME));
						if(ob.getString(Constant.ENVIRONMENT_MSRDATE).length() > 3){
							vo.setMeasurementDate(ob.getString(Constant.ENVIRONMENT_MSRDATE).substring(2));
						}
						vo.setAtmosphere(ob.getString(Constant.ENVIRONMENT_MAXINDEX));
						vo.setAtmosphereRating(ob.getString(Constant.ENVIRONMENT_GRADE));
						vo.setSubstance(ob.getString(Constant.ENVIRONMENT_POLLUTANT));
						vo.setNitrogenDioxide(ob.getString(Constant.ENVIRONMENT_NITROGEN));
						vo.setOzone(ob.getString(Constant.ENVIRONMENT_OZONE));
						vo.setCarbonMonoxide(ob.getString(Constant.ENVIRONMENT_CARBON));
						vo.setSourcesulfurDioxide(ob.getString(Constant.ENVIRONMENT_SULFUROUS));
						vo.setDust(ob.getString(Constant.ENVIRONMENT_PM10));
						vo.setSource(Constant.ENVIRONMENT_SOURCE);
						vo.setSi(Constant.LOCATION_SI);
						
						int intRst = EnvironmentDAO.getInstance().updateEnvironment(vo);
						if(intRst < 1){
							EnvironmentDAO.getInstance().insertEnvironment(vo);
							if(IS_DEBUG_ENALBLE){
								m_traceLogger.debug("insert !!! : " + vo);
							}
							inCount ++;
						}
						else {
							if(IS_DEBUG_ENALBLE){
								m_traceLogger.debug("update !!! : " + vo);
							}
							upCount ++;
						}
					}
					m_traceLogger.info("Result insert Count : " + inCount);
					m_traceLogger.info("Result update Count : " + upCount);
				}
			}
		}catch (Exception e) {
			m_traceLogger.error("EnvironmentOpenApiExcutor : " + e);
		}
	}
}

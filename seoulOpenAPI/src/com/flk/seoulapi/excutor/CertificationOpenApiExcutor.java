/*
 * com.flk.seoulapi.excutor.CertificationOpenApiExcutor
 *
 * Created on 2012. 10. 23.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.excutor;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.flk.seoulapi.common.Constant;
import com.flk.seoulapi.common.JsonHttpClient;
import com.flk.seoulapi.common.SqlMapBuilder;
import com.flk.seoulapi.dao.CertificationDAO;
import com.flk.seoulapi.vo.FoodCertificationVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 23.
 * @version	1.00 2012. 10. 23.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 23.			최초.
 */

public class CertificationOpenApiExcutor implements Executor
{
	public static Logger m_traceLogger = Logger.getLogger("TRACE"); 
	public static final boolean IS_DEBUG_ENALBLE= m_traceLogger.isDebugEnabled();
	
	@Override
	public void execute(String url) {
		m_traceLogger.info("CertificationOpenApiExcutor execute() start");
		
		if(url == null){
			m_traceLogger.error("url key Parse Fail !!");
			return;
		}
		
		String result = "";
		FoodCertificationVO vo = null;
		result = JsonHttpClient.sendHttpGet(url);
		if(IS_DEBUG_ENALBLE){
			m_traceLogger.debug("SEOUL API certification result : " + result);
		}
		
		int ckeckNum = 0;
		
		ckeckNum = CertificationDAO.getInstance().selectCertificationAsCount();
		
		if(ckeckNum > 0){
			CertificationDAO.getInstance().deleteCertificationAsAll();
			
			m_traceLogger.info("Certification data all Delete !!");
		}
		
		if(result != null ){									
			JSONArray ja = null;
			
				JSONObject jo = JSONObject.fromObject(result);
				ja = jo.getJSONObject(Constant.CERTIFICATION_ROOT).getJSONArray(Constant.COMM_ROOT_LIST);
			if(result != null){
				
				for(Iterator i = ja.iterator(); i.hasNext();){
					JSONObject ob = (JSONObject)i.next();
					vo = new FoodCertificationVO();
					vo.setCategory(Constant.CATEGORY_CERTIFICATION);
					vo.setName(ob.getString(Constant.CERTIFICATION_CTF_NAME));
					vo.setAddress(ob.getString(Constant.CERTIFICATION_CTF_ADDR));
					vo.setTel(ob.getString(Constant.CERTIFICATION_CTF_TEL));
					vo.setSource(Constant.CERTIFICATION_SOURCE);
					vo.setLatitude("0");
					vo.setLongitude("0");
					CertificationDAO.getInstance().insertCertification(vo);
				}
			}
		}
		else {
			m_traceLogger.error("Open api result is null ");
		}
	}
}

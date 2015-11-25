/*
 * com.flk.seoulapi.main.SeoulApiMain
 *
 * Created on 2012. 10. 23.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.main;

import org.apache.log4j.Logger;

import com.flk.seoulapi.common.Constant;
import com.flk.seoulapi.excutor.CertificationOpenApiExcutor;
import com.flk.seoulapi.excutor.EnvironmentOpenApiExcutor;
import com.flk.seoulapi.excutor.Executor;
import com.flk.seoulapi.excutor.WeatherOpenApiExcutor;

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

public class SeoulApiMain
{
	private static final String API_ENVIRONMENT = "environment";
	private static final String API_CERTIFICATION = "certification";
	private static final String API_WEATHER = "weather";
	static public Logger m_traceLogger =  Logger.getLogger("TRACE");
	
	public static void main(String[] args){
		String job = null;
		if(args.length > 0){
			job = args[0];
		}
		else {
			m_traceLogger.error("job Type input environment & certification");
			return;
		}
		if(job.equals(API_ENVIRONMENT)){//환경 api job
			Executor exc = new EnvironmentOpenApiExcutor();
			try{
				
				String url = urlParse(Constant.SEOUL_API_URL_ENVIRONMENT, Constant.ENVIRONMENT_ROOT);
				exc.execute(url);
			}
			catch(Exception e){
				m_traceLogger.error("API_ENVIRONMENT ERROR : " + e );
			}
		}
		else if(job.equals(API_CERTIFICATION)){//안심 먹거리 api job
			Executor exc = new CertificationOpenApiExcutor();
			try{
				
				String url = urlParse(Constant.SEOUL_API_URL_CERTIFICATION, Constant.CERTIFICATION_ROOT);
				exc.execute(url);
			}
			catch(Exception e){
				m_traceLogger.error("API_CERTIFICATION ERROR : " + e );
			}
		}
		else if(job.equals(API_WEATHER)){//환경 api
			Executor exc = new WeatherOpenApiExcutor();
			try{
				String url = "";
				exc.execute(url);
			}
			catch(Exception e){
				m_traceLogger.error("API_WEATHER ERROR : " + e );
			}
		}
		else {
			m_traceLogger.error("job Type input environment & certification");
		}
	}
	
	
	public static String urlParse(String url, String rootList){
		
		if(url == null || rootList == null){
			m_traceLogger.error("urlParse parse() parameter is null!!!");
			
			return null;
		}
		
		String key = Constant.API_KEY;
		String parse = Constant.PARSE_NAME;
		String rootListParse = Constant.PARSE_ROOT_NAME;
		String result = "";
		
		//인증키 parse
		if(url.lastIndexOf(parse) > -1){
			result = url.replace(parse, key);
			
			//root List parse
			if(rootList.equals(Constant.ENVIRONMENT_ROOT)){//환경
				result = result.replace(rootListParse, rootList);
			}
			else if(rootList.equals(Constant.CERTIFICATION_ROOT)){//안심 먹거리
				result = result.replace(rootListParse, rootList);
			}
		}
		else{ 
			m_traceLogger.error("urlParse parse() url parse fail!!!!");
			return null;
		}
		return result;
	}
}

/*
 * com.flk.seoulapi.excutor.WeatherOpenApiExcutor
 *
 * Created on 2012. 11. 12.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.seoulapi.excutor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.flk.seoulapi.common.Constant;
import com.flk.seoulapi.dao.WeatherDAO;
import com.flk.seoulapi.vo.RangeWeatherVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 12.
 * @version	1.00 2012. 11. 12.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 12.			최초.
 */

public class WeatherOpenApiExcutor implements Executor{
	public static Logger m_traceLogger = Logger.getLogger("TRACE"); 
	/* (non-Javadoc)
	 * @see com.flk.seoulapi.excutor.Executor#execute(java.lang.String)
	 */
	@Override
	public void execute(String url) throws Exception {
		m_traceLogger.info("WeatherOpenApiExcutor execute() start");
		//서비스키 encoding
		String serviceKey = null;
		RangeWeatherVO vo = new RangeWeatherVO();
		try{
			serviceKey = URLEncoder.encode(Constant.DATA_SERVICE_KEY, "utf-8");
		}
		catch(UnsupportedEncodingException e1){
			m_traceLogger.error("serviceKey encode error : " + e1);
		}
		//데이터 조회
		vo.setUltraviolet_rays(getUltraLife(serviceKey));
		vo.setTemperature(getSensorytemLife(serviceKey));
		vo.setDiscomfort(getDsplsLife(serviceKey));
		vo.setFrostbite(getFrostbiteLife(serviceKey));
		vo.setDecay(getRotLife(serviceKey));
		vo.setSource(Constant.DATA_SOURCE);
		vo.setCategory(Constant.CATEGORY_RANGE_WEATHER);
		vo.setSi(Constant.LOCATION_SI);
		WeatherDAO dao = WeatherDAO.getInstance();
		
		List<Integer> list = dao.getWeatherLocationNo(vo);
		vo.setLocation_no(list);
		
		int intRst = dao.updateWeather(vo);
		if(intRst < 1){
			for(int temp : vo.getLocation_no()){
				vo.setNo(temp);
				dao.insertWeather(vo);
			}
			if(m_traceLogger.isDebugEnabled()){
				m_traceLogger.debug("insert !!! : " + vo);
			}
			m_traceLogger.info("insert success weather");
		}
		else {
			if(m_traceLogger.isDebugEnabled()){
				m_traceLogger.debug("update !!! : " + vo);
			}
			m_traceLogger.info("update success weather");
		}
	}
	
	/**
	 * 자외선 지수 정보 
	 * @param vo
	 * @return
	 */
	public String getUltraLife(String serviceKey){
        String areaNo = "108";	//서울
        String ultraLife = null;
		try { 
			SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(Constant.DATA_ULTRVLIFE_URL+"?serviceKey="+serviceKey+"&AreaNo="+areaNo);
            Element root= doc.getRootElement();
            String success = root.getChild("Header").getChildText("SuccessYN");
            //성공여부 체크
            if("Y".equals(success) ){
            	ultraLife = root.getChild("Body").getChild("IndexModel").getChildText("today");
        		m_traceLogger.info("ULTRVLIFE : " + ultraLife);
            }
            else {
            	m_traceLogger.warn("ULTRVLIFE Response fail !!");
            }
		} catch (Exception e) { 
			m_traceLogger.error("ULTRVLIFE Response error : " + e);
        } 
		return ultraLife;
	}
	/**
	 * 체감온도 지수 정보 
	 * @param vo
	 * @return
	 */
	public String getSensorytemLife(String serviceKey){
		
		String areaNo = "108";	//서울
		String temperature = null;
		try { 
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(Constant.DATA_SENSORYTEMLIFE_URL+"?serviceKey="+serviceKey+"&AreaNo="+areaNo);
			Element root= doc.getRootElement();
			String success = root.getChild("Header").getChildText("SuccessYN");
			//성공여부 체크
			if("Y".equals(success) ){
				temperature = root.getChild("Body").getChild("IndexModel").getChildText("h3");
				m_traceLogger.info("TEMPERATURE : " + temperature);
			}
			else {
				m_traceLogger.warn("TEMPERATURE Response fail !!");
			}
		} catch (Exception e) { 
			m_traceLogger.error("TEMPERATURE Response error : " + e);
		} 
		return temperature;
	}
	/**
	 * 동상가능지수 정보 
	 * @param vo
	 * @return
	 */
	public String getFrostbiteLife(String serviceKey){
		String frostbitelife = null;
		String areaNo = "108";	//서울
		try { 
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(Constant.DATA_FROSTBITELIFE_URL+"?serviceKey="+serviceKey+"&AreaNo="+areaNo);
			Element root= doc.getRootElement();
			String success = root.getChild("Header").getChildText("SuccessYN");
			//성공여부 체크
			if("Y".equals(success) ){
				frostbitelife = root.getChild("Body").getChild("IndexModel").getChildText("h3");
				m_traceLogger.info("FROSTBITELIFE : " + frostbitelife);
			}
			else {
				m_traceLogger.warn("FROSTBITELIFE Response fail !!");
			}
		} catch (Exception e) { 
			m_traceLogger.error("FROSTBITELIFE Response error : " + e);
		} 
		return frostbitelife;
	}
	/**
	 * 불쾌지수 정보 
	 * @param vo
	 * @return
	 */
	public String getDsplsLife(String serviceKey){
		String dsplslife = null;
		String areaNo = "108";	//서울
		try { 
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(Constant.DATA_DSPLSLIFE_URL+"?serviceKey="+serviceKey+"&AreaNo="+areaNo);
			Element root= doc.getRootElement();
			String success = root.getChild("Header").getChildText("SuccessYN");
			//성공여부 체크
			if("Y".equals(success) ){
				dsplslife = root.getChild("Body").getChild("IndexModel").getChildText("h3");
				m_traceLogger.info("DSPLSLIFE : " + dsplslife);
			}
			else {
				m_traceLogger.warn("DSPLSLIFE Response fail !!");
			}
		} catch (Exception e) { 
			m_traceLogger.error("DSPLSLIFE Response error : " + e);
		} 
		return dsplslife;
	}
	/**
	 * 부패지수 정보 
	 * @param vo
	 * @return
	 */
	public String getRotLife(String serviceKey){
		String rotlife = null;
		String areaNo = "108";	//서울
		try { 
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(Constant.DATA_ROTLIFE_URL+"?serviceKey="+serviceKey+"&AreaNo="+areaNo);
			Element root= doc.getRootElement();
			String success = root.getChild("Header").getChildText("SuccessYN");
			//성공여부 체크
			if("Y".equals(success) ){
				rotlife = root.getChild("Body").getChild("IndexModel").getChildText("h3");
				m_traceLogger.info("ROTLIFE : " + rotlife);
			}
			else {
				m_traceLogger.warn("ROTLIFE Response fail !!");
			}
		} catch (Exception e) { 
			m_traceLogger.error("ROTLIFE Response error : " + e);
		} 
		return rotlife;
	}
}

package com.flk.safety.detail.service;

import java.util.List;

import net.sf.json.JSONException;

import org.apache.log4j.Logger;

import com.flk.safety.detail.dao.DetailDAO;
import com.flk.safety.detail.vo.Calamity_DisasterVO;
import com.flk.safety.detail.vo.Calamity_LandslideVO;
import com.flk.safety.detail.vo.Food_CertificationVO;
import com.flk.safety.detail.vo.Food_Origin_ViolationVO;
import com.flk.safety.detail.vo.Food_Sanitary_ViolationVO;
import com.flk.safety.detail.vo.Range_CrimeVO;
import com.flk.safety.detail.vo.Range_Crime_ChartVO;
import com.flk.safety.detail.vo.Range_EnvironmentVO;
import com.flk.safety.detail.vo.Range_TrafficVO;
import com.flk.safety.detail.vo.Range_WeatherVO;
import com.flk.safety.detail.vo.Sex_CrimeVO;
import com.flk.safety.detail.vo.Subway_CrimeVO;
import com.flk.safety.detail.vo.TrafficVO;
import com.flk.safety.map.service.MapModeService;

public class DetailService {

	private static volatile DetailService	m_theInstance;
	private static Logger m_traceLogger	= Logger.getLogger("TRACE");
	
	/**
	 * SingleTon Patten
	 * @return
	 */
	public static DetailService getInstance() {
		if(m_theInstance == null){
			synchronized(DetailService.class){
				if(m_theInstance == null){
					m_theInstance = new DetailService();
				}
			}
		}
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public TrafficVO getTraffic_Jayjolking(int id) throws Exception {
		m_traceLogger.info("DetailService getTraffic_Jayjolking() call");
		TrafficVO vo = null;
		try{
			vo = DetailDAO.getInstance().getTraffic_Jayjolking(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public TrafficVO getTraffic_Children(int id) throws Exception {
		m_traceLogger.info("DetailService getTraffic_Children() call");
		TrafficVO vo = null;
		try{
			vo = DetailDAO.getInstance().getTraffic_Children(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Subway_CrimeVO getSubway_Crime(int id) throws Exception {
		m_traceLogger.info("DetailService getSubway_Crime() call");
		Subway_CrimeVO vo = null;
		try{
			vo = DetailDAO.getInstance().getSubway_Crime(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}
	
	public List<Subway_CrimeVO> getSubway_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailService getSubway_CrimeList() call");
		List<Subway_CrimeVO> list = null;
		try{
			list = DetailDAO.getInstance().getSubway_CrimeList(id);
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	
	public Sex_CrimeVO getSex_Crime(int id) throws Exception {
		m_traceLogger.info("DetailService getSex_Crime() call");
		Sex_CrimeVO vo = null;
		try{
			vo = DetailDAO.getInstance().getSex_Crime(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}
	
	public List<Sex_CrimeVO> getSex_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailService getSex_CrimeList() call");
		List<Sex_CrimeVO> list = null;
		try{
			list = DetailDAO.getInstance().getSex_CrimeList(id);
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	public Food_CertificationVO getFood_Certification(int id) throws Exception {
		m_traceLogger.info("DetailService getFood_Certification() call");
		Food_CertificationVO vo = null;
		try{
			vo = DetailDAO.getInstance().getFood_Certification(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Food_Sanitary_ViolationVO getFood_Sanitary_Violation(int id) throws Exception {
		m_traceLogger.info("DetailService getFood_Sanitary_Violation() call");
		Food_Sanitary_ViolationVO vo = null;
		try{
			vo = DetailDAO.getInstance().getFood_Sanitary_Violation(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Food_Origin_ViolationVO getFood_Origin_Violation(int id) throws Exception {
		m_traceLogger.info("DetailService getFood_Origin_Violation() call");
		Food_Origin_ViolationVO vo = null;
		try{
			vo = DetailDAO.getInstance().getFood_Origin_Violation(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Calamity_LandslideVO getCalamity_Landslide(int id) throws Exception {
		m_traceLogger.info("DetailService getCalamity_Landslide() call");
		Calamity_LandslideVO vo = null;
		try{
			vo = DetailDAO.getInstance().getCalamity_Landslide(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Range_TrafficVO getRange_Traffic(int id) throws Exception {
		m_traceLogger.info("DetailService getRange_Traffic() call");
		Range_TrafficVO vo = null;
		try{
			vo = DetailDAO.getInstance().getRange_Traffic(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}
	
	public List<Range_TrafficVO> getRange_TrafficList() throws Exception {
		m_traceLogger.info("DetailService getRange_TrafficList() call");
		List<Range_TrafficVO> list = null;
		try{
			list = DetailDAO.getInstance().getRange_TrafficList();
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	public Range_CrimeVO getRange_Crime(int id) throws Exception {
		m_traceLogger.info("DetailService getRange_Crime() call");
		Range_CrimeVO vo = null;
		try{
			vo = DetailDAO.getInstance().getRange_Crime(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}
	
	public List<Range_Crime_ChartVO> getRange_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailService getRange_CrimeList() call");
		List<Range_Crime_ChartVO> list = null;
		try{
			list = DetailDAO.getInstance().getRange_CrimeList(id);
		}catch(Exception e){
			throw e;
		}
		return list;
	}

	public Range_EnvironmentVO getRange_Environment(int id) throws Exception {
		m_traceLogger.info("DetailService getRange_Environment() call");
		Range_EnvironmentVO vo = null;
		try{
			vo = DetailDAO.getInstance().getRange_Environment(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Range_WeatherVO getRange_Weather(int id) throws Exception {
		m_traceLogger.info("DetailService getRange_Weather() call");
		Range_WeatherVO vo = null;
		try{
			vo = DetailDAO.getInstance().getRange_Weather(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}

	public Calamity_DisasterVO getCalamity_Disaster(int id) throws Exception {
		m_traceLogger.info("DetailService getCalamity_Disaster() call");
		Calamity_DisasterVO vo = null;
		try{
			vo = DetailDAO.getInstance().getCalamity_Disaster(id);
		}catch(Exception e){
			throw e;
		}
		return vo;
	}
}

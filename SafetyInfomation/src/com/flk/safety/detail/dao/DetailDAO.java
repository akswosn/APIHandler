package com.flk.safety.detail.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flk.safety.common.SqlMapClientFactory;
import com.flk.safety.detail.service.DetailService;
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

public class DetailDAO extends SqlMapClientFactory {
	private static volatile DetailDAO	m_theInstance;
	private static Logger m_traceLogger	= Logger.getLogger("TRACE");
	
	/**
	 * SingleTon Patten
	 * @return
	 */
	public static DetailDAO getInstance() {
		if(m_theInstance == null){
			synchronized(DetailDAO.class){
				if(m_theInstance == null){
					m_theInstance = new DetailDAO();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	public TrafficVO getTraffic_Jayjolking(int id) throws Exception  {
		m_traceLogger.info("DetailDAO getTraffic_Jayjolking() call");
		TrafficVO vo = null;
		try{
			vo = (TrafficVO) getSqlMapClient().queryForObject("detail.selectTraffic_Jayjolking", id);
		}catch(SQLException e){
			printQuery("detail.selectTraffic_Jayjolking", id);
			m_traceLogger.error("DetailDAO getTraffic_Jayjolking SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getTraffic_Jayjolking Error : " + e);
			throw e;
		}
		return vo;
	}

	public TrafficVO getTraffic_Children(int id) throws Exception {
		m_traceLogger.info("DetailDAO getTraffic_Children() call");
		TrafficVO vo = null;
		try{
			vo = (TrafficVO) getSqlMapClient().queryForObject("detail.selectTraffic_Children", id);
		}catch(SQLException e){
			printQuery("detail.selectTraffic_Children", id);
			m_traceLogger.error("DetailDAO getTraffic_Children SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getTraffic_Children Error : " + e);
			throw e;
		}
		return vo;
	}

	public Subway_CrimeVO getSubway_Crime(int id) throws Exception {
		m_traceLogger.info("DetailDAO getSubway_Crime() call");
		Subway_CrimeVO vo = null;
		try{
			vo = (Subway_CrimeVO) getSqlMapClient().queryForObject("detail.selectSubway_Crime", id);
		}catch(SQLException e){
			printQuery("detail.selectSubway_Crime", id);
			m_traceLogger.error("DetailDAO getSubway_Crime SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getSubway_Crime Error : " + e);
			throw e;
		}
		return vo;
	}
	
	public List<Subway_CrimeVO> getSubway_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailDAO getSubway_CrimeList() call");
		List<Subway_CrimeVO> list = null;
		try{
			list = (List<Subway_CrimeVO>) getSqlMapClient().queryForList("detail.selectSubway_CrimeList", id);
		}catch(SQLException e){
			printQuery("detail.selectSubway_CrimeList", id);
			m_traceLogger.error("DetailDAO getSubway_CrimeList SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getSubway_CrimeList Error : " + e);
			throw e;
		}
		return list;
	}

	public Sex_CrimeVO getSex_Crime(int id) throws Exception {
		m_traceLogger.info("DetailDAO getSex_Crime() call");
		Sex_CrimeVO vo = null;
		try{
			vo = (Sex_CrimeVO) getSqlMapClient().queryForObject("detail.selectSex_Crime", id);
		}catch(SQLException e){
			printQuery("detail.selectSex_Crime", id);
			m_traceLogger.error("DetailDAO getSex_Crime SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getSex_Crime Error : " + e);
			throw e;
		}
		return vo;
	}
	
	public List<Sex_CrimeVO> getSex_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailDAO getSex_CrimeList() call");
		List<Sex_CrimeVO> list = null;
		try{
			list = (List<Sex_CrimeVO>) getSqlMapClient().queryForList("detail.selectSex_CrimeList", id);
		}catch(SQLException e){
			printQuery("detail.selectSex_CrimeList", id);
			m_traceLogger.error("DetailDAO getSex_CrimeList SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getSex_CrimeList Error : " + e);
			throw e;
		}
		return list;
	}

	public Food_CertificationVO getFood_Certification(int id) throws Exception {
		m_traceLogger.info("DetailDAO getFood_Certification() call");
		Food_CertificationVO vo = null;
		try{
			vo = (Food_CertificationVO) getSqlMapClient().queryForObject("detail.selectFood_Certification", id);
		}catch(SQLException e){
			printQuery("detail.selectFood_Certification", id);
			m_traceLogger.error("DetailDAO getFood_Certification SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getFood_Certification Error : " + e);
			throw e;
		}
		return vo;
	}

	public Food_Sanitary_ViolationVO getFood_Sanitary_Violation(int id) throws Exception {
		m_traceLogger.info("DetailDAO getFood_Sanitary_Violation() call");
		Food_Sanitary_ViolationVO vo = null;
		try{
			vo = (Food_Sanitary_ViolationVO) getSqlMapClient().queryForObject("detail.selectFood_Sanitary_Violation", id);
		}catch(SQLException e){
			printQuery("detail.selectFood_Sanitary_Violation", id);
			m_traceLogger.error("DetailDAO getFood_Sanitary_Violation SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getFood_Sanitary_Violation Error : " + e);
			throw e;
		}
		return vo;
	}

	public Food_Origin_ViolationVO getFood_Origin_Violation(int id) throws Exception {
		m_traceLogger.info("DetailDAO getFood_Origin_Violation() call");
		Food_Origin_ViolationVO vo = null;
		try{
			vo = (Food_Origin_ViolationVO) getSqlMapClient().queryForObject("detail.selectFood_Origin_Violation", id);
		}catch(SQLException e){
			printQuery("detail.selectFood_Origin_Violation", id);
			m_traceLogger.error("DetailDAO getFood_Origin_Violation SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getFood_Origin_Violation Error : " + e);
			throw e;
		}
		return vo;
	}

	public Calamity_LandslideVO getCalamity_Landslide(int id) throws Exception {
		m_traceLogger.info("DetailDAO getCalamity_Landslide() call");
		Calamity_LandslideVO vo = null;
		try{
			vo = (Calamity_LandslideVO) getSqlMapClient().queryForObject("detail.selectCalamity_Landslide", id);
		}catch(SQLException e){
			printQuery("detail.selectCalamity_Landslide", id);
			m_traceLogger.error("DetailDAO getCalamity_Landslide SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getCalamity_Landslide Error : " + e);
			throw e;
		}
		return vo;
	}

	public Range_TrafficVO getRange_Traffic(int id) throws Exception {
		m_traceLogger.info("DetailDAO getRange_Traffic() call");
		Range_TrafficVO vo = null;
		try{
			vo = (Range_TrafficVO) getSqlMapClient().queryForObject("detail.selectRange_Traffic", id);
		}catch(SQLException e){
			printQuery("detail.selectRange_Traffic", id);
			m_traceLogger.error("DetailDAO getRange_Traffic SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_Traffic Error : " + e);
			throw e;
		}
		return vo;
	}
	
	public List<Range_TrafficVO> getRange_TrafficList() throws Exception {
		m_traceLogger.info("DetailDAO getRange_TrafficList() call");
		List<Range_TrafficVO> list = null;
		try{
			list = (List<Range_TrafficVO>) getSqlMapClient().queryForList("detail.selectRange_TrafficList", null);
		}catch(SQLException e){
			printQuery("detail.selectRange_TrafficList");
			m_traceLogger.error("DetailDAO getRange_TrafficList SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_Traffic Error : " + e);
			throw e;
		}
		return list;
	}

	public Range_CrimeVO getRange_Crime(int id) throws Exception {
		m_traceLogger.info("DetailDAO getRange_Crime() call");
		Range_CrimeVO vo = null;
		try{
			vo = (Range_CrimeVO) getSqlMapClient().queryForObject("detail.selectRange_Crime", id);
		}catch(SQLException e){
			printQuery("detail.selectRange_Crime", id);
			m_traceLogger.error("DetailDAO getRange_Crime SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_Crime Error : " + e);
			throw e;
		}
		return vo;
	}
	
	public List<Range_Crime_ChartVO> getRange_CrimeList(int id) throws Exception {
		m_traceLogger.info("DetailDAO getRange_CrimeList() call");
		List<Range_Crime_ChartVO> list = null;
		try{
			list = (List<Range_Crime_ChartVO>) getSqlMapClient().queryForList("detail.selectRange_CrimeList", id);
		}catch(SQLException e){
			printQuery("detail.selectRange_CrimeList", id);
			m_traceLogger.error("DetailDAO getRange_CrimeList SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_CrimeList Error : " + e);
			throw e;
		}
		return list;
	}

	public Range_EnvironmentVO getRange_Environment(int id) throws Exception {
		m_traceLogger.info("DetailDAO getRange_Environment() call");
		Range_EnvironmentVO vo = null;
		try{
			vo = (Range_EnvironmentVO) getSqlMapClient().queryForObject("detail.selectRange_Environment", id);
		}catch(SQLException e){
			printQuery("detail.selectRange_Environment", id);
			m_traceLogger.error("DetailDAO getRange_Environment SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_Environment Error : " + e);
			throw e;
		}
		return vo;
	}

	public Range_WeatherVO getRange_Weather(int id) throws Exception {
		m_traceLogger.info("DetailDAO getRange_Weather() call");
		Range_WeatherVO vo = null;
		try{
			vo = (Range_WeatherVO) getSqlMapClient().queryForObject("detail.selectRange_Weather", id);
		}catch(SQLException e){
			printQuery("detail.selectRange_Weather", id);
			m_traceLogger.error("DetailDAO getRange_Weather SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getRange_Weather Error : " + e);
			throw e;
		}
		return vo;
	}

	public Calamity_DisasterVO getCalamity_Disaster(int id) throws Exception {
		m_traceLogger.info("DetailDAO getCalamity_Disaster() call");
		Calamity_DisasterVO vo = null;
		try{
			vo = (Calamity_DisasterVO) getSqlMapClient().queryForObject("detail.selectCalamity_Disaster", id);
		}catch(SQLException e){
			printQuery("detail.selectCalamity_Disaster", id);
			m_traceLogger.error("DetailDAO getCalamity_Disaster SQL Error : " + e);
			throw e;
		}catch(Exception e){
			m_traceLogger.error("DetailDAO getCalamity_Disaster Error : " + e);
			throw e;
		}
		return vo;
	}
}

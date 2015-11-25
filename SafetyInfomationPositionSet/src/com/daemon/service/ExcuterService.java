/*
 * com.daemon.service.ExcuterService
 *
 * Created on 2012. 10. 16.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.daemon.dao.CalamityDisasterDAO;
import com.daemon.dao.CalamityLandslideDAO;
import com.daemon.dao.FoodCertificationDAO;
import com.daemon.dao.FoodOriginViolationDAO;
import com.daemon.dao.FoodSanitaryViolationDAO;
import com.daemon.dao.RangeLocationDAO;
import com.daemon.dao.SexCrimeDAO;
import com.daemon.dao.SubwayCrimeDAO;
import com.daemon.dao.TrafficDAO;
import com.daemon.vo.CalamityDisasterVO;
import com.daemon.vo.CalamityLandslideVO;
import com.daemon.vo.FoodCertificationVO;
import com.daemon.vo.FoodOriginViolationVO;
import com.daemon.vo.FoodSanitaryViolationVO;
import com.daemon.vo.RangeLocationVO;
import com.daemon.vo.SexCrimeVO;
import com.daemon.vo.SubwayCrimeVO;
import com.daemon.vo.TrafficVO;

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

public class ExcuterService
{
	private static volatile ExcuterService	m_theInstance;
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");

	/**
	 * SingleTon Patten
	 * @return
	 */
	public static ExcuterService getInstance() {
		if(m_theInstance == null){
			synchronized(ExcuterService.class){
				if(m_theInstance == null){
					m_theInstance = new ExcuterService();
				}
			}
		}
		
		return m_theInstance;
	}//END OF CONSTRUCTOR

	/**
	 * 재난 - 재해 위험 지구 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<CalamityDisasterVO> selectCalamityDisasterAsNotPosition() {
		return CalamityDisasterDAO.getInstance().selectCalamityDisasterAsNotPosition();
	}

	/**
	 * 재난 - 재해 위험 지구 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionCalamityDisaster(CalamityDisasterVO obj) {
		CalamityDisasterDAO.getInstance().setPositionCalamityDisaster(obj);
	}

	
	/**
	 * 재난 - 산사태 위험 지역  위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<CalamityLandslideVO> selectCalamityLandslideAsNotPosition() {
		return CalamityLandslideDAO.getInstance().selectCalamityLandslideAsNotPosition();
	}

	/**
	 * 재난 - 산사태 위험 지역 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionCalamityLandslide(CalamityLandslideVO obj) {
		CalamityLandslideDAO.getInstance().setPositionCalamityLandslide(obj);
		
	}

	/** 
	 * 재난 - 산사태 위험 지역  위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<FoodCertificationVO> selectFoodCertificationAsNotPosition() {
		return FoodCertificationDAO.getInstance().selectFoodCertificationAsNotPosition();
	}
	
	
	/**
	 * 재난 - 산사태 위험 지역 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionFoodCertification(FoodCertificationVO obj) {
		FoodCertificationDAO.getInstance().setPositionFoodCertification(obj);
	}
	
	/** 
	 * 식품/안전 - 원산지표시 위반정보 공표 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<FoodOriginViolationVO> selectFoodOriginViolationAsNotPosition() {
		return FoodOriginViolationDAO.getInstance().selectFoodOriginViolationAsNotPosition();
	}
	/**
	 * 식품/안전 - 원산지표시 위반정보 공표 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionFoodOriginViolation(FoodOriginViolationVO obj) {
		FoodOriginViolationDAO.getInstance().setPositionFoodOriginViolation(obj);
	}


	/**
	 * 식품/안전 - 식품 위생법 위반업소 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<FoodSanitaryViolationVO> selectFoodSanitaryViolationAsNotPosition() {
		return FoodSanitaryViolationDAO.getInstance().selectFoodSanitaryViolationAsNotPosition();
	}
	/**
	 * 식품/안전 - 식품 위생법 위반업소 공표 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionFoodSanitaryViolation(FoodSanitaryViolationVO obj) {
		FoodSanitaryViolationDAO.getInstance().setPositionFoodFoodSanitaryViolation(obj);
	}
	
	/**
	 * 범죄 - 성범죄 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<SexCrimeVO> selectSexCrimeAsNotPosition() {
		return SexCrimeDAO.getInstance().selectSexCrimeAsNotPosition();
	}
	/**
	 * 범죄 - 성범죄 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionSexCrime(SexCrimeVO obj) {
		SexCrimeDAO.getInstance().setPositionSexCrime(obj);
	}
	
	/**
	 * 범죄 - 지하철역 범죄 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<SubwayCrimeVO> selectSubwayCrimeAsNotPosition() {
		return SubwayCrimeDAO.getInstance().selectSubwayCrimeAsNotPosition();
	}
	/**
	 * 범죄 - 지하철역 범죄 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionSubwayCrime(SubwayCrimeVO obj) {
		SubwayCrimeDAO.getInstance().setPositionSubwayCrime(obj);
	}
	
	/**
	 * 교통 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<TrafficVO> selectTrafficAsNotPosition() {
		return TrafficDAO.getInstance().selectTrafficAsNotPosition();
	}
	/**
	 * 교통 범죄 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionTraffic(TrafficVO obj) {
		TrafficDAO.getInstance().setPositionTraffic(obj);
	}
	
	/**
	 * 범위 - 환경 - 대기환경 정보 위도 경도 없는 데이터 조회
	 * @return
	 */
	public ArrayList<RangeLocationVO> selectRangeLocationNotPosition() {
		return RangeLocationDAO.getInstance().selectRangeLocationNotPosition();
	}
	/**
	 * 범위 - 환경 - 대기환경 정보 위치 정보 데이터 SET
	 * @param obj
	 */
	public void setPositionRangeLocation(RangeLocationVO obj) {
		RangeLocationDAO.getInstance().setPositionRangeLocation(obj);
	}
}

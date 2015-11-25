/*
 * com.damon.excute.MainExcuter
 *
 * Created on 2012. 10. 11.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.daemon.excute;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.daemon.service.ExcuterService;
import com.daemon.util.GoogleAddr2Coord;
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
 * Create Date 2012. 10. 11.
 * @version	1.00 2012. 10. 11.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 11.			최초.
 */

public class MainPorc 
{
	private static Logger m_traceLogger = Logger.getLogger("TRACE");
	
	static Executor exec;
	
	/**
	 * Common Proccess
	 * @param list
	 * @throws Exception
	 */
	public static void commonProc(List list)throws Exception{
		if(list != null && list.size() > 0){
			if(list.get(0) instanceof CalamityDisasterVO){//재난 - 재해 위험 지구 실행
				exec = (Executor)new CalamityDisasterExcutor((ArrayList<CalamityDisasterVO>)list);
				exec.execute();
				m_traceLogger.info("재난 - 재해 위험 지구 위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof CalamityLandslideVO){//재난 - 산사태 위험 지역  위치 저장 처리
				exec = (Executor)new CalamityLandslideExcutor((ArrayList<CalamityLandslideVO>)list);
				exec.execute();
				m_traceLogger.info("재난 - 산사태 위험 지역 위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof FoodCertificationVO){//식품/안전 - 서울 안심먹거리 인증업소 위치 저장 처리
				exec = (Executor)new FoodCertificationExcutor((ArrayList<FoodCertificationVO>)list);
				exec.execute();
				m_traceLogger.info("식품/안전 - 서울 안심먹거리 인증업소 위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof FoodOriginViolationVO){//식품/안전 - 원산지표시 위반정보 공표 위치 저장 처리
				exec = (Executor)new FoodOriginViolationExcutor((ArrayList<FoodOriginViolationVO>)list);
				exec.execute();
				m_traceLogger.info("식품/안전 - 원산지표시 위반정보 공표 위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof FoodSanitaryViolationVO){//식품/안전 - 식품 위생법 위반업소 공표 위치 저장 처리
				exec = (Executor)new FoodSanitaryViolationExcutor((ArrayList<FoodSanitaryViolationVO>)list);
				exec.execute();
				m_traceLogger.info("식품/안전 - 식품 위생법 위반업소 공표 위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof SexCrimeVO){//범죄 - 성범죄 정보  위치 저장 처리
				exec = (Executor)new SexCrimeExcutor((ArrayList<SexCrimeVO>)list);
				exec.execute();
				m_traceLogger.info("범죄 - 성범죄 정보  위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof SubwayCrimeVO){//범죄 - 지하철역 범죄  위치 저장 처리
				exec = (Executor)new SubwayCrimeExcutor((ArrayList<SubwayCrimeVO>)list);
				exec.execute();
				m_traceLogger.info("범죄 - 지하철역 범죄  위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof TrafficVO){//교통 위치 저장 처리
				exec = (Executor)new TrafficExcutor((ArrayList<TrafficVO>)list);
				exec.execute();
				m_traceLogger.info("교통  위치정보 세팅완료.");
			}
			else if(list.get(0) instanceof RangeLocationVO){//범위 - 공통 지역
				exec = (Executor)new RangeLocationExcutor((ArrayList<RangeLocationVO>) list);
				exec.execute();
				m_traceLogger.info("범위 - 지역  위치정보 세팅완료.");
			}
		}
		else {
			return;
		}
	}
	
	
	public static void main(String[] args){
		m_traceLogger.info("PositionSet Start !!");
		//재난 - 재해 위험 지구 실행
		try{
			commonProc(ExcuterService.getInstance().selectCalamityDisasterAsNotPosition());
		}
		catch (Exception e) {
			m_traceLogger.error("재난 - 재해 위험 지구 실행 ERROR : "+e);
		}
		
		//재난 - 산사태 위험 지역  위치 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectCalamityLandslideAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("재난 - 산사태 위험 지역 실행 ERROR : "+e);
		}
		
		//식품/안전 - 서울 안심먹거리 인증업소 위치 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectFoodCertificationAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("식품/안전 - 서울 안심먹거리 인증업소 실행 ERROR : "+e);
		}
		
		//식품/안전 - 원산지표시 위반정보 공표 위치 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectFoodOriginViolationAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("식품/안전 - 원산지표시 위반정보 실행 ERROR : "+e);
		}
		
		//식품/안전 - 식품 위생법 위반업소 공표 위치 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectFoodSanitaryViolationAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("식품/안전 - 식품 위생법 위반업소 실행 ERROR : "+e);
		}
		
		//교통 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectTrafficAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("교통 범죄 실행 ERROR : "+e);
		}
		//범죄 - 성범죄 위치 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectSexCrimeAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("범죄 - 성범죄 정보 실행 ERROR : "+e);
		}
		
		//범죄 - 지하철역 범죄 저장 처리
		try{
			commonProc(ExcuterService.getInstance().selectSubwayCrimeAsNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("범죄 - 지하철역 범죄 실행 ERROR : "+e);
		}
		
		try{
			commonProc(ExcuterService.getInstance().selectRangeLocationNotPosition());
			
		}catch (Exception e) {
			m_traceLogger.error("범죄 - 지하철역 범죄 실행 ERROR : "+e);
		}
		m_traceLogger.info("PositionSet end !!");
	}
}

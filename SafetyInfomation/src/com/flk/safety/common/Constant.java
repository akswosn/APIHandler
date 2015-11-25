/*
 * com.rnx.datastore.common.Constant
 * 
 * Created on 2012. 10. 10.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */

package com.flk.safety.common;


/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 10.
 * @version	1.00 2012. 10. 10.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 10.			최초.
 */

public class Constant
{
	public static final String		DOMAIN							= "SafetyInfomation";
	public static PropertyReader	pror							= PropertyReader.getInstance();
	public static final String		SAFETY_INFOMATION_PROPERTY_PATH	= "safetyInfomation.properties";
	public static final String		GOOGLE_GEOCODE_URL				= pror.getPropertyValue("GOOGLE_GEOCODE_URL");		//무단횡단 사고 다발지역
	//Category
	public static final String		TRAFFIC_JAYJOLKING				= "traffic_jayjolking";		//무단횡단 사고 다발지역
	public static final String		TRAFFIC_CHILDREN				= "traffic_children";			//보행어린이사고 다발지점
	public static final String		SUBWAY_CRIME					= "subway_crime";				//지하철역 범죄
	public static final String		SEX_CRIME						= "sex_crime";					//성범죄자수
	public static final String		FOOD_CERTIFICATION				= "food_certification";		//서울 안심 먹거리 인증업소
	public static final String		FOOD_SANITARY_VIOLATION			= "food_sanitary_violation";	//식품 위생법 위반 업소
	public static final String		FOOD_ORIGIN_VIOLATION			= "food_origin_violation";		//원산지 표시 위반 업소
	public static final String		CALAMITY_LANDSLIDE				= "calamity_landslide";		//재난 - 산사태 위험 지역
	public static final String		RANGE_TRAFFIC					= "range_traffic";				//자치구별 교통안전지수
	public static final String		RANGE_CRIME						= "range_crime";				//자치구별 범죄
	public static final String		RANGE_ENVIRONMENT				= "range_environment";			//자치구별 대기환경 정보
	public static final String		CALAMITY_DISASTER				= "calamity_disaster";			//재난 - 재해 위험 지구
}

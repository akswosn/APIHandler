
package com.flk.seoulapi.common;

public class Constant
{
	public static PropertyReader	pror						= PropertyReader.getInstance();
	public static final String		SEOUL_API_PROPERTY_PATH		= "seoulOpenAPI.properties";							//프로퍼티 명
	public static final String		LOCATION_SI					= "서울";												//환경 시정보

	public static final String		API_KEY						= pror.getPropertyValue("API_KEY");					//인증 key
	public static final String		PARSE_NAME					= pror.getPropertyValue("PARSE_NAME");					//인증키 파싱할 텍스트
	public static final String		PARSE_ROOT_NAME				= pror.getPropertyValue("PARSE_ROOT_NAME");				//Root List 파싱할 텍스트
	public static final String		COMM_ROOT_LIST				= pror.getPropertyValue("COMM_ROOT_LIST");				//공통 파싱할 텍스트

	public static final String		SEOUL_API_URL_ENVIRONMENT	= pror.getPropertyValue("SEOUL_API_URL_ENVIRONMENT");	//환경 api url
	public static final String		CATEGORY_RANGE_ENVIRONMENT	= pror.getPropertyValue("CATEGORY_RANGE_ENVIRONMENT");	//환경 카테고리명
	public static final String		ENVIRONMENT_ROOT			= pror.getPropertyValue("ENVIRONMENT_ROOT");			//환경 Root List
	public static final String		ENVIRONMENT_SOURCE			= "서울특별시 열린 데이터 광장";									//환경 출처

	//ENVIRONMENT api json key
	public static final String		ENVIRONMENT_MSRSTENAME		= "MSRSTENAME";										//자치구명
	public static final String		ENVIRONMENT_MSRDATE			= "MSRDATE";											//조사일짜
	public static final String		ENVIRONMENT_MAXINDEX		= "MAXINDEX";											//통합대기환경지수
	public static final String		ENVIRONMENT_GRADE			= "GRADE";												//통합대기환경지수 등급
	public static final String		ENVIRONMENT_POLLUTANT		= "POLLUTANT";											//지수결정물질
	public static final String		ENVIRONMENT_NITROGEN		= "NITROGEN";											//이산화질소
	public static final String		ENVIRONMENT_OZONE			= "OZONE";												//오존
	public static final String		ENVIRONMENT_CARBON			= "CARBON";											//일산화질소
	public static final String		ENVIRONMENT_SULFUROUS		= "SULFUROUS";											//아황산가스
	public static final String		ENVIRONMENT_PM10			= "PM10";												//미세먼지

	public static final String		SEOUL_API_URL_CERTIFICATION	= pror.getPropertyValue("SEOUL_API_URL_CERTIFICATION");	;
	public static final String		CATEGORY_CERTIFICATION		= pror.getPropertyValue("CATEGORY_CERTIFICATION");
	public static final String		CERTIFICATION_ROOT			= pror.getPropertyValue("CERTIFICATION_ROOT");
	public static final String		CERTIFICATION_SOURCE		= "서울특별시 열린 데이터 광장";

	//CERTIFICATION api json key
	public static final String		CERTIFICATION_CTF_ADDR		= "CTF_ADDR";											//주소
	public static final String		CERTIFICATION_CTF_TEL		= "CTF_TEL";											//전화
	public static final String		CERTIFICATION_CTF_NAME		= "CTF_NAME";											//업소명

	//DATA.GO.KR 관련 변수
	//serice key
	public static final String		DATA_SERVICE_KEY			= pror.getPropertyValue("DATA_SERVICE_KEY");
	//URL
	public static final String		DATA_ULTRVLIFE_URL			= pror.getPropertyValue("DATA_ULTRVLIFE_URL");
	public static final String		DATA_DSPLSLIFE_URL			= pror.getPropertyValue("DATA_DSPLSLIFE_URL");
	public static final String		DATA_SENSORYTEMLIFE_URL		= pror.getPropertyValue("DATA_SENSORYTEMLIFE_URL");
	public static final String		DATA_FROSTBITELIFE_URL		= pror.getPropertyValue("DATA_FROSTBITELIFE_URL");
	public static final String		DATA_ROTLIFE_URL			= pror.getPropertyValue("DATA_ROTLIFE_URL");
	public static final String		DATA_SOURCE					= "기상청";
	public static final String		CATEGORY_RANGE_WEATHER		= pror.getPropertyValue("CATEGORY_RANGE_WEATHER");
	
	
}

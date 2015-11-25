<!DOCTYPE html>
<%@ page import="com.flk.safety.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
<title>위치기반 안전정보 서비스</title>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/modules/jquery.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/modules/jquery.mobile-1.2.0.js"></script>
<script type="text/javascript" src="https://maps.google.com/maps/api/js?v=3.1&sensor=true"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/InfomationMap.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/detailMod.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/searchMode.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/poiMarker.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/guMarker.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/app/ListMode.js"></script>
<link rel="stylesheet" href="/<%=Constant.DOMAIN %>/css/modules/jquery.mobile-1.2.0.min.css"/>
<link rel="stylesheet" href="/<%=Constant.DOMAIN %>/css/default.css"/>
<script type="text/javascript">
	/**
		infoMap : 맵관리 객체 전역변수
		poiMaker : poi 마커(지도 표시 데이터) 관리 전역변수
		guMarker : gu 마커 (지도 표시 데이터) 관리 전역변수
	**/
 	window.onload= function(){
 		$.extend($.mobile,{
			progressBar : true,
			//loadingMessageTextVisible : true,
			//loadingMessage:'지도 로딩중입니다....',
			//loadingMessageTheme:'a',
			defaultPageTransition : 'none'
		});
 		mapInit();
 	}
 	function mapInit(){
		var latitude = ${param.latitude};
		var longitude = ${param.longitude};
		//맵 생성(infoMap 전역변수)
		infoMap = new InfomationMap(latitude, longitude);
		window.location.href = '#mapMode'; //anchor 초기화 (back 버튼 버그 금지)
	}
</script>

<style type="text/css">
	*{
		padding: 0; margin: 0; 
		-webkit-text-size-odjust:none;
	}
	/* map Mode CSS */
	#mapMode, #mapMode > #map_canvas{
		width:100%; height: 100%;
	}
	#searchOK{
		display: none;
	}
	#search_right_div{
		padding: 0; margin: 0; 
		width:34%;
		float: right;
	}
	#search_left_div{
		padding: 0; margin: 0; 
		width:65%;
		float: left;
	}
</style>
</head>

<body>
	<!-- 지도 -->
	<div data-role="page" id="mapMode">
			 <div id="map_canvas"></div>
	</div>
	
	<!--  주소 검색 -->
	<jsp:include page="../searchMode/searchMode.jsp"></jsp:include>
	
	<!-- 리스트 -->
	<jsp:include page="../listMode/listMode.jsp"></jsp:include>
	
	<!-- 상세보기 시작 -->
	<jsp:include page="../detailMod/traffic_jayjolking.jsp"></jsp:include>
	<jsp:include page="../detailMod/traffic_children.jsp"></jsp:include>
	<jsp:include page="../detailMod/subway_crime.jsp"></jsp:include>
	<jsp:include page="../detailMod/sex_crime.jsp"></jsp:include>
	<jsp:include page="../detailMod/food_certification.jsp"></jsp:include>
	<jsp:include page="../detailMod/food_sanitary_violation.jsp"></jsp:include>
	<jsp:include page="../detailMod/food_origin_violation.jsp"></jsp:include>
	<jsp:include page="../detailMod/calamity_landslide.jsp"></jsp:include>
	<jsp:include page="../detailMod/range_traffic.jsp"></jsp:include>
	<jsp:include page="../detailMod/range_crime.jsp"></jsp:include>
	<jsp:include page="../detailMod/range_environment.jsp"></jsp:include>
	<jsp:include page="../detailMod/calamity_disaster.jsp"></jsp:include>
	
	
	<!-- 지수안내 -->
	<jsp:include page="../helpInformation/helpInformation_crime.jsp"></jsp:include>
	<jsp:include page="../helpInformation/helpInformation_environment.jsp"></jsp:include>
	<jsp:include page="../helpInformation/helpInformation_traffic.jsp"></jsp:include>
</body>
</html>
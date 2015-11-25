<%@page import="com.flk.safety.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
<title>맵 테스트</title>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/jquery.js"></script>
<script type="text/javascript" src="/<%=Constant.DOMAIN %>/js/jquery.mobile-1.2.0.min.js"></script>
<link rel="stylesheet" href="/<%=Constant.DOMAIN %>/css/jquery.mobile-1.2.0.min.css"/>
<style type="text/css">
	*{
		padding: 0; margin: 0; 
		-webkit-text-size-odjust:none;
	}
</style>
</head>
<body>
	<div data-role="page">
		<div data-role="content">
			위도, 경도 정보를 가져올수 없습니다.<br/>
			위치 정보 수집 동의후 다시 접속해주시기바랍니다		
		</div> 
		<div data-role="footer" data-position="fixed">
			&nbsp;
		</div>
	</div>
</body>
</html>
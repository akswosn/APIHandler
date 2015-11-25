<%@page import="com.flk.safety.common.Constant"%>
<%@ page language="java" pageEncoding="EUC-KR"%>
<%
	//Default °­³²±¸
	String latitude = "37.5172363";
	String longitude = "127.0473248";
	String url = "/"+Constant.DOMAIN +"/mapMode.do?latitude="+latitude+"&longitude="+longitude;
	response.sendRedirect(url);
%>

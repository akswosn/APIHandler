<%@ page import="com.flk.safety.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div data-role="page" id="help_environment">
	<div class="tab_wrap">
		<ul>
			<li><a href="#help_traffic">교통</a></li>
			<li><a href="#help_crime">범죄</a></li>
			<li><a href="#help_environment" class="on">환경</a></li>
		</ul>
	</div>
	<div class="body_content">
		<h2 class="tit01">자치구별 대기 환경 정보</h2>
		<div class="detail02_wrap">
			<p class="txt02 imp">한국 환경공단 제공 통합 대기 환경지수및등급 적용  </p>
			<p class="txt01">통합대기환경지수 : 아황산가스, 일산화탄소, 오존, 이산화질소, 미세먼지 총 5개 측정물질의 대기 오염도를 표현한 방식 </p>
		</div>

	 
		<div class="detail03_wrap">
			<ul>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_01.png" width="45" height="25" alt="역명" /> 좋음 (0~50)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_02.png" width="45" height="25" alt="역명" /> 보통 (51~100)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_03.png" width="45" height="25" alt="역명" /> 민감군 영향 (101~150)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_04.png" width="45" height="25" alt="역명" /> 나쁨 (151~250)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_05.png" width="45" height="25" alt="역명" /> 매우 나쁨 (251~350)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_evironment_06.png" width="45" height="25" alt="역명" /> 위험 (351~500)</li> 
			</ul>
		</div>
	   
		<p class="source_wrap">*한국환경공단 대기환경시스템 참조<br /><a href="http://www.airkorea.or.kr/" class="lnk">http://www.airkorea.or.kr/</a></p>
	 
	</div>
</div> 

	

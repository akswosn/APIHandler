<%@ page import="com.flk.safety.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div data-role="page" id="help_traffic">
	<div class="tab_wrap">
		<ul>
			<li><a href="#help_traffic" class="on">교통</a></li>
			<li><a href="#help_crime">범죄</a></li>
			<li><a href="#help_environment">환경</a></li>
		</ul>
	</div>
	<div class="body_content">
		<h2 class="tit01">교통 안전 지수</h2>
		<div class="detail02_wrap">
			<p class="txt01">도로교통공단에서 공개한 서울시 및 광역시 교통안전지수 (높을수록 안전)에 근거하여, 평균값을 중심으로 한 상대적 분포에 따라 총 5개 구간으로 구분하고 등급화 함.</p>
		</div>

	 
		<div class="detail03_wrap">
			<ul>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_traffic_01.png" width="45" height="25" alt="교통" /> 교통 안전 높은 편 (초록)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_traffic_02.png" width="45" height="25" alt="교통" />  교통 안전 보통 이상 (파랑)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_traffic_03.png" width="45" height="25" alt="교통" />  교통 안전 사고 발생 (노랑)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_traffic_04.png" width="45" height="25" alt="교통" />  교통 안전 위험한 편 (주황)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_traffic_05.png" width="45" height="25" alt="교통" />  교통 안전 위험 높음 (빨강)</li>
			</ul>
		</div>
	  
		<p class="source_wrap">*위 등급 산정은 도로교통공단의 공식 의견은 아님 </p>
	 
	</div>
</div> 
 

	

<%@ page import="com.flk.safety.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div data-role="page" id="help_crime">
	
	<div class="tab_wrap">
		<ul>
			<li><a href="#help_traffic">교통</a></li>
			<li><a href="#help_crime" class="on">범죄</a></li>
			<li><a href="#help_environment">환경</a></li>
		</ul>
	</div>
	<div class="body_content">
		<h2 class="tit01">자치구별 5대 범죄 발생</h2>
		<div class="detail02_wrap">
			<p class="txt01">
				검찰청 발표 범죄 통계를 기준으로, 각 구별 인구 대비 5대
				범죄 발생건수의(절도,살인,강도,강간,폭력) <span class="imp02">편차 평균비</span>
				를 합산하고 평균을 중심으로 5개 구간으로 구분하여 
				5등급화 함.
			</p>
		</div>
		<div class="detail03_wrap">
			<ul>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_crime_01.png" width="45" height="25" alt="교통" /> 5대 범죄 안전도 높음 (초록)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_crime_02.png" width="45" height="25" alt="교통" /> 5대 범죄 서울 평균보다 안전한 편 (파랑)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_crime_03.png" width="45" height="25" alt="교통" /> 5대 범죄 서울 평균 수준 발생 (노랑)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_crime_04.png" width="45" height="25" alt="교통" /> 5대 범죄 발생 많은 편 (주황)</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/range_crime_05.png" width="45" height="25" alt="교통" /> 5대 범죄 고 위험 (빨강)</li>
			</ul>
		</div>

		<p class="source_wrap"><span class="imp02">*편차 평균비 = (평균 - 구 범죄건수)/평균</span><br />*위 등급 산정은 도로교통공단의 공식 의견은 아님 </p>
	 	<br/>
	 	<br/>
	 	<h2 class="tit01">서울 지하철 역사 내 범죄 발생 현황</h2>
		<div class="detail02_wrap">
			<p class="txt01">서울 지하철 경찰대 발표 지하철 역사 내 범죄 통계를 기준 으로, 3대 범죄 유형별 (절도,성폭력,폭력) 발생건수를 합산하여 이를 3등급화 함.</p>
		</div>
	 
		<div class="detail03_wrap">
			<ul>
				<li><img src="/<%=Constant.DOMAIN %>/image/ico04_01.png" style="float: left;margin-right: 10px;" width="73" height="30" alt="역명" /> ‘11년 60건 이상 발생<br />지하철 역사 내 범죄 위험 높음</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/ico04_02.png" style="float: left;margin-right: 10px;" width="73" height="30" alt="역명" /> ‘11년 20건 이상 발생<br />지하철 역사 내 범죄 위험 높은 편</li>
				<li><img src="/<%=Constant.DOMAIN %>/image/ico04_03.png" style="float: left;margin-right: 10px;" width="73" height="30" alt="역명" /> ‘11년 10건 이상 발생<br />지하철 역사 내 범죄 위험 보통</li>
			</ul>
		</div>
	   
		<p class="source_wrap">*연간 합계 10건 미만 역은 제외<br />*위 등급 산정은 서울 지하철 경찰대의 공식 의견은 아님</p>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="range_environment">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">

		<div class="detail02_wrap">
			<ul>
				<li><span class="cate">구분</span> <span class="txt" style="padding-left: 135px;">: <em class="imp">자치구별 대기환경 정보</em></span></li>
				<li><span class="cate">측정소명</span> <span id="range_environment_name" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">측정날짜</span> <span id="range_environment_measurement_date" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">통합대기환경지수</span> <span id="range_environment_atmosphere" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">등급</span> <span id="range_environment_atmosphere_rating" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">지수결정물질</span> <span id="range_environment_substance" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">이산화질소(단위 ppm)</span> <span id="range_environment_nitrogen_dioxide" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">오존(단위 ppm)</span> <span id="range_environment_ozone" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">일산화탄소(단위 ppm)</span> <span id="range_environment_carbon_monoxide" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">아황산가스(단위 ppm)</span> <span id="range_environment_sourcesulfur_dioxide" class="txt" style="padding-left: 135px;"></span> </li>
				<li><span class="cate">미세먼지(단위 ㎍/㎥)</span> <span id="range_environment_dust" class="txt" style="padding-left: 135px;"></span> </li>
			</ul>
		</div>

		<p id="range_environment_source" class="source_wrap"></p>
	 
	 	<!-- 생활기상지수 미적용 -->
		<div class="detail01_wrap">
			<ul>
				<li><span class="cate">구분</span> <span class="txt">: <em class="imp">생활기상 지수</em></span></li>
				<li><span class="cate">자외선지수</span> <span id="range_weather_ultraviolet_rays" class="txt"></span> </li>
				<li><span class="cate">체감온도</span> <span id="range_weather_temperature" class="txt"></span> </li>
				<li><span class="cate">동상가능지수</span> <span id="range_weather_frostbite" class="txt"></span> </li>
				<li><span class="cate">불쾌지수</span> <span id="range_weather_discomfort" class="txt"></span> </li>
				<li><span class="cate">부패지수</span> <span id="range_weather_decay" class="txt"></span> </li>
			</ul>
		</div>
	  
		<p id="range_weather_source" class="source_wrap"></p>
 
	</div>
</div>
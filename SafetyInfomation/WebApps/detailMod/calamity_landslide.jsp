<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="calamity_landslide">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail01_wrap">
			<ul>
				<li><span class="cate">구분</span> <span class="txt">: <em class="imp">산사태 위험 지역</em></span></li>
				<li><span class="cate">기관명</span> <span id="calamity_landslide_name" class="txt"></span> </li>
				<li><span class="cate">위치</span> <span id="calamity_landslide_location" class="txt"></span> </li>
				<li><span class="cate">자치구 요구</span> <span id="calamity_landslide_demand" class="txt"></span> </li>
				<li><span class="cate">등급</span> <span id="calamity_landslide_rating" class="txt"></span> </li>
			</ul>
		</div>
		<div class="notice_wrap">
			<h2 class="tit"><img src="/SafetyInfomation/image/tit03.png" alt="조사 결과 " /></h2>
			<div class="ct">
				<p id="calamity_landslide_survey"></p>
			</div>
		</div>
		<p id="calamity_landslide_sourc" class="source_wrap"></p>
	</div>
</div>
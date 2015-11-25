<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="food_sanitary_violation">	
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail01_wrap">
			<ul>
				<li><span class="cate">구분</span><span class="txt"> : <em class="imp">식품 위생법 위반 업소</em></span></li>
				<li><span class="cate">업종명</span><span id="food_sanitary_violation_type" class="txt"></span></li>
				<li><span class="cate">업소명</span><span id="food_sanitary_violation_name" class="txt"></span></li>
				<li><span class="cate">주소</span><span id="food_sanitary_violation_location" class="txt"></span></li>
				<li><span class="cate">위반일자</span><span id="food_sanitary_violation_date" class="txt"></span></li>
				<li><span class="cate">처분확정일자</span><span id="food_sanitary_violation_disposal_date" class="txt"></span> </li>
			</ul>
		</div>
		<div class="notice_wrap">
			<h2 class="tit"><img src="/SafetyInfomation/image/tit02.png" width="56" height="17" alt="처분 사항" /></h2>
			<div id="food_sanitary_violation_disposal" class="ct"></div>
		</div>
		<p id="food_sanitary_violation_source" class="source_wrap"></p>
	</div>
</div>
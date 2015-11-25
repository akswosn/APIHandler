<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="food_origin_violation">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail01_wrap">
			<ul>
				<li><span class="cate">구분</span><span class="txt"> : <em class="imp">원산지 표시 위반 업소</em></span></li>
				<li><span class="cate">영업의 종류</span><span id="food_origin_violation_kind" class="txt"></span></li>
				<li><span class="cate">상호</span><span id="food_origin_violation_name" class="txt"></span></li>
				<li><span class="cate">주소</span><span id="food_origin_violation_address" class="txt"></span></li>
				<li><span class="cate">처분일자</span><span id="food_origin_violation_disposal_date" class="txt"></span></li>
				<li><span class="cate">처분권자</span><span id="food_origin_violation_authority" class="txt"></span> </li>
			</ul>
		</div>
		<div class="notice_wrap">
			<h2 class="tit"><img src="/SafetyInfomation/image/tit01.png" width="56" height="17" alt="위반내용" /></h2>
			<div id="food_origin_violation_violations" class="ct"></div>
		</div>
		<p class="source_wrap">출처 : 국립농산물품질관리원</p>
	</div>
</div>
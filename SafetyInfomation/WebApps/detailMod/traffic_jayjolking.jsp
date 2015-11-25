<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div data-role="page" id="traffic_jayjolking">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail02_wrap">
			<ul>
				<li><span class="cate" >구분</span><span class="txt" style="padding-left: 40px;"> : <em class="imp">무단횡단 사고 다발지역</em></span></li>
				<li><span class="cate">위치</span><span id="traffic_jayjolking_location" class="txt" style="padding-left: 40px;"> :  서울시 은평구 응암동 (서부농협 하나로마트 부근)</span></li>
			</ul>
		</div> 
		<div class="table_type01_wrap">
			<table cellpadding="0" cellspacing="0" border="0">
				<col width="50%" />
				<col width="50%" />
				<thead>
					<tr>
						<th>구분</th>
						<th>건수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>발생건수</th>
						<td id="traffic_jayjolking_occurrence"></td>
					</tr>
					<tr>
						<th>사상자수</th>
						<td id="traffic_jayjolking_casualties"></td>
					</tr>
					<tr>
						<th>사망자수</th>
						<td id="traffic_jayjolking_dead"></td>
					</tr>
					<tr>
						<th>중상자수</th>
						<td id="traffic_jayjolking_jungsang"></td>
					</tr>
					<tr>
						<th>경상자수</th>
						<td id="traffic_jayjolking_gyengsang"></td>
					</tr>
					<tr>
						<th>부신자수</th>
						<td id="traffic_jayjolking_busin"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<p class="source_wrap" id="traffic_jayjolking_source"></p>
	</div>
</div>
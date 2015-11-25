<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div data-role="page" id="traffic_children">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail02_wrap">
			<ul>
				<li><span class="cate" >구분</span><span class="txt" style="padding-left: 40px;"> : <em class="imp">보행어린이사고 다발지점</em></span></li>
				<li><span class="cate">위치</span><span id="traffic_children_location" class="txt" style="padding-left: 40px;"></span></li>
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
						<td id="traffic_children_occurrence"></td>
					</tr>
					<tr>
						<th>사상자수</th>
						<td id="traffic_children_casualties"></td>
					</tr>
					<tr>
						<th>사망자수</th>
						<td id="traffic_children_dead"></td>
					</tr>
					<tr>
						<th>중상자수</th>
						<td id="traffic_children_jungsang"></td>
					</tr>
					<tr>
						<th>경상자수</th>
						<td id="traffic_children_gyengsang"></td>
					</tr>
					<tr>
						<th>부신자수</th>
						<td id="traffic_children_busin"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<p class="source_wrap" id="traffic_children_source"></p>
	</div>
</div>

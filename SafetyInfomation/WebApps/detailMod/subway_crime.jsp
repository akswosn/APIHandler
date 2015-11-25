<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div data-role="page" id="subway_crime">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail02_wrap">
			<ul>
				<li><span class="cate" >구분</span><span class="txt" style="padding-left: 45px;"> : <em class="imp">서울 지하철역 범죄</em></span></li>
				<li><span class="cate">역사명</span><span id="subway_crime_station" class="txt" style="padding-left: 45px;"></span></li>
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
					<tr id='theftLine' onclick="changeLine_subway_crime('theft')">
						<th>절도</th>
						<td id="subway_crime_theft"></td>
					</tr>
					<tr id='sexual_violenceLine' onclick="changeLine_subway_crime('sexual_violence')">
						<th class="imp">성폭력처벌특례법 위반</th>
						<td id="subway_crime_sexual_violence" class="imp"></td>
					</tr>
					<tr id='violenceLine' onclick="changeLine_subway_crime('violence')">
						<th>폭력</th>
						<td id="subway_crime_violence"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="gp_wrap">
			<div class="clumn">
				<h2 id="subway_crime_h2"></h2>
				<div class="larr">
					<img onclick="btnSubway_crime_Chart(document.getElementById('crime').value,'left')" src="/SafetyInfomation/image/larr.png" alt="보기" />
					<p id="subway_crime_leftp" class="imp"></p>
				</div>
				<div class="graphBox">
					<ul>
		                <li class="g1"><span class="counter1">0</span><p id="subway_crime_yearp1"></p></li>
		                <li class="g2"><span class="counter2">0</span><p id="subway_crime_yearp2"></p></li>
		                <li class="g3"><span class="counter3">0</span><p id="subway_crime_yearp3"></p></li>
		                <li class="g4"><span class="counter4">0</span><p id="subway_crime_yearp4"></p></li>
		            </ul>
		        </div>
				<div class="rarr">
					<img onclick="btnSubway_crime_Chart(document.getElementById('crime').value,'right')" src="/SafetyInfomation/image/rarr.png" alt="보기" />
					<p id="subway_crime_rightp" class="imp"></p>
				</div>
		    </div>
		    <input type='hidden' id='crime' value='' />
			<input type='hidden' id='yearList' value='' />
			<input type='hidden' id='theftList' value='' />
			<input type='hidden' id='sexual_violenceList' value='' />
			<input type='hidden' id='violenceList' value='' />
		</div>
		<p id="subway_crime_source" class="source_wrap"></p>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="range_crime">	
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail02_wrap">
			<ul>
				<li><span class="cate" >구분</span><span class="txt" style="padding-left: 45px;"> : <em class="imp">서울 자치구별 범죄</em></span></li>
				<li><span class="cate">역사명</span><span id="range_crime_sub_location" class="txt" style="padding-left: 45px;"></span></li>
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
					<tr id='larcenyLine' onclick="changeLine_range_crime('larceny')">
						<th>절도</th>
						<td id="range_crime_larceny"></td>
					</tr>
					<tr id='murderLine' onclick="changeLine_range_crime('murder')">
						<th class="imp">살인</th>
						<td id="range_crime_murder" class="imp"></td>
					</tr>
					<tr id='robberyLine' onclick="changeLine_range_crime('robbery')">
						<th class="imp">강도</th>
						<td id="range_crime_robbery" class="imp"></td>
					</tr>
					<tr id='rapeLine' onclick="changeLine_range_crime('rape')">
						<th class="imp">강간</th>
						<td id="range_crime_rape" class="imp"></td>
					</tr>
					<tr id='r_violenceLine' onclick="changeLine_range_crime('violence')">
						<th>폭력</th>
						<td id="range_crime_violence"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="gp_wrap">
			<div class="clumn">
				<h2 id="range_crime_h2"></h2>
				<div class="larr">
					<img onclick="btnRange_crime_Chart(document.getElementById('r_crime').value,'left')" src="/SafetyInfomation/image/larr.png" alt="보기" />
					<p id="range_crime_leftp" class="imp"></p>
				</div>
				<div class="graphBox">
					<ul>
		                <li class="g1"><span class="counter1">0</span><p id="range_crime_gup1"></p></li>
		                <li class="g2"><span class="counter2">0</span><p id="range_crime_gup2"></p></li>
		                <li class="g3"><span class="counter3">0</span><p id="range_crime_gup3"></p></li>
		                <li class="g4"><span class="counter4">0</span><p id="range_crime_gup4"></p></li>
		            </ul>
		        </div>
				<div class="rarr">
					<img onclick="btnRange_crime_Chart(document.getElementById('r_crime').value,'right')" src="/SafetyInfomation/image/rarr.png" alt="보기" />
					<p id="range_crime_rightp" class="imp"></p>
				</div>
		    </div>
		    <input type='hidden' id='r_crime' value='' />
			<input type='hidden' id='larceny_countList' value='' />
			<input type='hidden' id='larceny_locationList' value='' />
			<input type='hidden' id='murder_countList' value='' />
			<input type='hidden' id='murder_locationList' value='' />
			<input type='hidden' id='robbery_countList' value='' />
			<input type='hidden' id='robbery_locationList' value='' />
			<input type='hidden' id='rape_countList' value='' />
			<input type='hidden' id='rape_locationList' value='' />
			<input type='hidden' id='violence_countList' value='' />
			<input type='hidden' id='violence_locationList' value='' />
		</div>
		<p id="range_crime_source" class="source_wrap"></p>
	</div>
</div>
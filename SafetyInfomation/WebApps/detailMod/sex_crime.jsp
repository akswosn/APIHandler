<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="sex_crime">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="detail02_wrap">
			<ul>
				<li><span class="cate" >구분</span><span class="txt" style="padding-left: 40px;"> : <em class="imp">성범죄자수</em></span></li> 
			</ul>
			<ul>
				<li><span class="cate" >지역</span><span id="sex_crime_area" class="txt" style="padding-left: 40px;"></span></li> 
			</ul>
		</div> 
		<div class="table_type01_wrap">
			<table cellpadding="0" cellspacing="0" border="0">
				<col width="34%" />
				<col width="33%" />
				<col width="33%" />
				<thead>
					<tr>
						<th>구 이름</th>
						<th>동 이름</th>
						<th>성범죄자수</th>
					</tr>
				</thead>
				<tbody id="tbody_sex_crime">
					
				</tbody>
			</table>
		</div>
		<p id="sex_crime_source" class="source_wrap"></p>
	</div>
</div>
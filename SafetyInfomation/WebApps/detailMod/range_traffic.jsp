<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div data-role="page" id="range_traffic">	
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="body_content">
		<div class="table_thead_wrap">
			<div class="detail02_wrap">
				<ul>
					<li><span class="cate" >구분</span><span class="txt" style="padding-left:40px;"> : <em class="imp" id="range_traffic_year"></em></span></li> 
				</ul>
			</div> 
			<div class="table_type01_wrap">
				<table cellpadding="0" cellspacing="0" border="0">
					<colgroup>
						<col width="34%" />
						<col width="33%" />
						<col width="33%" />
					</colgroup>
					<thead>
						<tr>
							<th>지역</th>
							<th>시군구</th>
							<th>지수</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="table_tbody_wrap">
			<div class="table_type01_wrap">
				<table cellpadding="0" cellspacing="0" border="0">
					<colgroup>
						<col width="34%" />
						<col width="33%" />
						<col width="33%" />
					</colgroup>
					<tbody id="tbody_range_traffic">
					
					</tbody>
				</table>
			</div>
		</div>	 
		<p id="range_traffic_source" class="source_wrap_fixed"></p>
	</div>
</div>
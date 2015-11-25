<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript">
		$(document).ready(function(){
			$('.noValue').click(function(){
				$(this).val('').removeClass('noValue');
			});
		});
	</script>
<div data-role="#page" id="searchMode">
	<h1 class="hidden_obj">상세 보기</h1>
	<div class="contents" id="serchContent">
		<div  class="sch_input" style="clear: both;">
			<div id="search_left_div">
				<input style="height:38px;" id="search" type="search" data-inline="true" class="noValue" value="주소를 입력하세요"/> 
			</div>
			<div id="search_right_div">
				<a style="height:38px;" data-role="button" data-inline="true" data-icon="search" href="javascript:searchSubmit()">검색</a>
			</div>
			<div style="clear: both;"></div>
		</div>
		
		<div id="searchOK"></div>
		<div id="searchFail">
			<p class="sch_txt">
				이동하고 싶은 <span>주소</span>를 입력해 주세요.
			</p> 
		</div>
		<!-- //search -->
	</div>
</div>


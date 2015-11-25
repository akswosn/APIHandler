/**
 * 
 */
/*검색 실행*/
	function searchSubmit(){
		//var seachTxt = $('#search').value;
		var seachTxt = document.getElementById('search').value;
		$.ajax({
			type: "POST",
			//url: "https://maps.googleapis.com/maps/api/geocode/json",
			url: "search.do",
			data: "searchText="+seachTxt,
			dataType:"json",
			success: function(msg){
				if(msg.size > 0){
					createListView(msg);
					$("#searchOK").show(200);
					$("#searchFail").hide(200);
				}
				else {
					$("#searchOK").hide(200);
					$("#searchFail").show(200);
				}
			}
		});
	}
	/*검색결과 생성*/
	function createListView(data){
		$("#searchOK > ul").remove();
		
		var tagLi, tagA;
		var tagUl = $("<ul class=\"list_mode sch_result\">");
		for(var i =0; i < data.size; i++){
			var temp = data.result[i];
			tagLi = $("<li>");
			tagA = $("<a href=\'javascript:clickSearchResult(\""+temp.latitude+"\", \""+temp.longitude+"\")\'>")
				.html(temp.address);
			tagLi.append(tagA);
			tagUl.append(tagLi);
		}
		tagUl.appendTo($("#searchOK"));
	}
	
	/*검색 결과 선택*/
	function clickSearchResult(lat, lon){
		window.location.href = 'mapMode.do?latitude='+lat+'&longitude='+lon;
	}
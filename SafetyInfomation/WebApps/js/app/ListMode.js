function initListMode(categoryList){
	var guList = guMarker.guList;
	var poiList = poiMarker.poiList;
	
	$("#listContent > ul").remove();
	
	var tagUl = $("<ul class='list_mode'>");
	var tagLi, tagA, tagStrong, tagSpan, tagSpan_2;
	var crime_obj, environment_obj,	traffic_obj; 
	
	for(var j = 0; j < categoryList.length ; j++){
		if(categoryList[j].category == 'range_crime'){
			crime_obj = categoryList[j];
		}
		if(categoryList[j].category == 'range_environment'){
			environment_obj = categoryList[j];
		}
		if(categoryList[j].category == 'range_traffic'){
			traffic_obj = categoryList[j];
		}
	}
	
	//gu 데이터
	for(var i =0; i < guList.length; i++){
		var temp = guList[i];
		var title, high_category;
		if(temp.range_crime_id != null && temp.range_crime_id != 0){
			tagLi = $("<li>");
			tagA = $("<a href=\'javascript:infoMap.moveToDetail(\""+temp.range_crime_id+"\", \""+temp.range_crime_category+"\")\'>")
			tagStrong = $("<Strong>").html(crime_obj.category_name);
			tagSpan = $("<span class=\"addr\">").html(temp.location);
			tagSpan_2 = $("<span class=\"lct\">").html(crime_obj.high_category_name);
			tagA.append(tagStrong);
			tagA.append(tagSpan);
			tagA.append(tagSpan_2);
			tagLi.append(tagA);
			tagUl.append(tagLi);
		}
		if(temp.range_environment_id != null && temp.range_environment_id != 0){
			tagLi = $("<li>");
			tagA = $("<a href=\'javascript:infoMap.moveToDetail(\""+temp.range_environment_id+"\", \""+temp.range_environment_category+"\")\'>")
			tagStrong = $("<Strong>").html(environment_obj.category_name);
			tagSpan = $("<span class=\"addr\">").html(temp.location);
			tagSpan_2 = $("<span class=\"lct\">").html(environment_obj.high_category_name);
			tagA.append(tagStrong);
			tagA.append(tagSpan);
			tagA.append(tagSpan_2);
			tagLi.append(tagA);
			tagUl.append(tagLi);
			
		}
		if(temp.range_traffic_id != null && temp.range_traffic_id != 0){
			tagLi = $("<li>");
			tagA = $("<a href=\'javascript:infoMap.moveToDetail(\""+temp.range_traffic_id+"\", \""+temp.range_traffic_category+"\")\'>")
			tagStrong = $("<Strong>").html(traffic_obj.category_name);
			tagSpan = $("<span class=\"addr\">").html(temp.location);
			tagSpan_2 = $("<span class=\"lct\">").html(traffic_obj.high_category_name);
			tagA.append(tagStrong);
			tagA.append(tagSpan);
			tagA.append(tagSpan_2);
			tagLi.append(tagA);
			tagUl.append(tagLi);
		}
	}
	//poi 데이터
	for(var i =0; i < poiList.length; i++){
		var temp = poiList[i];
		tagLi = $("<li>");
		tagA = $("<a href=\'javascript:infoMap.moveToDetail(\""+temp.id+"\", \""+temp.category+"\")\'>")
		tagStrong = $("<Strong>").html(temp.title);
		tagSpan = $("<span class=\"addr\">").html(temp.address);
		tagSpan_2 = $("<span class=\"lct\">").html(temp.high_category);
		tagA.append(tagStrong);
		tagA.append(tagSpan);
		tagA.append(tagSpan_2);
		tagLi.append(tagA);
		tagUl.append(tagLi);
	}
	
	tagUl.appendTo($("#listContent"));
}
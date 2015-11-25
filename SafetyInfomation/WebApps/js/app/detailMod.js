	//무단횡단 사고 다발지역
	function setTraffic_jayjolking(json){
		var data = json.data;
		$("span#traffic_jayjolking_location").html(":  " + data.location);
		$("td#traffic_jayjolking_occurrence").html(data.occurrence);
		$("td#traffic_jayjolking_casualties").html(data.casualties);
		$("td#traffic_jayjolking_dead").html(data.dead);
		$("td#traffic_jayjolking_jungsang").html(data.jungsang);
		$("td#traffic_jayjolking_gyengsang").html(data.gyengsang);
		$("td#traffic_jayjolking_busin").html(data.busin);
		$("p#traffic_jayjolking_source").html("출처 : " + data.source + " (" + data.year + ")");
	}
	
	//보행어린이사고 다발지점
	function setTraffic_children(json){
		var data = json.data;
		$("span#traffic_children_location").html(" :  " + data.location);
		$("td#traffic_children_occurrence").html(data.occurrence);
		$("td#traffic_children_casualties").html(data.casualties);
		$("td#traffic_children_dead").html(data.dead);
		$("td#traffic_children_jungsang").html(data.jungsang);
		$("td#traffic_children_gyengsang").html(data.gyengsang);
		$("td#traffic_children_busin").html(data.busin);
		$("p#traffic_children_source").html("출처 : " + data.source + " (" + data.year + ")");
	}
	
	//서울지하철역 범죄
	function setSubway_crime(json){
		document.getElementById("yearList").value = "";
		document.getElementById("theftList").value = "";
		document.getElementById("sexual_violenceList").value = "";
		document.getElementById("violenceList").value = "";
		var data = json.data;
		var list = json.list;
		$("h2#subway_crime_h2").html("절도 범죄 발생 현황<span>('\'10년, 건수)</span>");
		$("span#subway_crime_station").html(":  " + data.station);
		$("td#subway_crime_theft").html(data.theft);
		$("td#subway_crime_sexual_violence").html(data.sexual_violence);
		$("td#subway_crime_violence").html(data.violence);
		$("p#subway_crime_source").html("출처 : " + data.source + " (" + data.year + ")");
		var s = 1;
		$(list).each(function(){
			var year = this.year;
			var theft = this.theft;
			var sexual_violence = this.sexual_violence;
			var violence = this.violence;
			document.getElementById("yearList").value = document.getElementById("yearList").value + year + "/";
			document.getElementById("theftList").value = document.getElementById("theftList").value + theft + "/";
			document.getElementById("sexual_violenceList").value = document.getElementById("sexual_violenceList").value + sexual_violence + "/";
			document.getElementById("violenceList").value = document.getElementById("violenceList").value + violence + "/";
		});
		changeLine_subway_crime("theft");
	}
	
	//성범죄자수
	function setSex_crime(json){
		$(".sex_crime_tr").remove(); //초기화
		var data = json.data;
		var list = json.list;
		$("span#sex_crime_area").html(" :  " + data.area);
		$(list).each(function(){
			var id = this.id;
			var area = this.area;
			var gu = this.gu;
			var dong = this.dong;
			var count = this.count;
			var source = this.source;
			var year = this.year;
			$("<tr class='sex_crime_tr'>")
				.html(
					"<td id='" + id + "1'>" + gu + "</td>" +
					"<td id='" + id + "2'>" + dong + "</td>" +
					"<td id='" + id + "3'>" + count + "</td>"
				)
				.appendTo($("tbody#tbody_sex_crime"));
		});
		$("p#sex_crime_source").html("출처 : " + data.source + " (" + data.year + ")");
		document.getElementById(data.id+"1").style.background = "#ffcccc";
		document.getElementById(data.id+"2").style.background = "#ffcccc";
		document.getElementById(data.id+"3").style.background = "#ffcccc";
	}
	
	//서울 안심 먹거리 인증업소
	function setFood_certification(json){
		var data = json.data;
		
		$("span#food_certification_name").html(":  " + data.name);
		$("span#food_certification_address").html(":  " + data.address);
		$("span#food_certification_tel").html(":  " + data.tel);
		$("p#food_certification_source").html("출처 :  " + data.source);
	}
	
	//식품 위생법 위반 업소
	function setFood_sanitary_violation(json){
		var data = json.data;
		$("span#food_sanitary_violation_type").html(":  " + data.type);
		$("span#food_sanitary_violation_name").html(":  " + data.name);
		$("span#food_sanitary_violation_location").html(":  " + data.location);
		$("span#food_sanitary_violation_date").html(":  " + data.violation_date);
		$("span#food_sanitary_violation_disposal_date").html(":  " + data.disposal_date);
		$("div#food_sanitary_violation_disposal").html(data.disposal);
		$("p#food_sanitary_violation_source").html("출처 : " + data.source + " (" + data.year + ")");
	}
	
	//원산지 표시 위반 업소
	function setFood_origin_violation(json){
		var data = json.data;
		
		$("span#food_origin_violation_kind").html(":  " + data.kind);
		$("span#food_origin_violation_name").html(":  " + data.name);
		$("span#food_origin_violation_address").html(":  " + data.address);
		$("span#food_origin_violation_disposal_date").html(":  " + data.disposal_date);
		$("span#food_origin_violation_authority").html(":  " + data.authority);
		$("div#food_origin_violation_violations").html(data.violations);
	}
	
	//산사태 위험 지역
	function setCalamity_landslide(json){
		var data = json.data;
		
		$("span#calamity_landslide_name").html(":  " + data.name);
		$("span#calamity_landslide_location").html(":  " + data.location);
		$("span#calamity_landslide_demand").html(":  " + data.demand);
		$("span#calamity_landslide_rating").html(":  " + data.rating);
		$("p#calamity_landslide_survey").html(data.survey);
		$("p#calamity_landslide_sourc").html("출처 : " + data.source + " (" + data.year + ")");
	}
	//교통안전지수
	function setRange_traffic(json){
		$(".range_traffic_tr").remove(); //초기화
		var data = json.data;
		var list = json.list;
		$("tbody#tbody_range_traffic")
			.html(
				"<tr style=\"background-color:#ffcccc;\" class='range_traffic_tr'>" +
				"<th>" + data.location + "</td>" +
				"<td>" + data.sub_location + "</td>" +
				"<td>" + data.indice + "</td>"
			);
		$("em#range_traffic_year").html(data.year + " 교통안전지수");
		$("p#range_traffic_source").html("출처 : " + data.source + " (" + data.year + ")");
		$(list).each(function(){
			var id = this.id;
			var location = this.location;
			var sub_location = this.sub_location;
			var indice = this.indice;
			if(data.id != id){
				$("<tr class='range_traffic_tr'>")
				.html(
					"<th>" + location + "</td>" +
					"<td>" + sub_location + "</td>" +
					"<td>" + indice + "</td>"
				)
				.appendTo($("tbody#tbody_range_traffic"));
			}
		});
	}
	
	//서울 자치구별 범죄
	function setRange_crime(json){
		document.getElementById("larceny_countList").value = "";
		document.getElementById("larceny_locationList").value = "";
		document.getElementById("murder_countList").value = "";
		document.getElementById("murder_locationList").value = "";
		document.getElementById("robbery_countList").value = "";
		document.getElementById("robbery_locationList").value = "";
		document.getElementById("rape_countList").value = "";
		document.getElementById("rape_locationList").value = "";
		document.getElementById("violence_countList").value = "";
		document.getElementById("violence_locationList").value = "";
		
		var data = json.data;
		var list = json.list;
		$("h2#range_crime_h2").html("절도 범죄 발생 현황<span>('\'10년, 인구 1천명당 건수)</span>");
		$("span#range_crime_sub_location").html(":  " + data.sub_location);
		$("td#range_crime_larceny").html(data.larceny);
		$("td#range_crime_murder").html(data.murder);
		$("td#range_crime_robbery").html(data.robbery);
		$("td#range_crime_rape").html(data.rape);
		$("td#range_crime_violence").html(data.violence);
		$("p#range_crime_source").html("출처 : " + data.source + " (" + data.year + ")");
		
		var s = 1;
		$(list).each(function(){
			var larceny_count = this.larceny_count;
			var larceny_location = this.larceny_location;
			var murder_count = this.murder_count;
			var murder_location = this.murder_location;
			var robbery_count = this.robbery_count;
			var robbery_location = this.robbery_location;
			var rape_count = this.rape_count;
			var rape_location = this.rape_location;
			var violence_count = this.violence_count;
			var violence_location = this.violence_location;
			document.getElementById("larceny_countList").value = document.getElementById("larceny_countList").value + larceny_count + "/";
			document.getElementById("larceny_locationList").value = document.getElementById("larceny_locationList").value + larceny_location + "/";
			document.getElementById("murder_countList").value = document.getElementById("murder_countList").value + murder_count + "/";
			document.getElementById("murder_locationList").value = document.getElementById("murder_locationList").value + murder_location + "/";
			document.getElementById("robbery_countList").value = document.getElementById("robbery_countList").value + robbery_count + "/";
			document.getElementById("robbery_locationList").value = document.getElementById("robbery_locationList").value + robbery_location + "/";
			document.getElementById("rape_countList").value = document.getElementById("rape_countList").value + rape_count + "/";
			document.getElementById("rape_locationList").value = document.getElementById("rape_locationList").value + rape_location + "/";
			document.getElementById("violence_countList").value = document.getElementById("violence_countList").value + violence_count + "/";
			document.getElementById("violence_locationList").value = document.getElementById("violence_locationList").value + violence_location + "/";
		});
		changeLine_range_crime("larceny");
	}
	
	//자치구별 대기환경 정보 + 생활기상지수
	function setRange_environment(json){
		var data = json.data;
		var data1 = json.data1;
		
		//자치구별 대기환경 정보
		$("span#range_environment_name").html(":  " + data.name);
		$("span#range_environment_measurement_date").html(":  " + data.measurement_date);
		$("span#range_environment_atmosphere").html(":  " + data.atmosphere);
		$("span#range_environment_atmosphere_rating").html(":  " + data.atmosphere_rating);
		$("span#range_environment_substance").html(":  " + data.substance);
		$("span#range_environment_nitrogen_dioxide").html(":  " + data.nitrogen_dioxide);
		$("span#range_environment_ozone").html(":  " + data.ozone);
		$("span#range_environment_carbon_monoxide").html(":  " + data.carbon_monoxide);
		$("span#range_environment_sourcesulfur_dioxide").html(":  " + data.sourcesulfur_dioxide);
		$("span#range_environment_dust").html(":  " + data.dust);
		$("p#range_environment_source").html("출처 : " + data.source);
		
		//생활기상지수
		$("span#range_weather_ultraviolet_rays").html(":  " + data1.ultraviolet_rays);
		$("span#range_weather_temperature").html(":  " + data1.temperature);
		$("span#range_weather_frostbite").html(":  " + data1.frostbite);
		$("span#range_weather_discomfort").html(":  " + data1.discomfort);
		$("span#range_weather_decay").html(":  " + data1.decay);
		$("p#range_weather_source").html("출처 : " + data1.source);
	}
	
	//재해 위험 지구
	function setCalamity_disaster(json){
		var data = json.data;
		$("span#calamity_disaster_type").html(":  " + data.type);
		$("span#calamity_disaster_address").html(":  " + data.address);
		$("span#calamity_disaster_facility_name").html(":  " + data.facility_name);
		$("span#calamity_disaster_facility_type").html(":  " + data.facility_type);
		$("span#calamity_disaster_water_system").html(":  " + data.water_system);
		$("span#calamity_disaster_specified_date").html(":  " + data.specified_date);
		$("span#calamity_disaster_reason").html(":  " + data.reason);
		$("span#calamity_disaster_risk").html(":  " + data.risk);
		$("span#calamity_disaster_propulsion").html(":  " + data.propulsion);
		$("span#calamity_disaster_organ").html(":  " + data.organ);
		$("span#calamity_disaster_organ_tel").html(":  " + data.organ_tel);
		$("p#calamity_disaster_source").html("출처 : " + data.source);
	}
	
	//서울지하철역 범죄 차트 버튼
	function btnSubway_crime_Chart(beforecrime, direction){
		if(direction == 'left'){
			if(beforecrime == 'sexual_violence'){
				changeLine_subway_crime('theft');
	    	}else if(beforecrime == 'violence'){
	    		changeLine_subway_crime('sexual_violence');
	    	}
		}else{
			if(beforecrime == 'theft'){
				changeLine_subway_crime('sexual_violence');
	    	}else if(beforecrime == 'sexual_violence'){
	    		changeLine_subway_crime('violence');
	    	}
		}
	}
	
	//서울지하철역 범죄 차트 변경
    function changeLine_subway_crime(crime){
    	document.getElementById("crime").value = crime;
    	if(crime == "theft"){
    		$("h2#subway_crime_h2").html("절도 범죄 발생 현황<span>('\'10년, 건수)</span>");
    		$("p#subway_crime_leftp").html("");
    		$("p#subway_crime_rightp").html("성폭력");
    	}else if(crime == "sexual_violence"){
    		$("h2#subway_crime_h2").html("성폭력 범죄 발생 현황<span>('\'10년, 건수)</span>");
    		$("p#subway_crime_leftp").html("절도");
    		$("p#subway_crime_rightp").html("폭력");
    	}else{
    		$("h2#subway_crime_h2").html("폭력 범죄 발생 현황<span>('\'10년, 건수)</span>");
    		$("p#subway_crime_leftp").html("성폭력");
    		$("p#subway_crime_rightp").html("");
    	}
    	var selectyear = document.getElementById("yearList").value.split("/");	//마지막 배열은 빈값이 들어감
    	var selectCrime = document.getElementById(crime+"List").value.split("/");	//마지막 배열은 빈값이 들어감
    	var Operator = getHeightOperator(selectCrime);	//차트 높이 연산값
    	var count = 0;
    	var nonCount = 5 - selectCrime.length;
    	$(".graphBox li span").text('0');
    	for(var i=0; i<4; i++){
    		if(i >= nonCount){
    			$(".graphBox .g"+(i+1)).animate({height:(((selectCrime[count]*Operator*2)/1.4).toFixed(0))+"px"}, 500);
    			$("p#subway_crime_yearp"+(i+1)).html(selectyear[count].substring(2,4) + "년");
    			$('.graphBox .counter'+(i+1)).text(selectCrime[count++]);
    		}else{
    			$(".graphBox .g"+(i+1)).animate({height:(0*2)+"px"}, 500);
    			$('.graphBox .counter'+(i+1)).text("0");
    		}
    	}
    	$(".graphBox li span").fadeIn(500);
    	document.getElementById("theftLine").style.background = "";
		document.getElementById("sexual_violenceLine").style.background = "";
		document.getElementById("violenceLine").style.background = "";
    	document.getElementById(crime+"Line").style.background = "#ffcccc";
    }
    
    //서울 자치구별 범죄 차트 버튼
	function btnRange_crime_Chart(beforecrime, direction){
		if(direction == 'left'){
			if(beforecrime == 'murder'){
				changeLine_range_crime('larceny');
	    	}else if(beforecrime == 'robbery'){
	    		changeLine_range_crime('murder');
	    	}else if(beforecrime == 'rape'){
	    		changeLine_range_crime('robbery');
	    	}else if(beforecrime == 'violence'){
	    		changeLine_range_crime('rape');
	    	}
		}else{
			if(beforecrime == 'larceny'){
				changeLine_range_crime('murder');
	    	}else if(beforecrime == 'murder'){
	    		changeLine_range_crime('robbery');
	    	}else if(beforecrime == 'robbery'){
	    		changeLine_range_crime('rape');
	    	}else if(beforecrime == 'rape'){
	    		changeLine_range_crime('violence');
	    	}			
		}
	}
	
    //서울 자치구별 범죄 차트 변경
    function changeLine_range_crime(crime){
    	document.getElementById("r_crime").value = crime;
    	document.getElementById("larcenyLine").style.background = "";
    	document.getElementById("murderLine").style.background = "";
    	document.getElementById("robberyLine").style.background = "";
    	document.getElementById("rapeLine").style.background = "";
    	document.getElementById("r_violenceLine").style.background = "";
    	
    	if(crime == "larceny"){
    		$("h2#range_crime_h2").html("절도 범죄 발생 현황<span>('지역, 인구 1,000명당 건수)</span>");
    		$("p#range_crime_leftp").html("");
    		$("p#range_crime_rightp").html("살인");
    		
    		var arrangeLarceny_count = document.getElementById("larceny_countList").value.split("/");
    		var arrangeLarceny_location = document.getElementById("larceny_locationList").value.split("/");
    		
    		changeChart(arrangeLarceny_count, arrangeLarceny_location, "larcenyLine");
    	}else if(crime == "murder"){
    		$("h2#range_crime_h2").html("살인 범죄 발생 현황<span>('지역, 인구 100,000명당 건수)</span>");
    		$("p#range_crime_leftp").html("절도");
    		$("p#range_crime_rightp").html("강도");
    		
    		var arrangeMurder_count = document.getElementById("murder_countList").value.split("/");
    		var arrangeMurder_location = document.getElementById("murder_locationList").value.split("/");
    		
    		changeChart(arrangeMurder_count, arrangeMurder_location, "murderLine");
    	}else if(crime == "robbery"){
    		$("h2#range_crime_h2").html("강도 발생 현황<span>('지역, 인구 10,000명당 건수)</span>");
    		$("p#range_crime_leftp").html("살인");
    		$("p#range_crime_rightp").html("강간");
    		
    		var arrangeRobbery_count = document.getElementById("robbery_countList").value.split("/");
    		var arrangeRobbery_location = document.getElementById("robbery_locationList").value.split("/");
    		
    		changeChart(arrangeRobbery_count, arrangeRobbery_location, "robberyLine");
    	}else if(crime == "rape"){
    		$("h2#range_crime_h2").html("강간 범죄 발생 현황<span>('지역, 인구 10,000명당 건수)</span>");
    		$("p#range_crime_leftp").html("강도");
    		$("p#range_crime_rightp").html("폭력");
    		
    		var arrangeRape_count = document.getElementById("rape_countList").value.split("/");
    		var arrangeRape_location = document.getElementById("rape_locationList").value.split("/");
    		
    		changeChart(arrangeRape_count, arrangeRape_location, "rapeLine");
    	}else{
    		$("h2#range_crime_h2").html("폭력 범죄 발생 현황<span>('지역, 인구 10,000명당 건수)</span>");
    		$("p#range_crime_leftp").html("강간");
    		$("p#range_crime_rightp").html("");
    		
    		var arrangeViolence_count = document.getElementById("violence_countList").value.split("/");
    		var arrangeViolence_location = document.getElementById("violence_locationList").value.split("/");
    		
    		changeChart(arrangeViolence_count, arrangeViolence_location, "r_violenceLine");
    	}
    }
    
    //서울자치구별 범죄 차트 변경
    function changeChart(numbers, location, docId){
    	var Operator1 = getHeightOperator(numbers);	//차트 높이 연산값
		document.getElementById(docId).style.background = "#ffcccc";
		
    	$(".graphBox li span").text('0');
		for(var i=0; i<4; i++){
			$(".graphBox .g"+(i+1)).animate({height:(((numbers[i]*Operator1*2)/1.4).toFixed(0))+"px"}, 500);
			$("p#range_crime_gup"+(i+1)).html(location[i]);
			$('.graphBox .counter'+(i+1)).text(numbers[i]);
		}
		$(".graphBox li span").fadeIn(500);
		
		
    }
    
    //차트 높이 연산값
	function getHeightOperator(numbers){
		var heightOperator = 1;
		for(var i=0; i<numbers.length-1; i++){
			if(heightOperator < parseInt(numbers[i])){
				heightOperator = parseInt(numbers[i]);
			}
		}
		heightOperator = 100 / heightOperator;
		return heightOperator;
	}
	
	//교통안전지수 css
	$(document).ready(function(){
		var tHeight = $('.table_thead_wrap').outerHeight()-11;
		$('.table_tbody_wrap').css('margin-top',tHeight);
	});
	$(window).resize(function(){
		var tHeight = $('.table_thead_wrap').outerHeight()-11;
		$('.table_tbody_wrap').css('margin-top',tHeight);
	});
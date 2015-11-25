/**
 * Infomation Map 위치기반 안전정보 맵 관리 객체
 */
var infoMap; //맵 관리 전역변수

function InfomationMap(lat, lng){
	this.lat = lat;
	this.lng = lng;
	this.imagePath = '/SafetyInfomation/image/';
	
	var latlng = new google.maps.LatLng(lat, lng);
	var myOptions = {
		zoom : 16,
		center : latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	this.map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	
	//zoom 제한 설정 이벤트
	google.maps.event.addListener(this.map, 'zoom_changed', function(e){
		if(this.zoom < 15){
    		this.setZoom(15);
    	}
		else if(this.zoom > 19){
			this.setZoom(19);
		}
		guMarker.clearCircleOverlays();
		guMarker.createircleOverlays(this.zoom);
		poiMarker.clearPOIOverlays();
		poiMarker.showPOIOverlays();
    });
	
	/*
	//상세보기 테스트 용 이벤트
	google.maps.event.addListener(this.map, 'click', function(e){
		infoMap.detailTest(e);
	});
	 * */
	
	//지도 버튼 생성
	this.createBtn(latlng);
	//내위치 표시
	this.myPosition(latlng);
	
	this.dataLoad(lat, lng, this.map.getZoom());
};
//상세보기 테스트용 
InfomationMap.prototype.detailTest = function(e, num){
	
	var categoryList = ['traffic_jayjolking'
	                    , 'traffic_children'
	                    , 'subway_crime'
	                    , 'sex_crime'
	                    , 'food_certification'
	                    , 'food_sanitary_violation'
	                    , 'food_origin_violation'
	                    , 'calamity_landslide'
	                    , 'calamity_disaster'];
	var categoryname = ['무단횡단사고다발지역'
	                    , '보행어린이사고다발지역'
	                    , '지하철역범죄'
	                    , '성범죄자수'
	                    , '서울안심먹거리인증업소'
	                    , '식품위생법위반업소'
	                    , '원산지표시위반업소'
	                    , '산사태위험지역'
	                    , '재해위험지구'];
	var noList = [128,188,1,146,1,105,176,4,6];
	var imagePath = '/SafetyInfomation/image/';
	if(num < 9){
		var latitude = e.latLng.lat();
		var longitude = e.latLng.lng();
		var img;
		
		if(categoryList[num] == "traffic_jayjolking"){
			img = 'poi_traffic_jayjolking.png';
		}else if(categoryList[num] == "traffic_children"){
			img = 'poi_traffic_children.png';
		}else if(categoryList[num] == "subway_crime"){
			img = 'poi_subway_crime.png';
		}else if(categoryList[num] == "sex_crime"){
			img = 'poi_sex_crime.png';
		}else if(categoryList[num] == "food_certification"){
			img = 'poi_food_certification.png';
		}else if(categoryList[num] == "food_sanitary_violation"){
			img = 'poi_food_violation.png';
		}else if(categoryList[num] == "food_origin_violation"){
			img = 'poi_food_violation.png';
		}else if(categoryList[num] == "calamity_landslide"){
			img = 'poi_calamity.png';
		}else if(categoryList[num] == "calamity_disaster"){
			img = 'poi_calamity.png';
		}
		
		var markupLatlng = new google.maps.LatLng(latitude, longitude);
		
		var poiMarker = new google.maps.Marker({
			position : markupLatlng,
			title : categoryList[num],
			id : noList[num],
			icon:imagePath+img,
			map : infoMap.getMap()
		});
		console.log('상세보기 테스트용 마커를 등록합니다. [ type : ' + categoryname[num] +' ]');
		infoMap.addEvent(poiMarker, noList[num], categoryList[num]);
	}
};
//getMap() 지도 리턴
InfomationMap.prototype.getMap = function(){
	return this.map;
};
//createBtn(latlng)버튼 등록 
InfomationMap.prototype.createBtn = function (latlng){
	
	//내위치로 이동 버튼 등록
	var homeControlDiv = document.createElement('div');
	var homeControl = this.HomeControl(homeControlDiv, latlng);
	homeControlDiv.index = 1;
	this.map.controls[google.maps.ControlPosition.LEFT].push(homeControlDiv);
    /*
        검색버튼
     * */
	var serchControlDiv = document.createElement('div');
	var serchControl = this.SearchControl(serchControlDiv);
	serchControlDiv.index = 1;
	this.map.controls[google.maps.ControlPosition.LEFT].push(serchControlDiv);
	//지수안내 이동 버튼 등록
	var helpControlDiv = document.createElement('div');
	var helpControl = this.HelpControl(helpControlDiv);
	helpControlDiv.index = 1;
	this.map.controls[google.maps.ControlPosition.LEFT].push(helpControlDiv);
	
	/*
	    리스트모드 버튼
	 * */
	var listModeControlDiv = document.createElement('div');
	var listModeControl = this.ListModeControl(listModeControlDiv);
	
	listModeControlDiv.index = 1;
	this.map.controls[google.maps.ControlPosition.RIGHT].push(listModeControlDiv);

	//zoom in 이동 버튼 등록
	var zoomDiv = document.createElement('div');
	zoomDiv.setAttribute("class", "zoom");
	var zoomInControlDiv = document.createElement('div');
	var zoomOutControl = this.ZoomInControl(zoomInControlDiv);
	//zoomInControlDiv.index = 1;
	//this.map.controls[google.maps.ControlPosition.RIGHT].push(zoomInControlDiv);
	//zoomout 이동 버튼 등록
	var zoomOutControlDiv = document.createElement('div');
	var zoomOutControl = this.ZoomOutControl(zoomOutControlDiv);
	//zoomOutControlDiv.index = 1;
	//this.map.controls[google.maps.ControlPosition.RIGHT].push(zoomOutControlDiv);
	zoomDiv.appendChild(zoomOutControlDiv);
	zoomDiv.appendChild(zoomInControlDiv);
	zoomDiv.index = 1;
	this.map.controls[google.maps.ControlPosition.RIGHT].push(zoomDiv);
	
};
//내 위치 표시 function
InfomationMap.prototype.myPosition = function(latlng){
	var myPlace = 'myplace.png';
	var myMarker = new google.maps.Marker({
		position : latlng,
		icon : this.imagePath + myPlace
	});
	myMarker.setMap(this.map);
};
// map Center change
InfomationMap.prototype.setMapCenter = function(lat, lng){
	var latlng = new google.maps.LatLng(lat, lng);
	infoMap.getMap().panTo(latlng);
	//window.setTimeout(function() {
	//}, 1000);
};
//내위치 이동 버튼 함수
InfomationMap.prototype.HomeControl = function (controlDiv, latlng) {
	var bg_pos_off = 'bg_pos_off.png';
	var bg_pos_on = 'bg_pos_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	
	var controlUI = document.createElement('img');
	var path = this.imagePath;
	controlUI.id='bg_pos_btn';
	controlUI.width='54';
	controlUI.height='54';
	controlUI.src=this.imagePath +bg_pos_off;
	controlDiv.appendChild(controlUI);
	google.maps.event.addDomListener(controlUI, 'click', function() {
		infoMap.setMapCenter(latlng.lat(), latlng.lng());
	});
	google.maps.event.addDomListener(controlDiv, 'mousedown', function() {
		controlUI.src=path+bg_pos_on;
	});
	google.maps.event.addDomListener(controlDiv, 'mouseup', function() {
		controlUI.src=path+bg_pos_off;
	});
};

//지수안내 버튼 함수
InfomationMap.prototype.HelpControl = function(controlDiv){
	var help_use_off = 'help_use_off.png';
	var help_use_on = 'help_use_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	
	var controlUI = document.createElement('img');
	var path = this.imagePath;
	controlUI.id='help_btn';
	controlUI.width='54';
	controlUI.height='54';
	controlUI.src=this.imagePath+help_use_off;
	controlDiv.appendChild(controlUI);
	
	google.maps.event.addDomListener(controlDiv, 'click', function() {
		window.location.href = '#help_traffic';
	});
	google.maps.event.addDomListener(controlDiv, 'mousedown', function() {
		controlUI.src=path+help_use_on;
	});
	google.maps.event.addDomListener(controlDiv, 'mouseup', function() {
		controlUI.src=path+help_use_off;
	});
};
//zoom in 버튼 함수
InfomationMap.prototype.ZoomInControl = function (controlDiv){
	var btn_zoom_in_off = 'btn_zoom_in_off.png';
	var btn_zoom_in_on = 'btn_zoom_in_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	var path = this.imagePath;
	var controlUI = document.createElement('img');
	controlUI.id='zoom_in_btn';
	controlUI.width='33';
	controlUI.height='33';
	controlUI.src=path+btn_zoom_in_off;
	controlDiv.appendChild(controlUI);
	
	google.maps.event.addDomListener(controlDiv, 'click', function() {
		infoMap.getMap().setZoom(infoMap.getMap().getZoom()+1);
	});
	google.maps.event.addDomListener(controlDiv, 'mousedown', function() {
		controlUI.src=path+btn_zoom_in_on;
	});
	google.maps.event.addDomListener(controlDiv, 'mouseup', function() {
		controlUI.src=path+btn_zoom_in_off;
	});
};
//zoom out
InfomationMap.prototype.ZoomOutControl = function (controlDiv){
	var btn_zoom_out_off = 'btn_zoom_out_off.png';
	var btn_zoom_out_on = 'btn_zoom_out_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	var path = this.imagePath;
	var controlUI = document.createElement('img');
	controlUI.id='zoom_out_btn';
	controlUI.width='33';
	controlUI.height='33';
	controlUI.src=this.imagePath+btn_zoom_out_off;
	controlDiv.appendChild(controlUI);
	
	google.maps.event.addDomListener(controlDiv, 'click', function() {
		infoMap.getMap().setZoom(infoMap.getMap().getZoom()-1);
	});
	google.maps.event.addDomListener(controlDiv, 'mousedown', function() {
		controlUI.src=path+btn_zoom_out_on;
	});
	google.maps.event.addDomListener(controlDiv, 'mouseup', function() {
		controlUI.src=path+btn_zoom_out_off;
	});
};

//리스트모드 버튼 함수
InfomationMap.prototype.ListModeControl = function (controlDiv){
	var btn_list_off = 'btn_list_off.png';
	var btn_list_on = 'btn_list_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	var path = this.imagePath;
	var controlUI = document.createElement('img');
	controlUI.id='list_btn';
	controlUI.width='54';
	controlUI.height='54';
	controlUI.src=this.imagePath+btn_list_off;
	controlDiv.appendChild(controlUI);
	
	google.maps.event.addDomListener(controlUI, 'click', function() {
		$.ajax({
			type: "POST",
			url: "categoryData.do",
			dataType:"json",
			success: function(categoryData){
				categoryList = categoryData.categoryList;
				initListMode(categoryList);
				window.location.href = '#listMode';
			}
		});
	});
	google.maps.event.addDomListener(controlUI, 'mousedown', function() {
		controlUI.src=path+btn_list_on;
	});
	google.maps.event.addDomListener(controlUI, 'mouseup', function() {
		controlUI.src=path+btn_list_off;
	});
	
};
//검색 버튼 함수
InfomationMap.prototype.SearchControl = function (controlDiv){
	var btn_search_off = 'btn_search_off.png';
	var btn_search_on = 'btn_search_on.png';
	controlDiv.style.padding = '0';
	controlDiv.style.margin = '0';
	controlDiv.style.cursor = 'pointer';
	var path = this.imagePath;
	var controlUI = document.createElement('img');
	controlUI.id='search_btn';
	controlUI.width='54';
	controlUI.height='54';
	controlUI.src=this.imagePath+btn_search_off;
	controlDiv.appendChild(controlUI);
	
	google.maps.event.addDomListener(controlUI, 'click', function() {
		window.location.href='#searchMode';
	});
	google.maps.event.addDomListener(controlUI, 'mousedown', function() {
		controlUI.src=path+btn_search_on;
	});
	google.maps.event.addDomListener(controlUI, 'mouseup', function() {
		controlUI.src=path+btn_search_off;
	});
};
//poi, 구 데이터 load function
InfomationMap.prototype.dataLoad = function(latitude, longitude, zoom){
	this.poiDataLoad(latitude, longitude);
	this.guDataLoad(latitude, longitude, zoom);
};
//poi data load
InfomationMap.prototype.poiDataLoad = function (latitude, longitude){
	$.ajax({
		type: "POST",
		url: "poiData.do",
		data: "latitude="+latitude+"&longitude="+longitude,
		dataType:"json",
		success: function(poiData){
			if(poiData != null){
				poiData = poiData.poiList;
				poiMarker.init(infoMap.getMap(), poiData);
				//poi 표시
				for ( var i = 0; i < poiData.length; i++) {
					poiMarker.addPOIMarker(poiData[i]);
				}
			}
		}
	});
};
//gu data load
InfomationMap.prototype.guDataLoad = function(latitude, longitude, zoom){
	$.ajax({
		type: "POST",
		url: "guData.do",
		data: "latitude="+latitude+"&longitude="+longitude,
		dataType:"json",
		success: function(guData){
			if(guData != null){
				guData = guData.guList;
				guMarker.init(infoMap.getMap(), guData);
				//구 표시
				for ( var i = 0; i < guData.length; i++) {
					guMarker.addGuCircle(guData[i], zoom);
				}
			}
		}
	});
};
//상세 페이지 이동 이벤트 등록 함수
InfomationMap.prototype.addEvent = function(marker, id, category){
	google.maps.event.addListener(marker, 'click', function(e) {
		infoMap.moveToDetail(id, category);
	});
};
//상세 페이지 이동 이벤트 등록 함수 상세
InfomationMap.prototype.moveToDetail=function(id, category){
	$.ajax({
    	url: "detail.do?category=" + category + "&id=" + id,
    	typ: "get",
    	dataType: "json",
    	timeout: 3000,
    	success: function(json){
			if(category == "traffic_jayjolking"){
				setTraffic_jayjolking(json);
			}else if(category == "traffic_children"){
				setTraffic_children(json);
			}else if(category == "subway_crime"){
				setSubway_crime(json);
			}else if(category == "sex_crime"){
				setSex_crime(json);
			}else if(category == "food_certification"){
				setFood_certification(json);
			}else if(category == "food_sanitary_violation"){
				setFood_sanitary_violation(json);
			}else if(category == "food_origin_violation"){
				setFood_origin_violation(json);
			}else if(category == "calamity_landslide"){
				setCalamity_landslide(json);
			}else if(category == "range_traffic"){
				setRange_traffic(json);
			}else if(category == "range_crime"){
				setRange_crime(json);
			}else if(category == "range_environment"){
				setRange_environment(json);
			}else if(category == "calamity_disaster"){
				setCalamity_disaster(json);
			}
			
			window.location.href = '#'+category;
    	},
    	error: function(xhr, textStatus, errorThrown){
    		console.log("category = " + category + " // id =" + id +" // textStatus = " + textStatus + " // errorThrown = " + errorThrown);
    		alert("서버에서 정보를 가져오는중 문제가 발생하였습니다. 관리자에게 문의 하시기 바랍니다.");
    	}
    });
};
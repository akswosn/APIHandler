/**
 * poi Marker Object
 * **/

poiMarker = {
	//초기화
	init : function(map, poiList){
		this.poiMarkersArray = [];
		this.imagePath = '/SafetyInfomation/image/';
		this.poi_calamity = 'poi_calamity.png';
		this.poi_food_certification='poi_food_certification.png';
		this.poi_food_violation='poi_food_violation.png';
		this.poi_hospital='poi_hospital.png';
		this.poi_sex_crime='poi_sex_crime.png';
		this.poi_subway_crime = 'poi_subway_crime.png';
		this.poi_traffic_children='poi_traffic_children.png';
		this.poi_traffic_jayjolking='poi_traffic_jayjolking.png';
		this.map = map;
		this.poiList = poiList; //원본 array 데이터
	},
	
	//poiMarkersArray 마커 객체 등록 및 지도에 표시
	addPOIMarker : function(obj){
		var latitude = Number(obj.latitude);
		var longitude = Number(obj.longitude);
		var img;
		
		//category 별 분기
		if(obj.category == "traffic_jayjolking"){
			img = this.poi_traffic_jayjolking;
		}else if(obj.category == "traffic_children"){
			img = this.poi_traffic_children;
		}else if(obj.category == "subway_crime"){
			img = this.poi_subway_crime;
		}else if(obj.category == "sex_crime"){
			img = this.poi_sex_crime;
		}else if(obj.category == "food_certification"){
			img = this.poi_food_certification;
		}else if(obj.category == "food_sanitary_violation" 
			|| obj.category == "food_origin_violation"){
			img = this.poi_food_violation;
		}else if(obj.category == "calamity_landslide"
			|| obj.category == "calamity_disaster"){
			img = this.poi_calamity;
		}
		
		var markupLatlng = new google.maps.LatLng(latitude, longitude);
		
		//지도에 마커 등록
		var poiMarker = new google.maps.Marker({
			position : markupLatlng,
			title : obj.category,
			id : obj.id,
			icon:this.imagePath+img,
			map : this.map,
			zIndex : 2
		});
		//이벤트 등록(click)
		infoMap.addEvent(poiMarker, obj.id, obj.category);
		
		//리스트에 등록
		this.poiMarkersArray.push(poiMarker);
	},
	//리스트에 등록된 marker 지도에 표시
	showPOIOverlays : function(){
		if (this.poiMarkersArray) {
			for (i in this.poiMarkersArray) {
				this.poiMarkersArray[i].setMap(this.map);
			}
		}
	},
	//리스트에 등록된 마커 숨김
	clearPOIOverlays : function(){
		if (this.poiMarkersArray) {
			for (i in this.poiMarkersArray) {
				this.poiMarkersArray[i].setMap(null);
			}
		}
	},
	//마커 삭제 및 리스트 삭제
	deletePOIOverlays : function(){
		if (this.poiMarkersArray) {
			for (i in this.poiMarkersArray) {
				this.poiMarkersArray[i].setMap(null);
			}
			this.poiMarkersArray.length = 0;
		}
	}
}
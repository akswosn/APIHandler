/**
 * Gu Marker object
 * **/
guMarker = {
	init : function(map, guList){
		this.guCirclesArray = [];
		this.guMarkerTraffic = [];
		this.guMarkerEnvironment = [];
		this.guMarkerCrime = [];
		this.guNames = [];
		this.imagePath = '/SafetyInfomation/image/';
		this.imageTrafficName = 'range_traffic_';
		this.imageEvironmentName = 'range_evironment_';
		this.imageCrimeName = 'range_crime_';
		this.extention = '.png';
		this.map = map;
		this.guList = guList;	//원본 array 데이터
		//zoom에 따른 marker 위치, circle 위치 변경용 객체(오차 데이터)
		this.zoomobj = [
			{//15
				 radius : 12000,
				 guNameRange : 0.0008,
				 trafficLat : 0.0007,
				 trafficLng : 0.0035,
				 crimeLat : 0.0005,
				 crimeLng : 0.0035,
				 environmentLat : 0.0017,
				 environmentLng : 0.0035
			},
			{//16
				 radius : 8000,
				 guNameRange : 0.0003,
				 trafficLat : 0.0003,
				 trafficLng : 0.0023,
				 crimeLat : 0.0003,
				 crimeLng : 0.0023,
				 environmentLat : 0.0009,
				 environmentLng : 0.0023
			},
			{//17
				 radius : 5000,
				 guNameRange : 0.0002,
				 trafficLat : 0.0002,
				 trafficLng : 0.0014,
				 crimeLat : 0.0001,
				 crimeLng : 0.0014,
				 environmentLat : 0.0004,
				 environmentLng : 0.0014
			},
			{//18
				 radius : 3000,
				 guNameRange : 0.0001,
				 trafficLat : 0.0001,
				 trafficLng : 0.0008,
				 crimeLat : 0.00005,
				 crimeLng : 0.0008,
				 environmentLat : 0.0002,
				 environmentLng : 0.0008
			},
			{//19
				 radius : 1500,
				 guNameRange : 0.00005,
				 trafficLat : 0.000025,
				 trafficLng : 0.0004,
				 crimeLat : 0.00005,
				 crimeLng : 0.0004,
				 environmentLat : 0.00013,
				 environmentLng : 0.0004
			}
		]
		     
	},
	// Circle(구영역 표시) 등록 및 지도에 표시
	addGuCircle : function(obj, zoom) {
		var latitude = Number(obj.latitude);
		var longitude = Number(obj.longitude);
		var latlng = new google.maps.LatLng(latitude, longitude);
		var index = zoom - 15;
		
		//Circle 지도에 표시
		//zoom 에 따른 원 호 길이 변경
		var populationOptions = {
			strokeColor : "#FF0000",
			strokeOpacity : 0.6,
			strokeWeight : 2,
			fillColor : "#FF0000",
			fillOpacity : 0.2,
			map : this.map,
			center : latlng,
			radius : this.zoomobj[index].radius / 40 
		};
		
		var cityCircle = new google.maps.Circle(populationOptions); 
		//리스트에 Circle 객체 add
		this.guCirclesArray.push(cityCircle);
		
		/* guName img code_no 별로 네이밍되어있음*/
		var marker = new google.maps.Marker({
			position : new google.maps.LatLng(latitude - this.zoomobj[index].guNameRange, longitude),
			icon : this.imagePath + 'guName/' + obj.code_no + this.extention,
			map : this.map
		});
		this.guNames.push(marker);
		
		// 환경, 교통, 범죄 Marker 등록 및 지도에 표시 하는 function 호출
		this.addTrafficMarker(obj, zoom);
		this.addCrimeMarker(obj, zoom);
		this.addEnvironmentMarker(obj, zoom);
	},
	//zoom 이벤트에 따른 데이터 재 표시
	createircleOverlays : function(zoom){
		if(this.guList != null){
			for(i in this.guList){
				this.addGuCircle(this.guList[i], zoom);
			}
		}
	},
	//리스트에 저장된 Circle 표시 (사용 x)
	showCircleOverlays : function(){
		if (this.guCirclesArray) {
			for (i in this.guCirclesArray) {
				this.guCirclesArray[i].setMap(this.map);
			}
			for (i in this.guNames) {
				this.guNames[i].setMap(this.map);
			}
		}
		//각 리스트에 저장된 환경, 교통, 범죄 Marker 지도에 표시 function 호출
		this.showTrafficOverlays();
		this.showCrimeOverlays();
		this.showEnvironmentOverlays();
	},
	//리스트에 저장된 Circle 숨김 
	clearCircleOverlays : function() {
		if (this.guCirclesArray) {
			for (i in this.guCirclesArray) {
				this.guCirclesArray[i].setMap(null);
			}
			for (i in this.guNames) {
				this.guNames[i].setMap(null);
			}
		}
		//각 리스트에 저장된 환경, 교통, 범죄 Marker 지도에 숨김 function 호출
		this.clearTrafficOverlays();
		this.clearCrimeOverlays();
		this.clearEnvironmentOverlays();
	},
	//Circle 삭제 및 리스트 삭제
	deleteCircleOverlays : function() {
		if (this.guCirclesArray) {
			for (i in this.guCirclesArray) {
				this.guCirclesArray[i].setMap(null);
			}
			for (i in this.guNames) {
				this.guNames[i].setMap(null);
			}
			this.guCirclesArray.length = 0;
			this.guNames.length = 0;
		}
		//환경, 교통, 범죄 Marker 삭제 및 리스트 삭제 function 호츌
		this.deleteTrafficOverlays();
		this.deleteCrimeOverlays();
		this.deleteEnvironmentOverlays();
	},
	// 교통 Marker 지도 표시 및 리스트 등록
	addTrafficMarker : function(obj, zoom) {
		var latitude, longitude;
		var index = zoom - 15;
		
		latitude = Number(obj.latitude)+this.zoomobj[index].trafficLat;
		longitude = Number(obj.longitude)+this.zoomobj[index].trafficLng;
		
		var trafficImgPath = '';
		
		if(obj.range_traffic_id != 0){
			if(obj.range_traffic_rating == '1'){
				trafficImgPath = this.imagePath + this.imageTrafficName +'01' + this.extention;
			}
			else if(obj.range_traffic_rating == '2'){
				trafficImgPath = this.imagePath + this.imageTrafficName +'02' +this.extention;
			}
			else if(obj.range_traffic_rating == '3'){
				trafficImgPath = this.imagePath + this.imageTrafficName +'03' +this.extention;
			}
			else if(obj.range_traffic_rating == '4'){
				trafficImgPath = this.imagePath + this.imageTrafficName +'04' +this.extention;
			}
			else if(obj.range_traffic_rating == '5'){
				trafficImgPath = this.imagePath + this.imageTrafficName +'05' +this.extention;
			}
			var latlng = new google.maps.LatLng(latitude, longitude);
			var trafficMarker = new google.maps.Marker({
				position : latlng,
				icon : trafficImgPath,
				map : this.map,
				zIndex:1
			});
			
			infoMap.addEvent(trafficMarker, obj.range_traffic_id, obj.range_traffic_category);
			this.guMarkerTraffic.push(trafficMarker);
		}
	},
	//교통 Marker 지도 표시
	showTrafficOverlays : function(){
		if (this.guMarkerTraffic) {
			for (i in this.guMarkerTraffic) {
				this.guMarkerTraffic[i].setMap(this.map);
			}
		}
	},
	//교통 Marker 지도 숨김
	clearTrafficOverlays : function() {
		if (this.guMarkerTraffic) {
			for (i in this.guMarkerTraffic) {
				this.guMarkerTraffic[i].setMap(null);
			}
		}
	},
	//교통 Marker 삭제 및 리스트 삭제
	deleteTrafficOverlays : function() {
		if (this.guMarkerTraffic) {
			for (i in this.guMarkerTraffic) {
				this.guMarkerTraffic[i].setMap(null);
			}
			this.guMarkerTraffic.length = 0;
		}
	},
	//환경 Marker 지도 표시및 리스트 등록
	addEnvironmentMarker : function(obj, zoom) {
		var latitude, longitude;
		var index = zoom - 15;
		//zoom 레벨에 따른 위치 재조정
		latitude = Number(obj.latitude)-this.zoomobj[index].environmentLat;
		longitude = Number(obj.longitude)+this.zoomobj[index].environmentLng;
		
		
		
		var environmentImgPath = '';
		
		if(obj.range_environment_id != 0){
			if(obj.range_environment_rating == '1'){
				environmentImgPath = this.imagePath + this.imageEvironmentName +'01' +this.extention;
			}
			else if(obj.range_environment_rating == '2'){
				environmentImgPath = this.imagePath + this.imageEvironmentName +'02' +this.extention;
			}
			else if(obj.range_environment_rating == '3'){
				environmentImgPath = this.imagePath + this.imageEvironmentName +'03' +this.extention;
			}
			else if(obj.range_environment_rating == '4'){
				environmentImgPath = this.imagePath + this.imageEvironmentName +'04' +this.extention;
			}
			else if(obj.range_environment_rating == '5'){
				environmentImgPath = this.imagePath + this.imageEvironmentName +'05' +this.extention;
			}
			else{
				environmentImgPath = this.imagePath + this.imageEvironmentName +'06' +this.extention;
			}
			var latlng = new google.maps.LatLng(latitude, longitude);
			var environmentMarker = new google.maps.Marker({
				position : latlng,
				icon : environmentImgPath,
				map : this.map,
				zIndex:1
			});
			
			infoMap.addEvent(environmentMarker, obj.range_environment_id, obj.range_environment_category);
			this.guMarkerEnvironment.push(environmentMarker);
		}
	},
	//환경 Marker 지도에 표시
	showEnvironmentOverlays : function(){
		if (this.guMarkerEnvironment) {
			for (i in this.guMarkerEnvironment) {
				this.guMarkerEnvironment[i].setMap(this.map);
			}
		}
	},
	//환경 Marker 지도 숨김
	clearEnvironmentOverlays : function() {
		if (this.guMarkerEnvironment) {
			for (i in this.guMarkerEnvironment) {
				this.guMarkerEnvironment[i].setMap(null);
			}
		}
	},
	//환경 Marker 삭제 및 리스트 삭제
	deleteEnvironmentOverlays : function() {
		if (this.guMarkerEnvironment) {
			for (i in this.guMarkerEnvironment) {
				this.guMarkerEnvironment[i].setMap(null);
			}
			this.guMarkerEnvironment.length = 0;
		}
	},
	//범죄 지도 표시 및 리스트 등록
	addCrimeMarker : function(obj, zoom) {
		var latitude, longitude;
		//zoom 레벨에 따른 위치 재조정
		var index = zoom - 15;
		//zoom 레벨에 따른 위치 재조정
		latitude = Number(obj.latitude)-this.zoomobj[index].crimeLat;
		longitude = Number(obj.longitude)+this.zoomobj[index].crimeLng;
		
		var extention = '.png';
		var crimeImgPath = '';
		
		if(obj.range_crime_id != 0){
			if(obj.range_crime_rating == '1'){
				crimeImgPath = this.imagePath + this.imageCrimeName +'01' +this.extention;
			}
			else if(obj.range_crime_rating == '2'){
				crimeImgPath = this.imagePath + this.imageCrimeName +'02' +this.extention;
			}
			else if(obj.range_crime_rating == '3'){
				crimeImgPath = this.imagePath + this.imageCrimeName +'03' +this.extention;
			}
			else if(obj.range_crime_rating == '4'){
				crimeImgPath = this.imagePath + this.imageCrimeName +'04' +this.extention;
			}
			else if(obj.range_crime_rating == '5'){
				crimeImgPath = this.imagePath + this.imageCrimeName +'05' +this.extention;
			}
			var latlng = new google.maps.LatLng(latitude, longitude);
			var crimeMarker = new google.maps.Marker({
				position : latlng,
				icon : crimeImgPath,
				map : this.map,
				zIndex:1
			});
			
			infoMap.addEvent(crimeMarker, obj.range_crime_id, obj.range_crime_category);
			this.guMarkerCrime.push(crimeMarker);
		}
	},
	//범죄 Marker 지도에 표시
	showCrimeOverlays : function(){
		if (this.guMarkerCrime) {
			for (i in this.guMarkerCrime) {
				this.guMarkerCrime[i].setMap(this.map);
			}
		}
	},
	//범죄 Marker 지도 숨김
	clearCrimeOverlays : function() {
		if (this.guMarkerCrime) {
			for (i in this.guMarkerCrime) {
				this.guMarkerCrime[i].setMap(null);
			}
		}
	},
	//범죄 Marker 지도 삭제 및 리스트 삭제
	deleteCrimeOverlays : function() {
		if (this.guMarkerCrime) {
			for (i in this.guMarkerCrime) {
				this.guMarkerCrime[i].setMap(null);
			}
			this.guMarkerCrime.length = 0;
		}
	}
}

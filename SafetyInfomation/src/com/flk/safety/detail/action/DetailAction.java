package com.flk.safety.detail.action;

import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.flk.safety.common.BaseAction;
import com.flk.safety.common.CommUtils;
import com.flk.safety.common.Constant;
import com.flk.safety.detail.service.DetailService;
import com.flk.safety.detail.vo.Calamity_DisasterVO;
import com.flk.safety.detail.vo.Calamity_LandslideVO;
import com.flk.safety.detail.vo.Food_CertificationVO;
import com.flk.safety.detail.vo.Food_Origin_ViolationVO;
import com.flk.safety.detail.vo.Food_Sanitary_ViolationVO;
import com.flk.safety.detail.vo.Range_CrimeVO;
import com.flk.safety.detail.vo.Range_EnvironmentVO;
import com.flk.safety.detail.vo.Range_TrafficVO;
import com.flk.safety.detail.vo.Range_WeatherVO;
import com.flk.safety.detail.vo.Sex_CrimeVO;
import com.flk.safety.detail.vo.Subway_CrimeVO;
import com.flk.safety.detail.vo.TrafficVO;

public class DetailAction extends BaseAction{
	
	String json_data;

	public String detail(){		
		String category = CommUtils.checkNull(getParameter("category"), "");
		String id = CommUtils.checkNull(getParameter("id"), "");
		
		m_traceLogger.info("DetailAction detail() start | Parameter( category : "+category+" id : "+id+" )");
		
		if(category.equals("") || id.equals("")){
			m_traceLogger.error("category or id parameter is not");
			return ERROR;
		}
		
		JSONObject jsonObject = new JSONObject();
		try {
			if(category.equals(Constant.TRAFFIC_JAYJOLKING)){
				jsonObject.put("data", DetailService.getInstance().getTraffic_Jayjolking(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.TRAFFIC_CHILDREN)){
				jsonObject.put("data", DetailService.getInstance().getTraffic_Children(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.SUBWAY_CRIME)){
				jsonObject.put("data", DetailService.getInstance().getSubway_Crime(Integer.parseInt(id)));
				jsonObject.put("list", DetailService.getInstance().getSubway_CrimeList(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.SEX_CRIME)){
				jsonObject.put("data", DetailService.getInstance().getSex_Crime(Integer.parseInt(id)));
				jsonObject.put("list", DetailService.getInstance().getSex_CrimeList(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.FOOD_CERTIFICATION)){
				jsonObject.put("data", DetailService.getInstance().getFood_Certification(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.FOOD_SANITARY_VIOLATION)){
				jsonObject.put("data", DetailService.getInstance().getFood_Sanitary_Violation(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.FOOD_ORIGIN_VIOLATION)){
				jsonObject.put("data", DetailService.getInstance().getFood_Origin_Violation(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.CALAMITY_LANDSLIDE)){
				jsonObject.put("data", DetailService.getInstance().getCalamity_Landslide(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.RANGE_TRAFFIC)){
				jsonObject.put("data", DetailService.getInstance().getRange_Traffic(Integer.parseInt(id)));
				jsonObject.put("list", DetailService.getInstance().getRange_TrafficList());
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.RANGE_CRIME)){
				jsonObject.put("data", DetailService.getInstance().getRange_Crime(Integer.parseInt(id)));
				jsonObject.put("list", DetailService.getInstance().getRange_CrimeList(Integer.parseInt(id)));
				json_data = jsonObject.toString();
				System.out.println(json_data);
			}else if(category.equals(Constant.RANGE_ENVIRONMENT)){
				jsonObject.put("data", DetailService.getInstance().getRange_Environment(Integer.parseInt(id)));
				jsonObject.put("data1", DetailService.getInstance().getRange_Weather(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}else if(category.equals(Constant.CALAMITY_DISASTER)){
				jsonObject.put("data", DetailService.getInstance().getCalamity_Disaster(Integer.parseInt(id)));
				json_data = jsonObject.toString();
			}
		}catch(Exception e){
			m_traceLogger.error("DetailAction detail Error..");
			return ERROR;
		}
		
		m_traceLogger.debug("detail json data : " + json_data.toString());
		m_traceLogger.info("DetailAction detail() End..");
		return SUCCESS;
	}
	
	public String getJson_data() {
		return json_data;
	}

	public void setJson_data(String json_data) {
		this.json_data = json_data;
	}
}

/*
 * com.rnx.datastore.action.MapModeAction
 *
 * Created on 2012. 10. 10.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.map.action;



import net.sf.json.JSONObject;

import com.flk.safety.common.BaseAction;
import com.flk.safety.common.CommUtils;
import com.flk.safety.map.service.MapModeService;


/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 10.
 * @version	1.00 2012. 10. 10.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 10.			최초.
 */

public class MapModeAction extends BaseAction
{
	private static final String POSITION_ERROR = "positionErr";
	
	//JSONObject poiData;
	//JSONObject guData;
	
	/**
	 * Map Mode Action
	 * @return
	 */
	public String mapMode(){
		m_traceLogger.info("MapModeAction mapMode() call");
		//위도 경도 체크
		double latitude = Double.parseDouble(CommUtils.checkNull(getParameter("latitude"), "0"));
		double longitude = Double.parseDouble(CommUtils.checkNull(getParameter("longitude"), "0"));
		
		if(latitude == 0 && longitude == 0){
			return POSITION_ERROR;
		}
		//POI 데이터 가져오기
		//poiData = MapModeService.getInstance().selectPoiMapData();
		//guData = MapModeService.getInstance().selectGuMapData();
		
		return SUCCESS;
	}
}

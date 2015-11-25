/*
 * com.flk.safety.search.action.SearchAction
 *
 * Created on 2012. 10. 30.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.search.action;

import java.util.List;

import org.json.JSONArray;

import com.flk.safety.common.BaseAction;
import com.flk.safety.common.GoogleGeoCodeUtil;
import com.flk.safety.search.vo.SearchVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 30.
 * @version	1.00 2012. 10. 30.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 30.			최초.
 */

public class SearchAction extends BaseAction
{
	public String searchText;
	public JSONArray searchList;
	public int searchListCount;
	
	public String search(){
		m_traceLogger.info("SearchAction search() call");
		if(m_traceLogger.isDebugEnabled()){
			m_traceLogger.debug("search text : " + searchText);
		}
		GoogleGeoCodeUtil geocode = new GoogleGeoCodeUtil();
		if(searchText != null){
			String data = geocode.translate(searchText);
			List<SearchVO> list = geocode.getSearchList(data);
			searchList =  new JSONArray(list);
			searchListCount = list.size();
		}
		if(m_traceLogger.isDebugEnabled()){
			m_traceLogger.debug("result searchList : " + searchList);
			m_traceLogger.debug("result searchListCount : " + searchListCount);
		}
		return SUCCESS;
	}
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public JSONArray getSearchList() {
		return searchList;
	}
	public void setSearchList(JSONArray searchList) {
		this.searchList = searchList;
	}
	public int getSearchListCount() {
		return searchListCount;
	}
	public void setSearchListCount(int searchListCount) {
		this.searchListCount = searchListCount;
	}
}

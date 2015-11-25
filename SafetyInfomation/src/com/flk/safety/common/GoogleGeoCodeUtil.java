/*
 * com.damon.util.GoogleAddr2Coord
 *
 * Created on 2012. 10. 11.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.flk.safety.search.vo.SearchVO;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 10. 11.
 * @version	1.00 2012. 10. 11.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 10. 11.			최초.
 */

public class GoogleGeoCodeUtil
{
	private static final String TAG = "GoogleAddr2Coord";
	private static Logger m_traceLogger = Logger.getLogger("TRACE");
	
	
	public String translate(String address) {		
		if (address == null)
			return null;
		String jsonData = request(address);
		//List<SearchVO> locationArray = getLocationObject(jsonData);
		return jsonData;
	}

	private String request(String address)   {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = null;
		try {
			String url = createPostUrl(address);
			httpPost = new HttpPost(url);
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content, "UTF-8"));

				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}				
			} else {
				m_traceLogger.error("request() 조회 실패!!");
			}
		} catch (ClientProtocolException e) {
			m_traceLogger.error("ClientProtocolException : " + e);
		} catch (IOException e) {
			m_traceLogger.error("IOException : " + e);
		}	
		return builder.toString();
	}

	private String createPostUrl(String address) throws UnsupportedEncodingException {
		return String.format("%s?address=%s&sensor=true&language=%s",
				Constant.GOOGLE_GEOCODE_URL, 
				URLEncoder.encode(address, HTTP.UTF_8),
				"ko");
	}

	private SearchVO searchResultParse(JSONObject obj){
		SearchVO result = null;
		
		try{
			result = new SearchVO();
			
			result.setAddress(obj.get("formatted_address").toString());
			result.setLatitude(obj.getJSONObject("geometry").getJSONObject("location").get("lat").toString());
			result.setLongitude(obj.getJSONObject("geometry").getJSONObject("location").get("lng").toString());
		}
		catch(JSONException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<SearchVO> getSearchList(String jsonData) {
		JSONArray arr = null;
		List<SearchVO> result = new ArrayList<SearchVO>();
		
		try {
			JSONObject object = new JSONObject(jsonData);
			if (object.getString("status").equals("OK")) {
				arr = object.getJSONArray("results");
				if(arr != null && arr.length() > 0){
					for(int i = 0; i < arr.length();i++){
						result.add(searchResultParse((JSONObject)arr.get(i)));
					}
				}
			} 
		} catch (JSONException e) {
			m_traceLogger.error("JSONException : " + e);
		}
		return result;
	}	
}

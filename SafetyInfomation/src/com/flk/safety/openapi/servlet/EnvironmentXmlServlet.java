/*
 * com.flk.ngc.openapi.EnviXmlServlet
 *
 * Created on 2012. 11. 15.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.openapi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.flk.safety.detail.vo.Range_EnvironmentVO;
import com.flk.safety.openapi.service.OpenApiService;

/**
 * 
 * 클래스에 대한 설명을 여기에 쓴다.
 * 
 * Create Date 2012. 11. 15.
 * @version	1.00 2012. 11. 15.
 * @since   1.00
 * @see
 * @author	Keun-su Lim(akswosn@rionnex.com)
 * Revision History
 * who			when        	what
 * Keun-su		2012. 11. 15.			최초.
 */

public class EnvironmentXmlServlet
{
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void excuteProc(HttpServletRequest req, HttpServletResponse resp){
		m_traceLogger.info("call EnvironmentXmlServlet excuteProc()");
		PrintWriter out = null;
		resp.setContentType("text/xml; charset=utf-8");
		try{
			out = resp.getWriter();
		}
		catch(IOException e){
			m_traceLogger.error("getWriter Error : " + e);
		}
		out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<RangeEnvironmentList>");
		
		List<Range_EnvironmentVO> list = OpenApiService.getInstance().selectEnvironment();
		
		for(Range_EnvironmentVO temp : list){
			out.println("<environment>");
			out.println("<category>&lt;![CDATA[" +temp.getCategory_name()+ "]]&gt;</category>" );
			out.println("<name>&lt;![CDATA[" +temp.getName()+ "]]&gt;</name>" );
			out.println("<measurement_date>&lt;![CDATA[" +temp.getMeasurement_date()+ "]]&gt;</measurement_date>" );
			out.println("<atmosphere>&lt;![CDATA[" +temp.getAtmosphere()+ "]]&gt;</atmosphere>" );
			out.println("<atmosphere_rating>&lt;![CDATA[" +temp.getAtmosphere_rating()+ "]]&gt;</atmosphere_rating>" );
			out.println("<substance>&lt;![CDATA[" +temp.getSubstance()+ "]]&gt;</substance>" );
			out.println("<nitrogen_dioxide>&lt;![CDATA[" +temp.getNitrogen_dioxide()+ "]]&gt;</nitrogen_dioxide>" );
			out.println("<ozone>&lt;![CDATA["+temp.getOzone()+ "]]&gt;</ozone>" );
			out.println("<carbon_monoxide>&lt;![CDATA[" +temp.getCarbon_monoxide()+ "]]&gt;</carbon_monoxide>" );
			out.println("<sourcesulfur_dioxide>&lt;![CDATA[" +temp.getSourcesulfur_dioxide()+ "]]&gt;</sourcesulfur_dioxide>" );
			out.println("<dust>&lt;![CDATA[" +temp.getDust()+ "]]&gt;</dust>" );
			out.println("<source>&lt;![CDATA[" +temp.getSource()+ "]]&gt;</source>" );
			out.println("</environment>");
		}
		out.println("</RangeEnvironmentList>");
	}
}

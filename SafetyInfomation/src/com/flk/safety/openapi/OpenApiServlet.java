/*
 * com.flk.safety.openapi.OpenApiServlet
 *
 * Created on 2012. 11. 15.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.openapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.flk.safety.openapi.servlet.EnvironmentXmlServlet;


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

public class OpenApiServlet extends HttpServlet
{
	public static final String ENVIRONMENT_XML = "environmentXML.api";	//자치구별 대기환경정보 xml api
	private static Logger		m_traceLogger	= Logger.getLogger("TRACE");
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		m_traceLogger.info("call OpenApiServlet doPost()");
		String uri =  req.getRequestURI().substring(req.getRequestURI().lastIndexOf('/') + 1, req.getRequestURI().length());
		PrintWriter out = null;
		if(ENVIRONMENT_XML.equals(uri)){
			new EnvironmentXmlServlet().excuteProc(req, resp);
		}
		else {
			resp.setContentType("text/plain; charset=euc-kr");
			out = resp.getWriter();
			
			out.println("요청하신 api 찾을수 없습니다.");
		}
	}
	
}

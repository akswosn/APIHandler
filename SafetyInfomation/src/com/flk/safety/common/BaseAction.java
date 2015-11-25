/*
 * com.rnx.datastore.common.DataStoreAction
 *
 * Created on 2012. 10. 10.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

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

public class BaseAction  extends ActionSupport
{
	protected static Logger	m_traceLogger	= Logger.getLogger("TRACE");
	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	protected String getParameter(String parameterName) {
		return ServletActionContext.getRequest().getParameter(parameterName);
	}
}

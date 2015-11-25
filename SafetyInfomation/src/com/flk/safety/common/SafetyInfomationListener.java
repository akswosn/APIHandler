/*
 * com.rnx.datastore.common.DataStoreListener
 *
 * Created on 2012. 10. 10.
 * 
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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

public class SafetyInfomationListener implements ServletContextListener
{
	private static String 	CONTEXT_PATH; 
	
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("Listener Start!!!");
		
		CONTEXT_PATH = contextEvent.getServletContext().getContextPath();
		 
		if(CONTEXT_PATH == null) CONTEXT_PATH = "";
		
		if(CONTEXT_PATH.lastIndexOf("/") != CONTEXT_PATH.length() - 1){
			CONTEXT_PATH = CONTEXT_PATH + "/";
		}
		
		System.out.println("=============================");
		System.out.println(SafetyInfomationListener.class + ".contextInitialized() called...");
		System.out.println(" CONTEXT_PATH : " + CONTEXT_PATH);
		System.out.println("=============================");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	public static String getContextPath(){
		return CONTEXT_PATH;
	}
}

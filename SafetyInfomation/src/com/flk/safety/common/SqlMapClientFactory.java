/*
 * com.flk.ngc.common.SqlMapClientFactory
 *
 * Created on 2011. 5. 21.
 *
 * Copyright (c) 2010 RionNex Co., Ltd. All Rights Reserved.
 */
package com.flk.safety.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.RequestScope;

/**
 *
 * iBatis SqlMapClient ??? Factory Class
 * Apply Singleton Pattern.
 *
 * Create Date 2011. 5. 21.
 * @version	1.00 2011. 5. 21.
 * @since   1.00
 * @see
 * @author	weonman lee(wmlee@rionnex.com)
 * Revision History
 * who			when        	what
 * weonman		2011. 5. 21.	최초작성
 */

public abstract class SqlMapClientFactory
{

	/* */
	private static volatile SqlMapClient m_sqlMapClient;

	/* */
	private static final String	SQL_MAP_CONFIG_RESOURCE = "ibatis_config/sqlmap-config.xml";

	private Logger m_traceLogger =  Logger.getLogger("TRACE");

	/**
	 *
	 * Constructor
	 *
	 */
	public SqlMapClientFactory(){
	}

	/**
	 * iBatis SqlMapClient
	 *
	 * @return SqlMapClient
	 */
	public SqlMapClient getSqlMapClient(){
		if(m_sqlMapClient == null){
			synchronized(SqlMapClientFactory.class){
				if(m_sqlMapClient == null){
					try{
						Reader reader = Resources.getResourceAsReader(SQL_MAP_CONFIG_RESOURCE);
						m_sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
						
						m_traceLogger.info("Create SqlMapClient Object Success !!!");
						reader.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
		
		return m_sqlMapClient;
	}
	

	protected String getQuery(String statemetId, Object parameter, SqlMapClient sqlMapClient){
		String	query	= null;
		Sql		sql		= null;
		
		try{
			SqlMapClientImpl	sqlMapClientImpl = (SqlMapClientImpl)sqlMapClient;
			MappedStatement		mappedStatement	 = sqlMapClientImpl.getMappedStatement(statemetId);
	
			if(mappedStatement != null){
				RequestScope request = new RequestScope();
				mappedStatement.initRequest(request);
	
				sql = mappedStatement.getSql();
				if(sql != null){
					query = sql.getSql(request, parameter);
				}
			}
		}catch(Exception e){
			m_traceLogger.error(e.getMessage());
		}

		return query;
	}

	protected void printQuery(String statemetId, Object parameter, SqlMapClient sqlMapClient){
		String query = getQuery(statemetId, parameter, sqlMapClient);
		
		m_traceLogger.error("-----------------------------------------------------------------");
		m_traceLogger.error("Query : " + query);
		
		if(parameter != null){
			m_traceLogger.error("Parameters : " + parameter.toString());
		}
		
		m_traceLogger.error("-----------------------------------------------------------------");
	}
	
	protected void printQuery(String statemetId, SqlMapClient sqlMapClient){
		String query = getQuery(statemetId, null, sqlMapClient);

		m_traceLogger.error("-----------------------------------------------------------------");
		m_traceLogger.error("Query : " + query);
		m_traceLogger.error("-----------------------------------------------------------------");
	}
	
	protected void printQuery(String statemetId, Object parameter){
		printQuery(statemetId, parameter, m_sqlMapClient);
	}
	
	protected void printQuery(String statemetId){
		printQuery(statemetId, m_sqlMapClient);
	}
}

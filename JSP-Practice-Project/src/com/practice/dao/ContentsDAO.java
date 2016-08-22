package com.practice.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ContentsDAO {
	Context context;
	DataSource dataSource;

	public ContentsDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
}

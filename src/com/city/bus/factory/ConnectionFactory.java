package com.city.bus.factory;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Connection cn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/bus");
			cn =ds.getConnection();
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
		
	}
}

package com.sistemi.informativi.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionSingleton {
	
	
	private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		
		
		if (connection==null) {
			
			
			 try {
				Class.forName(DbParameters.dbDriver.getValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 connection  = DriverManager.getConnection(
					DbParameters.dbUrl.getValue(),
					DbParameters.dbUser.getValue(),
					DbParameters.dbPass.getValue());
		}
		
	return connection;
	
	}
	
	
	private ConnectionSingleton() {
		
	}

}

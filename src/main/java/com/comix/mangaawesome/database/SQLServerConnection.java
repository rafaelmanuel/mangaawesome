package com.comix.mangaawesome.database;

import java.sql.Connection;

public interface SQLServerConnection {
	
	public Connection getConnection();
	public String getConnectionURL();
	public String getConnectionStatus();
	
}

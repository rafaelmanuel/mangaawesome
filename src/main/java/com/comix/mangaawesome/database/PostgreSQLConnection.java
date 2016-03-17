package com.comix.mangaawesome.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection extends DBUserLibrary implements SQLServerConnection{

	private Connection conn;
	private String status;
	
	public PostgreSQLConnection(String URL, String catalog, String username, String password, String className) {
		super(URL, catalog, username, password, className);
	}

	public Connection getConnection() {
		try{
			Class.forName(getClassName());
			conn = DriverManager.getConnection(getConnectionURL());
			status = "Success";
			return conn;
			
		}catch(SQLException e){
			
			status = "Error";
			e.printStackTrace();
			return null;
			
		} catch (ClassNotFoundException e) {
			
			status = "Error";
			e.printStackTrace();
			return null;
		}
	
	}

	public String getConnectionURL() {
		return String
				.format
				(
					"%s%s?username=%s&password=%s",
					getURL() ,
					getCatalog() ,
					getUsername() ,
					getPassword()
				);
	}
	

	public String getConnectionStatus() {
		return status;
	}

}

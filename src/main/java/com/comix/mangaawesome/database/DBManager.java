package com.comix.mangaawesome.database;

import java.sql.Connection;

public class DBManager {

	protected Connection conn;
	private SQLServerConnection serverConnection;

	public DBManager(SQLServerConnection serverConnection){
		this.serverConnection = serverConnection;
	}

	public void openConnection(){
		try{

			System.out.println("Connection starting ...");

			if(serverConnection != null){
				if(conn == null && serverConnection.getConnection() != null){
					conn = serverConnection.getConnection();
					System.out.println("Connection success.");
				}else{
					System.out.println("Can not open the connection.");
				}

			}else{

				System.out.println("Can not open the connection.");

			}

			System.out.println("URL : " + serverConnection.getConnectionURL());
			System.out.println("Status : " + serverConnection.getConnectionStatus());

		}catch(NullPointerException e ){
			e.printStackTrace();
			System.out.println("URL : " + serverConnection.getConnectionURL());
			System.out.println("Status : " + serverConnection.getConnectionStatus());
		}
	}
	
	public void closeConnection(){
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return conn;
	}
}

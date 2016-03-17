package com.comix.mangaawesome.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comix.mangaawesome.model.User;

public class LoginDBManager{

	private Connection conn;
	
	public LoginDBManager(Connection conn) {
		this.conn = conn;
	}
	
	public User getUserByEmailAndPassword(String email , String password){
		try{
			String sql = "SELECT * FROM tbluser WHERE email = ? AND password = ? LIMIT 1";
			User user = null;
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				user = new User
					   (
							 rs.getString("id"),
							 rs.getString("first_name"),
							 rs.getString("last_name"),
							 rs.getString("email"),
							 rs.getString("password"),
							 rs.getString("access_type"),
							 rs.getBoolean("is_activated")
					   );
			}
			
			pst.close();
			rs.close();
			return user;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
			
		}
	}
	//INSERT INTO tbluser(id,first_name,last_name,email,password,access_type,is_activated) VALUES('CA-561-01-2016','Rafael','Manuel','rafaelmanuel00gmail.com','rafael00','USER',true);

}

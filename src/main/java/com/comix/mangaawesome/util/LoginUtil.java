package com.comix.mangaawesome.util;

import com.comix.mangaawesome.model.User;

public class LoginUtil {
	
	private User user;
	private boolean access;
	
	public LoginUtil(User user) {
		this.user = user;
		try{
			
			if(user != null)
				access = true;
			else
				access = false;
			
		}catch(Exception e){
			e.printStackTrace();
			access = false;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}
	
	
	

}

package com.comix.mangaawesome.helper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.comix.mangaawesome.database.DBManager;
import com.comix.mangaawesome.database.PostgreSQLConnection;
import com.comix.mangaawesome.database.SQLServerConnection;

public class SetupDBManager implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent event)  { 
        try{
        	ServletContext context = (ServletContext) event.getServletContext();
        	String url = context.getInitParameter("url");
        	String catalog = context.getInitParameter("catalog");
        	String username = context.getInitParameter("username");
        	String password = context.getInitParameter("password");
        	String className = context.getInitParameter("class");
        	
        	SQLServerConnection ssc = new PostgreSQLConnection(url, catalog, username, password, className);
        	DBManager manager = new DBManager(ssc);
        	manager.openConnection();
        	context.setAttribute("dbmanager", manager);

        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	
}

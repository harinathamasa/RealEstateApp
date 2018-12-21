package com.csuohio.util;

import java.sql.Connection;
import java.sql.DriverManager;


//Oracle connection
public class DBConnection {

	private static String url="jdbc:oracle:thin:@myoracledb.ctxwkpogce28.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String user="datamining";
	private static String password="*******";
	
	private static Connection dbconn=null;
	
	
	private DBConnection(){
		
	}
	
	public static Connection getConnection(){
		if(dbconn!=null){
			return dbconn;
		}else{
			try{
			      Class.forName("oracle.jdbc.driver.OracleDriver");  
				  dbconn=DriverManager.getConnection(url,user,password);		
			}catch(Exception e){
				System.out.println(e);
			}
			  return dbconn;
		}
	}
	

}


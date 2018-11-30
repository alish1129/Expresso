package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager; 
/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {   
    	 	
    	String jdbcUrl ="jdbc:mysql://localhost:3306/stock-management-system?useSSL=false";
    	String user  = "stock";
    	String pass ="stock-management";
    	
    	try {
    			System.out.println("connecting to database : "+ jdbcUrl);
    			
    			Connection myConn =
    						DriverManager.getConnection(jdbcUrl,user,pass);
    			System.out.println("Connection successful");
    	}catch(Exception exc) {
    		exc.printStackTrace();
    	}
    }
}

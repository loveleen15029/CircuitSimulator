package com.winter.project.java;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Connections {
	static String A;
	public static String fileName2=null;
	public static void connect()
	{
//		boolean B=Boolean.valueOf(A);
		fileName2=XMLParser.fileName1.substring(50,XMLParser.fileName1.length()-4);
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 			  
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");  			  
			PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("create table IF NOT EXISTS "+fileName2+"(output varchar(255),input1 varchar(255),input2 varchar(255),type varchar(255),level INT,input1_type varchar(255),input2_type varchar(255))");
		    stmt1.executeUpdate();	
		    con.close();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}

}

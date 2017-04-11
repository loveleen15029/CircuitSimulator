package com.winter.project.java;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.winter.project.StoredCircuitEvaluator;
public class CircuitDrawer {
	public ArrayList<String> level=new ArrayList<String>();
	public ArrayList<String> type=new ArrayList<String>();
	Connection con;

	public ArrayList<String> getLevel() throws ClassNotFoundException { 			  

		try {
			level.clear();
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
			PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("select * from "+StoredCircuitEvaluator.circuitName+"");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				level.add(rs.getString(5));				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  		
		return level;	    
	}	
	public ArrayList<String> getType() throws ClassNotFoundException { 			  

		try {
			type.clear();
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
			PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("select * from "+StoredCircuitEvaluator.circuitName+"");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				type.add(rs.getString(4));				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  		
		return type;	    
	}	


}


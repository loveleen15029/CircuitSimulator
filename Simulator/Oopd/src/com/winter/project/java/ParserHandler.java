package com.winter.project.java;
import java.sql.DriverManager;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class ParserHandler extends DefaultHandler {
	public boolean a=true;
	public static ArrayList<String> inputNames=new ArrayList<>();
	public static ArrayList<String> outputNames=new ArrayList<>();
	public static String gateDB=null;
	public static String prevInput=null;
	public static String typeDB=null;
	public static String levelDB=null;
	public static String levelODB=null;
	public static String nameODB=null;
	public static boolean outputDB=false;
	public static String nameDB=null;
	public static String inputType=null;
	public static int count=0;
	Connection con=null;
	PreparedStatement prpt=null;
	   @Override
	   public void startElement(String url, 
	   String localName, String elementName, Attributes attributeName)
	      throws SAXException {		   
	      if (elementName.equalsIgnoreCase("input")) {
	    	  String type=null;
	    	  String name=null;
//	    	  String level=null; 
		     if(!((attributeName.getValue("type")==null)))
		     { 
		      count++;
		      type = attributeName.getValue("type");	         
	          name = attributeName.getValue("name");
	          if(count==1){
	        	  prevInput=name;
	        	  inputType=type;}
//	          level = attributeName.getValue("level");
	         }
		     else
		     {
		     count++;
	         name = attributeName.getValue("name");
	         inputNames.add(name);
	         if(count==1){
	        	  prevInput=name;}
//	         level = attributeName.getValue("level");	         
	         }
		     if(count==1&&typeDB.equalsIgnoreCase("not"))
	         {		    	 
	           try 
	  		   {
	        	   Class.forName("com.mysql.jdbc.Driver"); 			  
	   			   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
	   			   prpt=(PreparedStatement) con.prepareStatement("INSERT INTO "+Connections.fileName2+"(output,input1,input2,type,level,input1_type,input2_type) VALUES"+ "(?,?,?,?,?,?,?)");
	        	   prpt.setString(1, nameDB);
	        	   prpt.setString(2, name);
	        	   prpt.setString(3, null);
	        	   prpt.setString(4, typeDB);
	        	   prpt.setInt(5, Integer.parseInt(levelDB));
	        	   prpt.setString(6, inputType);
	        	   prpt.setString(7, null);
	        	   prpt.executeUpdate();
	        	   con.close();
	  		   }
	  		   catch(Exception e)
	  		   {
	  			     			   
	  		   }	
	             inputType=null;
	             type=null;
	             nameDB=null;
	             typeDB="xyz";
	        	 count=0;
	         }
	         else if(count==2)
	         {	        	 
	           try 
	  		   {
	        	   Class.forName("com.mysql.jdbc.Driver"); 			  
	   			   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
	   			   prpt=(PreparedStatement) con.prepareStatement("INSERT INTO "+Connections.fileName2+"(output,input1,input2,type,level,input1_type,input2_type) VALUES"+ "(?,?,?,?,?,?,?)");
	        	   prpt.setString(1, nameDB);
	        	   prpt.setString(2, prevInput);
	        	   prpt.setString(3, name);
	        	   prpt.setString(4, typeDB);
	        	   prpt.setInt(5, Integer.parseInt(levelDB));
	        	   prpt.setString(6, inputType);
	        	   prpt.setString(7, type);
	        	   prpt.executeUpdate();	        	   
	        	   con.close();
	  		   }
	  		   catch(Exception e)
	  		   {
	  			   
	  		   }
	             inputType=null;
	             type=null;
	             typeDB="xyz";  
	             nameDB=null;
	        	 count=0;	        	 
	         }
	         else if(outputDB)
	         {
	        	 count=0;
	        	 try 
		  		   {
		        	   Class.forName("com.mysql.jdbc.Driver"); 			  
		   			   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
		   			   prpt=(PreparedStatement) con.prepareStatement("INSERT INTO "+Connections.fileName2+"(output,input1,input2,type,level,input1_type,input2_type) VALUES"+ "(?,?,?,?,?,?,?)");
		        	   prpt.setString(1, nameODB);
		        	   prpt.setString(2, name);
		        	   prpt.setString(3, null);
		        	   prpt.setString(4, null);
		        	   prpt.setInt(5, Integer.parseInt(levelODB));
		        	   prpt.setString(6, inputType);
		        	   prpt.setString(7, null);
		        	   prpt.executeUpdate();
		        	   con.close();
		  		   }
		  		   catch(Exception e)
		  		   {
		  			   
		  		   }
	        	 inputType=null;
	             type=null;
	        	 outputDB=false;
	        	 gateDB=null;
	        	 prevInput=null;
	        	 typeDB="xyz";
	        	 levelDB=null;
	        	 levelODB=null;
	        	 nameODB=null;
	        	 nameDB=null;
	        	 count=0;	        	 
	         }
	      } 
	      else if (elementName.equalsIgnoreCase("gate")) {
	    	     String type = attributeName.getValue("type");	
	    	     typeDB=type;
		         String name = attributeName.getValue("name");	         
		         nameDB=name;
		         String level = attributeName.getValue("level");
		         levelDB=level;	      } 
	      else if (elementName.equalsIgnoreCase("output")) {
	    	     outputDB=elementName.equalsIgnoreCase("output");
		         String name = attributeName.getValue("name");	
		         nameODB=name;
		         outputNames.add(name);
		         outputNames.add(name);
		         String level = attributeName.getValue("level");
		         levelODB=level;	  
	      }
	   }

	   @Override
	   public void endElement(String uri, 
	   String localName, String elementName) throws SAXException {
	      if (elementName.equalsIgnoreCase("input")) {
	      }
	      else if (elementName.equalsIgnoreCase("gate")) {
		      }
	      else if (elementName.equalsIgnoreCase("output")) {
		      }
	   }   

}

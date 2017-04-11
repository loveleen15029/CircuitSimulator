package com.winter.project;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.winter.project.java.Circuit;
import com.winter.project.java.Connections;
import com.winter.project.java.Gates;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(description = "evaluating table by using dynamic programming", urlPatterns = { "/CircuitEvaluator" })
public class CircuitEvaluator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Boolean> outputProg=new ArrayList<Boolean>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String,Boolean> instanceTable=new HashMap<String,Boolean>();
		Circuit circuit=new Circuit();
		Gates gate=new Gates();
		int i=0;
		ArrayList<String> inputList=circuit.inputArray();
		outputProg.clear();
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 			  
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");  			  
			PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("select * from "+Connections.fileName2+"");
		    ResultSet rs=stmt1.executeQuery();
		    while (rs.next()) {
		    	boolean x=false;
	    		boolean y=false;
	    		boolean z=false;
	    		if(rs.getString(4)==null)
	    		{
	    			if(!(instanceTable.containsKey(rs.getString(2))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){x=false;}else{x=true;}
		    		    instanceTable.put(rs.getString(2), x);	    
		    		    i++;
		    		}
		    		else
		    			x=instanceTable.get(rs.getString(2));
	    			    outputProg.add(x);
	    			    instanceTable.put(rs.getString(2), x);	
	    			
	    		}
		    	if((!(rs.getString(2)==null))&&(rs.getString(6)==null)&&(rs.getString(3)==null))
		    	{	
		    		
		    		if(!(instanceTable.containsKey(rs.getString(2))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){x=false;}else{x=true;}
		    		    instanceTable.put(rs.getString(2), x);	    
		    		    i++;
		    		}
		    		else
		    			x=instanceTable.get(rs.getString(2));
		    		if((rs.getString(4).equalsIgnoreCase("not")))
		    		{		    			
		    		 if(!(instanceTable.containsKey(rs.getString(1)))){
		    			y= gate.notGate(x);
			    		instanceTable.put(rs.getString(1), y);
			    	    }
		    		 }
		    		else
		    		{
		    			if(!(instanceTable.containsKey(rs.getString(1)))){
			    			y= x;			  
				    		instanceTable.put(rs.getString(1), y);}
		    		}		    		
		    	}    
		    	if((!(rs.getString(2)==null))&&(rs.getString(3)==null)&&(rs.getString(7)==null)&&(!(rs.getString(6)==null))&&(!(rs.getString(4)==null)))
		    	{	
		    		if(!(instanceTable.containsKey(rs.getString(2))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){x=false;}else{x=true;}
		    		    instanceTable.put(rs.getString(2), x);	    
		    		    i++;
		    		}
		    		else
		    			x=instanceTable.get(rs.getString(2));		    		
		    		if((rs.getString(4).equalsIgnoreCase("not")))
		    		{		    			
		    		 if(!(instanceTable.containsKey(rs.getString(1)))){
		    			y= gate.notGate(x);
			    		instanceTable.put(rs.getString(1), y);}
		    		 }
		    		else if(rs.getString(4)==null)
		    		{
		    			if(!(instanceTable.containsKey(rs.getString(1)))){
			    			y= x;
			    			System.out.println(y+"");
				    		instanceTable.put(rs.getString(1), y);}
		    		}		    		
		    	} 		    
		       if((!(rs.getString(2)==null))&&!(rs.getString(3)==null)&&(rs.getString(6)==null)&&(rs.getString(7)==null))
		        {		    	    
		    		if(!(instanceTable.containsKey(rs.getString(2))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){x=false;}else{x=true;}
		    		    instanceTable.put(rs.getString(2), x);	  
		    		    i++;
		    		}
		    		else
		    			x=instanceTable.get(rs.getString(2));
		    		if(!(instanceTable.containsKey(rs.getString(3))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){y=false;}else{y=true;}
		    		    instanceTable.put(rs.getString(3), y);	  
		    		    i++;
		    		}
		    		else
		    			y=instanceTable.get(rs.getString(3));
		    		if(!(instanceTable.containsKey(rs.getString(1)))){
		    			if(rs.getString(4).equalsIgnoreCase("and"))
		    			z=gate.andGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("xor"))
			    			z=gate.exorGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("nand"))
			    			z=gate.nandGate(x, y);
		    			if(rs.getString(4).equalsIgnoreCase("nor"))
			    			z=gate.norGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("xnor"))
			    			z=gate.exnorGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("or"))
			    			z=gate.orGate(x,y);		    			
			    		instanceTable.put(rs.getString(1), z);
			    		}
		    		}
		       if((!(rs.getString(2)==null))&&!(rs.getString(3)==null)&&(!(rs.getString(6)==null)))
		        {		    	    
		    		if(!(instanceTable.containsKey(rs.getString(2))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){x=false;}else{x=true;}
		    		    instanceTable.put(rs.getString(2), x);	  
		    		    i++;
		    		}
		    		else
		    			x=instanceTable.get(rs.getString(2));		
		    		if(rs.getString(7)==null)
		    		{
		    		if(!(instanceTable.containsKey(rs.getString(3))))
		    		{
		    			String dummy=request.getParameter(inputList.get(i));
		    			if(dummy==null){y=false;}else{y=true;}
		    		    instanceTable.put(rs.getString(3), y);	  
		    		    i++;
		    		}
		    		else
		    			y=instanceTable.get(rs.getString(3));
		    		}
		    		else
		    			y=instanceTable.get(rs.getString(3));
		    		if(!(instanceTable.containsKey(rs.getString(1)))){
		    			if(rs.getString(4).equalsIgnoreCase("not"))
		    				z=gate.notGate(x);
		    			if(rs.getString(4).equalsIgnoreCase("and"))
		    			    z=gate.andGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("xor"))
			    			z=gate.exorGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("nand"))
			    			z=gate.nandGate(x, y);
		    			if(rs.getString(4).equalsIgnoreCase("nor"))
			    			z=gate.norGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("xnor"))
			    			z=gate.exnorGate(x,y);
		    			if(rs.getString(4).equalsIgnoreCase("or"))
			    			z=gate.orGate(x,y);		    			
			    		instanceTable.put(rs.getString(1), z);}
		    		}
		    }
		   
		    con.close();
			}
		catch(Exception e)
		{
			
		}
		response.sendRedirect("output.jsp");
	}
}

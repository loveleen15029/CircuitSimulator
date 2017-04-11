<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Winter Project</title>
<link rel="stylesheet" type="text/css" href="css/formcenter.css">           
</head>
<body>
<div class="center">
            <h3> Choose File to Upload</h3>
            <form action="Uploader" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>          
        </div>
     <div class="center">
            <h3> Use Previous Excecuted Circuit</h3>
        <form method="get" action="StoredCircuitEvaluator">
        <%
        try{%>
        <%  Class.forName("com.mysql.jdbc.Driver"); 			  
		   Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Circuit","root","password");
           DatabaseMetaData md = con.getMetaData();
           ResultSet rs = md.getTables(null, null, "%", null);%>
           <%while(rs.next()) {%>
           <input type="radio" value="<%=rs.getString(3)%>" name="prevXml" ><%=rs.getString(3)%><br/>  
           <%} %>
        
        <% }catch(Exception E){%>
        <%} %>
        <input type="submit" value="Submit">
        </form>
        </div>
</body>
</html>
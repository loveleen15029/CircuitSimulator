<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/Circuit"
user="root"  password="password"/>
<sql:query dataSource="${snapshot}" var="result">
SELECT TABLE_NAME 
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='Circuit' 
</sql:query>
<c:forEach var="row" items="${result.rows}">
<input type="radio" value="${row.TABLE_NAME}" name="prevXml" >${row.TABLE_NAME}<br/>
</c:forEach>
<c:catch var ="errormsg">
</c:catch>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.winter.project.java.Circuit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello</h1>
<%
  Circuit circuit=new Circuit();
  int inputLength=circuit.inputLength();
  ArrayList<String> inputArray=circuit.inputArray();
  ArrayList<String> outputArray=circuit.outputArray();  
%>
<% 
for(int i=0;i<inputLength;i++){
%>
<%=inputArray.get(i)%>:<input type="checkbox" name="<%=inputArray.get(i)%>" ><br/>
<% }%>
<%-- <c:forEach var="i" begin="0" end="length">
   Item <c:out value="${i}"/><p>
</c:forEach> --%>
</body>
</html>
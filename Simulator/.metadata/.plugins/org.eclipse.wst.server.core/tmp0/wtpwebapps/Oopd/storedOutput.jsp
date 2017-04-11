<%@page import="com.winter.project.java.PrevOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="input.jsp"></jsp:include>
<div class="center">
<%
  PrevOutput storedCircuit=new PrevOutput();
  ArrayList<String> inputArray1=storedCircuit.prevInputCircuit();   
%>
<form action="StoredCircuitEvaluator" method="post">
<% 
for(int i=0;i<inputArray1.size();i++){
%>
<%=inputArray1.get(i)%>:<input type="checkbox" name="<%=inputArray1.get(i)%>" ><br/>
<% }%>
<input type="submit" value="Submit">
</form>
<%
PrevOutput storedCircuitEval=new PrevOutput();
ArrayList<Boolean> outputArray1=storedCircuitEval.prevOutputCircuit(); 
%>
<%for(Boolean x:outputArray1){
%>
 <%=x %><br>
 <%}
 outputArray1.clear();%>
 </div>
</body>
</html>
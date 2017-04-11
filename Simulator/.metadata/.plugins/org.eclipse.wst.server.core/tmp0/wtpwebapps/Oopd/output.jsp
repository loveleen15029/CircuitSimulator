<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.winter.project.CircuitEvaluator"%>
<%@page import="com.winter.project.java.Output"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.winter.project.java.Circuit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Winter Project</title>
</head>
<body>
<jsp:include page="input.jsp"></jsp:include>
<div class="center">
<%
  Circuit circuit=new Circuit();
  int inputLength=circuit.inputLength();
  ArrayList<String> inputArray=circuit.inputArray();   
%>
<form action="CircuitEvaluator" method="post">
<% 
for(int i=0;i<inputLength;i++){
%>
<%=inputArray.get(i)%>:<input type="checkbox" name="<%=inputArray.get(i)%>" ><br/>
<% }%>
<input type="submit" value="submit">
</form>
<%-- <jsp:include page="/CircuitEvaluator" flush="true"></jsp:include> --%>
<%
Output circuitEval=new Output();
ArrayList<Boolean> outputArray=circuitEval.outputCircuit(); 
%>
<%for(Boolean x:outputArray){
%>
 <%=x %><br>
 <%}
 outputArray.clear();%>
 
<%-- <c:forEach var="i" begin="0" end="length">
   Item <c:out value="${i}"/><p>
</c:forEach> --%>
</div>
</body>
</html>
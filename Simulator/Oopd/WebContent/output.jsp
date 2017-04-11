<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.winter.project.CircuitEvaluator"%>
<%@page import="com.winter.project.java.Output"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.winter.project.java.*"%>
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
request.setAttribute("inputArray", inputArray);
int count=0;
int asciiValue=65;
%>
<form action="CircuitEvaluator" method="post">
<c:forEach items="${inputArray}" var="i">
${i}:<input type="checkbox" name="${i}" ><%count++; %><br/>
</c:forEach>
<input type="submit" value="submit">
</form>
<%
Output circuitEval=new Output();
ArrayList<Boolean> outputArray=circuitEval.outputCircuit(); 
request.setAttribute("outputArray", outputArray);
%>
<c:forEach items="${outputArray}" var="i">
${i}
</c:forEach>
<%outputArray.clear();%>
</div>

<%
CircuitDrawerUp ckt=new CircuitDrawerUp();
ArrayList<String> drawLevel1=ckt.getLevel();
ArrayList<String> drawType1=ckt.getType();
int k=200;
int y=650;
int r=650;
int prevLevel=(int)Integer.parseInt(drawLevel1.get(0));
boolean x=false;
String display=null;
%>
 
<%for(int s=0;s<count;s++){ %>
<div  style="position:absolute; left:<%=k%>px; top:<%=y+20%>px;">
<%=Character.toString((char)asciiValue) %><%asciiValue++; y=y+40;%></div>
<%} %>
<%y=r; k=k+100; %>

<%for(int i=0,j=0;i<drawLevel1.size();i++,j++){ %>
<% x=(drawType1.get(j)==null); %>
<%if(Integer.parseInt(drawLevel1.get(j))!=prevLevel) {%>
<% prevLevel=Integer.parseInt(drawLevel1.get(j)); k=k+120; y=r; %>
<%} %>
<div  style="position:absolute; left:<%=k%>px; top:<%=y%>px;">
<%if(x)
{
display=Character.toString((char)asciiValue);
out.println(display);
x=false; 
asciiValue++;
y=y+20;
}else {%>
<% if((drawType1.get(j)).equalsIgnoreCase("and")) {%>
<img alt="and gate" height="50px" width="50" src="and.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("or")) {%>
<img alt="" height="50px" width="50" src="Or.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("xor")) {%>
<img alt="" height="50px" width="50" src="exor.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("xnor")) {%>
<img alt="" height="50px" width="50" src="exnor.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("not")) {%>
<img alt="" height="50px" width="50" src="not.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("nand")) {%>
<img alt="" height="50px" width="50" src="Nand.png"><br><%asciiValue++;} %>
<% if((drawType1.get(j)).equalsIgnoreCase("nor")) {%>
<img alt="" height="50px" width="50" src="Nor.png"><br><%asciiValue++;} %>
<%} %>
</div>
<% y=y+80; %>
<%} %>
</body>
</html>
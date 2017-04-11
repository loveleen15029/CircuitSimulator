<%@page import="com.winter.project.java.PrevOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.winter.project.java.*"%>
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
PrevOutput storedCircuit=new PrevOutput();
ArrayList<String> inputArray1=storedCircuit.prevInputCircuit(); 
request.setAttribute("inputArray1", inputArray1);
int count=0;
int asciiValue=65;
%>
<form action="StoredCircuitEvaluator" method="post">
<c:forEach items="${inputArray1}" var="i">
${i}:<input type="checkbox" name="${i}" ><%count++; %><br/>
</c:forEach>
<input type="submit" value="Submit">
</form>

<%
PrevOutput storedCircuitEval=new PrevOutput();
ArrayList<Boolean> outputArray1=storedCircuitEval.prevOutputCircuit(); 
request.setAttribute("outputArray1", outputArray1);
%>
<c:forEach items="${outputArray1}" var="i">
${i}
</c:forEach>
<%outputArray1.clear();%>
</div>




 <%
CircuitDrawer ckt=new CircuitDrawer();
ArrayList<String> drawLevel=ckt.getLevel();
ArrayList<String> drawType=ckt.getType();
int k=200;
int y=650;
int r=650;
int prevLevel=(int)Integer.parseInt(drawLevel.get(0));
boolean x=false;
String display=null;
%>
 
<%for(int s=0;s<count;s++){ %>
<div  style="position:absolute; left:<%=k%>px; top:<%=y+20%>px;">
<%=Character.toString((char)asciiValue) %><%asciiValue++; y=y+40;%></div>
<%} %>
<%y=r; k=k+100; %>

<%for(int i=0,j=0;i<drawLevel.size()||j<drawType.size();i++,j++){ %>
<% x=(drawType.get(j)==null); %>
<%if(Integer.parseInt(drawLevel.get(j))!=prevLevel) {%>
<% prevLevel=Integer.parseInt(drawLevel.get(j)); k=k+120; y=r; %>
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
<% if((drawType.get(j)).equalsIgnoreCase("and")) {%>
<img alt="and gate" height="50px" width="50" src="and.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("or")) {%>
<img alt="" height="50px" width="50" src="Or.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("xor")) {%>
<img alt="" height="50px" width="50" src="exor.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("xnor")) {%>
<img alt="" height="50px" width="50" src="exnor.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("not")) {%>
<img alt="" height="50px" width="50" src="not.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("nand")) {%>
<img alt="" height="50px" width="50" src="Nand.png"><br><%asciiValue++;} %>
<% if((drawType.get(j)).equalsIgnoreCase("nor")) {%>
<img alt="" height="50px" width="50" src="Nor.png"><br><%asciiValue++;} %>
<%} %>
</div>
<% y=y+80; %>
<%} %>
</body>
</html>
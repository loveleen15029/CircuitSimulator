<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.winter.project.java.XMLParser"%>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Winter Project</title>
</head>
<body>
<body>
        <div id="result">
            <%           
            XMLParser parse=new XMLParser();
            String fileName=(String)request.getAttribute("message");
            parse.saxParser(fileName);
            response.sendRedirect("output.jsp");
            %>               
        </div>
    </body>

</body>
</html>
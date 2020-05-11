<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<table align="center" style="border:1px solid #000000;">
<%
if(session.getAttribute("username")!=null && session.getAttribute("username")!=""){
	String user=session.getAttribute("username").toString();

%>
<tr> <td align="center">Welcome<%= user %></td></tr>
<%} %>
</body>
</html>
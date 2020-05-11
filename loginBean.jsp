<%@ page import="java.sql.*, java.util.*, java.io.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Search</title>
</head>
<body>
<jsp:useBean id="db" scope="request" class="myBean.LoginBean" > 
 <jsp:setProperty name="db" property="userName" param="uName1" />   
 <jsp:setProperty name="db" property="passWord" param="pWord1" />     
 </jsp:useBean>
 <jsp:forward page="/login_url">    
 <jsp:param name="uName2" value="<%=db.getUserName()%>" />   
 <jsp:param name="pWord2" value="<%=db.getPassWord()%>"  /> 
 </jsp:forward> 
</body>
</html>
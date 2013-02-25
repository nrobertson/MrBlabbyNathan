<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", 0); 
%> 
<%Iterator itr;%>

<% List messageList= (List)request.getAttribute("messageList");
for (itr=messageList.iterator(); itr.hasNext(); )
{
%>
<fieldset>
<%=itr.next()%><br>
<%=itr.next()%>
<%=itr.next()%>

<br>
</fieldset>



<%}%>
</body>
</html>
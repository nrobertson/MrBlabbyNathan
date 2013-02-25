<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body> 

<%Iterator itr;%>

<% List messageList= (List)request.getAttribute("messageList");
for (itr=messageList.iterator(); itr.hasNext(); )
{
%>
<fieldset>
<%=itr.next()%><br>
<%=itr.next()%>
<p>follow</p>

<br>
</fieldset>



<%}%>

</body>
</body>
</html>
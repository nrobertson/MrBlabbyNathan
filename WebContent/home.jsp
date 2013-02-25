<%@ page language="java" import=" java.util.*;" contentType="text/html; charset= ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type ="text/css" href="/MrBlabbyNathan/Menu.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", 0); 
%> 
<ul id="nav">    
 <li><a href="#">Home</a></li>    
  <li><a href="#">Messages</a></li>     
  <li><a href="#">Log out</a></li>
  
</ul>
<form  id="searchBox" action="SearchServlet" id =SerchBar >
<input id = search type="text" name="Search" placeholder="Search" />
<select name = "searchType">
 <option value="message">Messages</option>
  <option value="user">Users</option>
</select>
<input type="submit" id ="search"Value="Search"/>
</form>
<div id="user">
	<h3>User</h3>

<fieldset>

	<%= session.getAttribute("Sname")%><br>
	<%= session.getAttribute("Semail")%>
	</fieldset>
</div>	
<div id="Searchmessage">


<%Iterator itr;%>

	<h3>Messages</h3>
<% List messageList= (List)request.getAttribute("messageList");
if(messageList == null)
{%>
<p>no messages</p>
	<%}
else
{
	
for (itr=messageList.iterator(); itr.hasNext(); )
{
%>
<fieldset>
<%=itr.next()%><br>
<%=itr.next()%>
<%=itr.next()%>

<br>
</fieldset>
<%}}
%>
</div>
<div id="newMessage">
<form  id="MsgBox" action="NewMessage" id =newmessage >
<textarea  name ="newMessage"></textarea>
<input type="submit" id ="message"Value="Post Message"/>
</form>
</div>
</body>
</html>
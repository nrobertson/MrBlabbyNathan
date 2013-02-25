<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type ="text/css" href="/MrBlabbyNathan/loginForm.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
 <form action="RegisterServlet" >
<fieldset id="inputs">
 <input type="text" name="Name" placeholder="name"required/>
 <br/>
 <input type="text" name="Email" placeholder="email"required/>
<br/>
 <input type="password" name="Password" placeholder="password"required/>
 </fieldset>
 <fieldset>
<input type="submit" value ="Register" />
</fieldset>
</form>
</div>
</body>
</html>
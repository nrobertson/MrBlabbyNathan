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

<form action="Servlet2" method = post id =loginForm >
<fieldset id="inputs">
<input id = username type="text" name="Email" placeholder="email" required/><br>
<input id = password type="password" name="Password" placeholder="Password" required/>
</fieldset>
 <fieldset id="actions">
<input type="submit" id ="submit"Value="Log In"/>
    </fieldset>
</form>

<p>Or <a href="Register.jsp">Register</a><p/>


</body>
</html>
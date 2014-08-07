<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	function display()
	{
		window.location = "Home.html";
	}
</script>


</head>

<body onload="setTimeout(function(){window.location = 'Home.html'},5000)">
<%
int rows = (Integer)request.getAttribute("rowsInserted");
if(rows>0)
{
	out.println("Registration successful<br/>");
	out.println("Account ID: "+(Integer)request.getAttribute("accountID")+"<br/>");
	out.println("Password: "+(String)request.getAttribute("password")+"<br/>");
}
else if(rows<0)
{
	out.println("Registration failed");	
}
%>
</body>
</html>
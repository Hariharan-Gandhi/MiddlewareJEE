<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Customer Register</title>
</head>
<body>

<%

String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String addr  = request.getParameter("address");
String telph = request.getParameter("telephone");
String email = request.getParameter("email1");
String pass  = request.getParameter("pass1");

manageCustomer MC = new manageCustomer();
MC.addCustomer(email, pass, fname, lname, addr, telph);

%>

<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<br />
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>
<br>
<table>
<tr>

	<td>
		 <h1>Thank You for Registering with Omazon!! Please click here to Login! </h1>
	</td>
	<td>
		 <a href="Login.jsp"><img src="Images/login.jpg" alt="Login" width="200" height="182"></a>
	</td>
	
</tr>

</table>

</body>
</html>
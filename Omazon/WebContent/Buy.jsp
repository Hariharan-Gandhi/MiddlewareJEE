<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Buy Products</title>
</head>
<body>
<%
	String theUser = (String)session.getAttribute("theUser"); 	
	if (theUser != null ) {%>  
<table>
<tr>
	<td>
		<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1150" height="330"></img>		
	</td>
	<td valign = "top" >
		 <a href="Logout.jsp"><img src="Images/logout.png" width="200" height="75" ></img></a>
	</td>	
</tr>
</table>	
<br />
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>
	
	<% String[] values = request.getParameterValues("cbbuy");
	System.out.println("1");
		if (values != null) {
			System.out.println("2");
		for (int i = 0; i < values.length; i++) 
		{
		 System.out.println(values[i]);
		  
		} 
		
		String email = (String)session.getAttribute( "email" );
		String pass = (String)session.getAttribute( "pass" );
		
		ManageOrders MO = new ManageOrders();
		MO.createOrder(email, pass, values);
			
	%>
    Your Order has been placed successfully! Click <a href="AllOrders.jsp">here</a> to view your orders!		
<% } } else { %>       		
	
<table>
<tr>
	<td>
		<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1150" height="330"></img>		
	</td>	
</tr>
</table>
<br />
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>   			

Please Login to buy Products! Click <a href="Login.jsp">here</a> to Login!
<%	} %>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "org.omazon.java.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Shipment Status</title>  
</head>
<body>
<%
	String theUser = (String)session.getAttribute("theUser"); 
	System.out.println(theUser); 
	if (theUser != null ) {
		String orderID = request.getParameter("order");
		ManageOrders MO = new ManageOrders();
		MO.updateShipment(orderID);	
	
	%>  
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
<h3> Shipment Status for order no: <% out.print(orderID); %> has been updated to delivered! </h3>  

<h3>Click <a href="AddProduct.jsp">here</a> to add products </h3>
<h3>Click <a href="EditProduct.jsp">here</a> to edit products </h3> 
<h3>Click <a href="DeleteProduct.jsp">here</a> to delete products </h3>
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<h3>Click <a href="UpdateShipment.jsp">here</a> to update shipment status </h3> 
  		
<% 	
	} else { %>       		
	
<table>
<tr>
	<td>
		<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1150" height="330"></img>		
	</td>
	<td valign = "top" >
		 <a href="Login.jsp"><img src="Images/login.jpg" width="200" height="75" ></img></a>
	</td>	
</tr>
</table>
<br />
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>  
Please Login to Update Shipments! Click <a href="Login.jsp">here</a> to Login! 			
<%	} %><br />
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "org.omazon.java.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Customer Orders</title>  
</head>
<body>

<%
	String theUser = (String)session.getAttribute("theUser"); 
	System.out.println(theUser); 
	if (theUser != null ) { %>  
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
<%   
String orderID = request.getParameter("orderID"); 
ManageOrders MO = new ManageOrders();
Shipment shipment = MO.getShipment(orderID);
System.out.println(shipment.getShipmentID());
Truck truck = MO.getTruck(shipment.getTruck());	
%>
<h1> Order Details: </h1>

<h4> Order ID: <% out.println(orderID); %> <br /> </h4>

<h4> Shipment ID: <% out.println(shipment.getShipmentID()); %> <br /> </h4>
<h4> Shipping Status: <% out.println(shipment.getShipStatus()); %> <br /> </h4>
<h4> Truck ID: <% out.println(truck.getTruckID()); %> <br /> </h4> <br />

<table border="1" style="height: 46px; width: 299px; ">
<tr><h4><u> TRUCK LOCATION :</u></h4></tr>
<tr>
<td><h4> Latitude: </h4></td>
<td><h4>  <% out.println(truck.getLatitude()); %>° </h4></td>
</tr>
<tr>
<td><h4> Longitude: </h4></td>
<td><h4>  <% out.println(truck.getLongitude()); %>° </h4></td>
</tr>
<tr>
<td><h4> Others(Exception): </h4></td>
<td><h4><font color="red"> <% out.println(truck.getException()); %>  </font> </h4></td>
</tr>
</table>
	
<!-- 
<table id = "products" border="1" style="width: 602px; ">
<tr style='background-color: #6B9DEF; color: #000000; font-family: "Trebuchet MS", Sans-Serif; height: 63px'>
<th>
	Product ID 
</th>
<th>
	Product Name		
</th>
<th>
	Product Amount	
</th>	
</tr>
</table>  -->
	
<h3>Click <a href="EditCustomer.jsp">here</a> to edit your personal data </h3>
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<h3>Click <a href="BuyProducts.jsp">here</a> to buy products </h3>
<h3>Click <a href="AllOrders.jsp">here</a> to track your orders </h3>	
	
<%	} else { %>       		
	
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
Please Login to View your Orders! Click <a href="Login.jsp">here</a> to Login! 			
<%	} %><br />

</body>
</html>
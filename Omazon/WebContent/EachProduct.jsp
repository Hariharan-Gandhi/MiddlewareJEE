<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Product Detail View</title>
</head>
<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<form id = "regform"  method="post" action="BuyProducts.jsp">
<%

System.out.println("Each product page");
String availability = null;
String productID = request.getParameter("productID");

System.out.println(productID);

Product p = new Product();
manageProduct MP = new manageProduct();

p = MP.getProduct(productID);
if (p.getProdQuan() > 0)
	availability = "In Stock";
else
	availability = "Out of Stock";
%>
<h3> <% out.print(availability); %></h3> 
<h1> <% out.println(p.getProdName()); %></h1>
<h4><i><% out.println(p.getProdDesc()); %> </i></h4>
<h2> <% out.println(p.getProdPrice() + "EUR"); %> </h2> 
<div class="img">
 <img src="Images/cart.jpg" width="225" height="225" />
 <input type="submit" value="ADD TO CART" /> 
</div> 
</form>
</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Product</title>
</head>
<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<%
String productID = request.getParameter("productID");
System.out.println(productID);
Product p = new Product();
manageProduct MP = new manageProduct();
p = MP.getProduct(productID);
%>

<form action = "dbEditProduct.jsp" method = "get">
	<input type="hidden" name="ProductID" value="<%= p.getProdID() %>" /> <br />
<table border = "1" align = "center">		
	<tr>
	<td>Product Name:</td>
	<td> <input type="text" name="ProductName" value="<%= p.getProdName() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Product Price:</td>
	<td> <input type="text" name="ProductPrice" value="<%= p.getProdPrice() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Product Description:</td>
	<td> <input type="text" name="ProductDesc" value="<%= p.getProdDesc() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Quantity available:</td>
	<td> <input type="text" name="ProductQuantity" value="<%= p.getProdQuan() %>" /><br /></td>
	</tr>
	</table>
	<p align = "center">
	<input type = "submit" name = "AddProduct" value = "Save" />
	</p> 
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<table>
<tr>
	<td>
		<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1150" height="330"></img>		
	</td>
	<td valign = "top" >
		 <img src="Images/logout.png" width="200" height="75" ></img>
	</td>	
</tr>
</table>
<form action = "dbAddProduct.jsp" method = "get">
<table border = "1" align = "center">
	<tr>
	<tr>
	<td>Product Name:</td>
	<td><input type = "text" name = "ProductName" /> <br /></td>
	</tr>
	<tr>
	<td>Product Price:</td>
	<td><input type = "text" name = "ProductPrice" /> <br /></td>
	</tr>
	<tr>
	<td>Product Description:</td>
	<td><input type = "text" name = "ProductDesc" /> <br /></td>
	</tr>
	<tr>
	<td>Quantity available:</td>
	<td><input type = "text" name = "ProductQuantity" /> <br /></td>
	</tr>
	</table>
	<p align = "center">
	<input type = "submit" name = "AddProduct" value = "Add" />
	</p> 
</form>
</body>
</html>
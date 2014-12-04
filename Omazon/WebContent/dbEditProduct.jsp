<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Product Edited</title>
</head>
<body>

<%

String prodID = request.getParameter("ProductID");
String prodName = request.getParameter("ProductName");
String prodPrice = request.getParameter("ProductPrice");
String prodDesc = request.getParameter("ProductDesc");
String prodQuan = request.getParameter("ProductQuantity");

Integer prodPriceInt = Integer.valueOf(prodPrice);
Integer prodQuanInt = Integer.valueOf(prodQuan);
Integer prodIDInt = Integer.valueOf(prodID);

manageProduct MP = new manageProduct();
MP.editProduct(prodIDInt, prodName, prodPriceInt, prodDesc, prodQuanInt);

out.print("Product " + prodID + " has been edited successfully!");

%>

</body>
</html>
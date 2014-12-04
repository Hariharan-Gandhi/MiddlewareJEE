<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Adding Product</title>
</head>
<body>
<%
String theUser = (String)session.getAttribute("theUser");
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
<h3>Hello <i><% out.print(theUser); %>, </i></h3>

<%
String prodName = request.getParameter("ProductName");
String prodPrice = request.getParameter("ProductPrice");
String prodDesc = request.getParameter("ProductDesc");
String prodQuan = request.getParameter("ProductQuantity");
//String prodImg = request.getParameter("ProductImage");

Integer prodPriceInt = Integer.valueOf(prodPrice);
Integer prodQuanInt = Integer.valueOf(prodQuan);
Integer prodID = null;

manageProduct MP = new manageProduct();
prodID = MP.addProduct(prodName, prodPriceInt, prodDesc, prodQuanInt);

String prodIDstr = Integer.toString(prodID); 

out.print("Product has been added: " + prodIDstr);

%>
		
<h3>Click <a href="AddProduct.jsp">here</a> to add products </h3>
<h3>Click <a href="EditProduct.jsp">here</a> to edit products </h3> 
<h3>Click <a href="DeleteProduct.jsp">here</a> to delete products </h3>
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>

<%} else { %>       		
	
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1300" height="400"></img>
<br />
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>   		
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3> 	
<%	} %>


</body>
</html>
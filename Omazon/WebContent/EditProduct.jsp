<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "org.omazon.java.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Displaying All Products</title>
</head>
<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<table border="1">
<tr>
	<th>
		Product ID
	</th>
	<th>
		Product Name		
	</th>
	<th>
		Product Price		
	</th>
	<th>
		Product Description		
	</th>	
</tr>

<% 
List<Product> products = null;
manageProduct MP = new manageProduct();
products = MP.getProducts();

for(Iterator<Product> i = products.iterator(); i.hasNext();){
	Product p = (Product)i.next();
	
	%> <tr>  
		
		<td align = "center" > 
				<% out.print(p.getProdID()); %> 
		</td>
		<td align = "center" > 					
			<% out.print(p.getProdName()); %> 			
			<form action="EachProductEdit.jsp" method="post">
    		<input type="hidden" name="productID" value="<%= p.getProdID() %>" />
		    <input id="button" type="submit" value="Edit" />
			</form>				
		</td>
		<td> <% out.print(p.getProdPrice() + " EUR"); %> </td>
		<td> <% out.print(p.getProdDesc()); %> </td>	
</tr> <% 	
}
%>
</table>
</body>
</html>
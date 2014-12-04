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
<%
	String theUser = (String)session.getAttribute("theUser"); 
	System.out.println(theUser); 
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
<% } else { %>       		
	
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
<%	} %><br />
<table id = "products" border="1" style="width: 602px; ">
<tr style='background-color: #6B9DEF; color: #000000; font-family: "Trebuchet MS", Sans-Serif; height: 63px'>
	<th>	</th>
	<th>
		Product ID
	</th>
	<th>
		Product Name		
	</th>	
</tr>

<% 
List<Product> products = null;
manageProduct MP = new manageProduct();
products = MP.getProducts();
for(Iterator<Product> i = products.iterator(); i.hasNext();){
	Product p = (Product)i.next();
	
	%> 
	
	<tr>
		<td align = "center" style="border-bottom-style: none; border-top-style: none; border-left-style: none; border-right-style: none"> 								
		<form action="EachProduct.jsp" method="post">
    		<input type="hidden" name="productID" value="<%= p.getProdID() %>" />
		    <input id="button" type="submit" value="View" <% out.print(p.getProdName()); %> style='color: #FFFFFF; background-color: #408080; font-family: "Comic Sans MS", Sans-Serif'/>
		</form>				
		</td>	  	
		<td align = "center" > 
				<% out.print(p.getProdID()); %> 
		</td>
		<td align = "left" style='margin-right: auto; height: auto; width: auto; margin-left: auto; margin-bottom: auto; margin-top: auto; color: #000040; text-transform: capitalize; font-style: italic; font-family: "Trebuchet MS", Sans-Serif'> 					
			<% out.print(p.getProdName()); %> 			
		</td>			
	
</tr> <% 	
}
%>
</table>

</body>
</html>
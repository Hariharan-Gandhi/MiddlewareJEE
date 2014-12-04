<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "org.omazon.java.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to OMAZON.com - Your ultimate Logistics Destination</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>

<body>

<%
	String valid = null;
	String dbEmail = null;
	String dbPswd = null;
	String dbFlag = null;
    String Email = request.getParameter("email");
    String Password = request.getParameter("pass");    
    if (request.getMethod().equalsIgnoreCase("POST")) {   
      
       ValidateLogin VL = new ValidateLogin();
       
       Login login = VL.validation(Email, Password);      	      
       if ( login != null ) {
   		dbEmail = login.getEmail();
   		dbPswd = login.getPassword();
   		dbFlag = login.getEFlag();
   		session.setAttribute( "dbFlag", dbFlag );
   		if ( dbEmail != null && dbPswd != null ){	
   		if (dbEmail.equals(Email) && dbPswd.equals(Password)){ 
   			valid = "T"; 
   			session.setAttribute( "theUser", Email );
   			session.setAttribute( "pass", Password );
   			session.setAttribute( "email", Email );
   		} 
   		else valid = "F";			   	
   		} 
   	}  						
       else { valid = "F"; }     
   		
       if ( valid.equals("F")) { 			
       	String site = new String("http://localhost:8080/Omazon/Login.jsp");
       	response.setStatus(response.SC_MOVED_TEMPORARILY);
       	response.setHeader("Location", site);
       	session.setAttribute( "theValid", valid );
       }      
    } 

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
<br>
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>     		
<% } else { %>       		
	
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1300" height="400"></img>
<br>
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>   		
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3> 	
<%	} if (dbFlag != null ){
		session.setAttribute("EFlag", dbFlag);
	    if ( dbFlag.equals("A") )
		{ %> 
		<h4>Hello <i>Admin,</i></h4>
		<h3>Click <a href="AddEmployee.jsp">here</a> to add Employees </h3>
		<h3>Click <a href="EditEmployee.jsp">here</a> to edit Employee details </h3>
		<h3>Click <a href="DeleteEmployee.jsp">here</a> to delete Employees </h3>
		 <h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
		
		 <% 
		}		    
   else if ( dbFlag.equals("E") ) {
		%>
<h3>Hello <i><% out.print(dbEmail); %>, </i></h3>		
<h3>Click <a href="AddProduct.jsp">here</a> to add products </h3>
<h3>Click <a href="EditProduct.jsp">here</a> to edit products </h3> 
<h3>Click <a href="DeleteProduct.jsp">here</a> to delete products </h3>
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<h3>Click <a href="UpdateShipment.jsp">here</a> to update shipment status </h3>  
<% } else if ( dbFlag.equals("C") ) {
	%>
<h3>Hello <i><% out.print(dbEmail); %></i>, </h3>	
<h3>Click <a href="EditCustomer.jsp">here</a> to edit your personal data </h3>
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<h3>Click <a href="BuyProducts.jsp">here</a> to buy products </h3>
<h3>Click <a href="AllOrders.jsp">here</a> to track your orders </h3>
<% }     			
	
}
//}
%>      
<br>
<table>
<tr>
	<td>
		<div class="img">
		 <a target="_blank" href="Product.jsp"><img src="Images/Samsung.jpg" alt="Samsung" width="200" height="150"></a>
		 <div class="desc">Samsung Galaxy S9</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a target="_blank" href="Product.jsp"><img src="Images/iPhone.jpg" alt="iPhone" width="200" height="182"></a>
		 <div class="desc">Apple iPhone7</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a target="_blank" href="Product.jsp"><img src="Images/Blackberry.jpg" alt="Blackberry" width="200" height="150"></a>
		 <div class="desc">Blackberry E501</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a target="_blank" href="Product.jsp"><img src="Images/Hauwei.jpg" alt="Hauwei" width="200" height="182"></a>
		 <div class="desc">Hauwei A106</div>
		</div>
	</td>
	<td>
	&nbsp;
	</td>
	
<% 
	if (theUser == null){
%>	

	<td>
		 <a href="Registration.jsp"><img src="Images/registernow.jpg" alt="Click Here" width="200" height="182"></a>
	</td>
	<td>
		 <a href="Login.jsp"><img src="Images/login.jpg" alt="Login" width="200" height="182"></a>
	</td>

<% } %>	
</tr>

</table>


</body>
</html>
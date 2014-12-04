<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to OMAZON.com - Your ultimate Logistics Destination</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<!-- Adding Styles -->

</head>

<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<br>
<% session.invalidate(); %>
You have been successfully logout!! 
Click <a href="Home.jsp">here </a>to return to home page.
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<br>
<table>
<tr>
	<td>
		<div class="img">
		 <a href="AllProducts.jsp"><img src="Images/Samsung.jpg" alt="Samsung" width="200" height="150"></a>
		 <div class="desc">Samsung Galaxy S9</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a href="AllProducts.jsp"><img src="Images/iPhone.jpg" alt="iPhone" width="200" height="182"></a>
		 <div class="desc">Apple iPhone7</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a href="AllProducts.jsp"><img src="Images/Blackberry.jpg" alt="Blackberry" width="200" height="150"></a>
		 <div class="desc">Blackberry E501</div>
		</div>
	</td>
	<td>
		<div class="img">
		 <a href="AllProducts.jsp"><img src="Images/Hauwei.jpg" alt="Hauwei" width="200" height="182"></a>
		 <div class="desc">Hauwei A106</div>
		</div>
	</td>
	<td>
	&nbsp;
	</td>
	
	<td>
		 <a href="Registration.jsp"><img src="Images/registernow.jpg" alt="Click Here" width="200" height="182"></a>
	</td>
	<td>
		 <a href="Login.jsp"><img src="Images/login.jpg" alt="Login" width="200" height="182"></a>
	</td>
	
</tr>

</table>


</body>
</html>
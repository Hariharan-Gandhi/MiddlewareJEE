<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Employee</title>
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
<br>
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>     		
<% 

String empFName = request.getParameter("empFName");
String empLName = request.getParameter("empLName");
String empEmail = request.getParameter("email");
String empPassword = request.getParameter("password");
String empDes = request.getParameter("empDesignation");
String empTelNo = request.getParameter("empTelNo");
String empAddress = request.getParameter("empAddress");

Integer empID = null;

manageEmployee ME = new manageEmployee();
empID = ME.addEmployee(empFName,empLName,empEmail,empPassword,empDes,empTelNo,empAddress);

String empIDStr = Integer.toString(empID); 

out.print("Employee has been added: " + empIDStr); %>

		<h4>Hello <i>Admin,</i></h4>
		<h3>Click <a href="AddEmployee.jsp">here</a> to add Employees </h3>
		<h3>Click <a href="EditEmployee.jsp">here</a> to edit Employee details </h3>
		<h3>Click <a href="DeleteEmployee.jsp">here</a> to delete Employees </h3>
		<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3>
<%

} else { %>       		
	
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1300" height="400"></img>
<br>
<marquee><font color="darkblue" face= "calibri">Welcome to Germany's most reliable Logistic and Shopping Service</font></marquee>   		
<h3>Click <a href="AllProducts.jsp">here</a> to view more products </h3> 	
<%	} %>

</body>
</html>
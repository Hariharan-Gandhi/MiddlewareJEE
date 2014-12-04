<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Edit Customer</title>

<script type="text/javascript">
           
function validate()
            {	           
            	var p1 = document.getElementById("pass1").value;
            	var p2 = document.getElementById("pass2").value;
            	if((p1 != p2))
            	{
	                  document.getElementById("pass1").style.borderColor = "#E34234";
	                  document.getElementById("pass2").style.borderColor = "#E34234";
	                    
                  alert("Passwords Do not match. Please re-enter Carefully");
                  
	                  	document.getElementById("pass1").style.borderColor = "grey";
		                document.getElementById("pass2").style.borderColor = "grey";
                   return false; 
            	}
            }            	

        </script>

</head>
<body>
<%
String email = (String)session.getAttribute("email");
String password = (String)session.getAttribute("pass");
Customer cust = new Customer();
manageCustomer MC = new manageCustomer();;
cust = MC.getCustomer(email, password);

%> 
        <form id = "regform"  method="post" onsubmit="return validate()" action="dbEditCustomer.jsp">
        <input type="hidden" name="customerID" value="<%= cust.getCustomerID() %>" /> <br />        
        <img src="Images/Omazon.jpg" alt="Omazon"  width="1000" height="400"></img>
        
            <center>
            <table border="10" style="outset" width="50%" cellpadding="10">
                <thead>
                    <tr>
                        <th colspan="2" ><h3><font face="calibri" color="blue">CUSTOMER DATA</font></h3></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="<%= cust.getFirstName() %>" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="<%= cust.getLastName() %> " /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" value="<%= cust.getAddress() %>" /></td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="<%= cust.getTelephone() %>" /></td>
                    </tr>                    
                    <tr>
                        <td>Password</td>
                        <td><input type="password" id = "pass1" name="pass1" /></td>
                    </tr>
                    <tr>
                        <td>Repeat Password</td>
                        <td><input type="password" id = "pass2" name="pass2" /></td>
                    </tr>
                </tbody>
            </table>
            			<p align = "center">
			<input type = "submit" value = "Update" />

</p> 
            </center>
        </form>
    </body>
</html>
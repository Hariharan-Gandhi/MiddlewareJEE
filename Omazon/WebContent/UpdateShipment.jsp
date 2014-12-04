<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "org.omazon.java.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>OrderStatus</title>  
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
<br />
			<form method = "post" action = "StatusUpdated.jsp" >
            <table border="10" style="outset" width="50%" cellpadding="10">
                <tbody>
                    <tr style='background-color: #6B9DEF; color: #000000; font-family: "Trebuchet MS", Sans-Serif; height: 63px'>
                        <td>Enter OrderNo: <input type="text" id="order" name="order" /></td>
                    </tr>
                    <tr style='background-color: #6B9DEF; color: #000000; font-family: "Trebuchet MS", Sans-Serif; height: 63px'>
                        <td><input type="submit" value="Update Shipment Status" /></td>
                    </tr>                    
                </tbody>
            </table>
			</form>
     		
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
Please Login to Update Shipments! Click <a href="Login.jsp">here</a> to Login! 			
<%	} %>
</body>
</html>
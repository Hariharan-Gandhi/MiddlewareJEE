<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Edited</title>
</head>
<body>
<%
String eID = request.getParameter("empID");
String empFName  = request.getParameter("empFName");
String empLName  = request.getParameter("empLName");
String empDes  = request.getParameter("empDesignation");
String empTelNo = request.getParameter("empTelNo");
String empAddress = request.getParameter("empAddress");

Integer empIDInt = Integer.valueOf(eID);

manageEmployee ME = new manageEmployee();
ME.editEmployee(empIDInt, empFName, empLName, empDes, empTelNo, empAddress);

out.print("Employee " + eID + " has been edited successfully!");

%>

</body>
</html>
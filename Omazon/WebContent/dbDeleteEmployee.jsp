<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting Employee</title>
</head>
<body>

<%

String empID = request.getParameter("empID");
Integer empIDInt = Integer.valueOf(empID);

manageEmployee ME = new manageEmployee();
ME.deleteEmployee(empIDInt);

out.print("Employee " + empID + " has been deleted successfully!");

%>

</body>
</html>
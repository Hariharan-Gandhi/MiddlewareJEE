<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<table border="1">
<tr>
	<th>
		Employee ID
	</th>
	<th>
		Employee First Name		
	</th>
	<th>
		Employee Last Name		
	</th>
	<th>
		Employee Designation
	</th>
	<th>
		Click to Edit
	</th>
</tr>

<% 
List<Employee> employees = null;
manageEmployee ME = new manageEmployee();
employees = ME.getEmployees();

for(Iterator<Employee> i = employees.iterator(); i.hasNext();){
	Employee e = (Employee)i.next();
	
	%> <tr>  
		
		<td align = "center" > 
				<% out.print(e.getEmpID()); %> 
		</td>
		<td align = "center" > 
				<% out.print(e.getEmpFName()); %> 
		</td>
		<td align = "center" > 
				<% out.print(e.getEmpLName()); %> 
		</td>
		<td align = "center" > 
				<% out.print(e.getEmpDesignation()); %> 
		</td>
		<td>
			<form action="EachEmployeeEdit.jsp" method="post">
    		<input type="hidden" name="empID" value="<%= e.getEmpID() %>" />
		    <input id="button" type="submit" value="Edit" />
			</form>
		</td>		
</tr> <% 	
}
%>
</table>

</body>
</html>
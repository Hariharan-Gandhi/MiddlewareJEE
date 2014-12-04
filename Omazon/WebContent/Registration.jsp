<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Customer Registration </title>

<script type="text/javascript">
           
function validate()
            {
	           	var e1 = document.getElementById("email1").value;
            	var e2 = document.getElementById("email2").value;
            	var p1 = document.getElementById("pass1").value;
            	var p2 = document.getElementById("pass2").value;
            	if((e1 == null  || e1 =="")||(p1 == null  || p1 ==""))
            	{
            		alert("Email & Password fields cannot be empty..!!");
            		return false;
            	}
            		else
            		{
                		if (e1 != e2)
    		            	 {
	    		                  document.getElementById("email1").style.borderColor = "#E34234";
	    		                  document.getElementById("email2").style.borderColor = "#E34234";
	    		                    
    		                  alert("Emails Do not match. Please re-enter Carefully");
    		                  
	    		                  document.getElementById("email1").style.borderColor = "grey";
	     		                  document.getElementById("email2").style.borderColor = "grey";
    		                   return false; 
    		                 }
                		else if(p1 != p2)
                		 {
	  		                  document.getElementById("pass1").style.borderColor = "#E34234";
	  		                  document.getElementById("pass2").style.borderColor = "#E34234";
	  		                
			                  alert("Passwords Do not match. Please re-enter Carefully");
			                  
	  		                  document.getElementById("pass1").style.borderColor = "grey";
	   		                  document.getElementById("pass2").style.borderColor = "grey";
	   		               return false; 
		                 }
                		
    		           else{   		                     
    		           		return true;
    		               }
            		}
              }
        </script>

</head>
<body>

        <form id = "regform"  method="post" onsubmit="return validate()" action="dbRegistration.jsp">
        
        <img src="Images/Omazon.jpg" alt="Omazon"  width="1000" height="400"></img>
        
            <center>
            <table border="10" style="outset" width="50%" cellpadding="10">
                <thead>
                    <tr>
                        <th colspan="2" ><h3><font face="calibri" color="blue">ENTER THE REGISTRATION INFORMATION</font></h3></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="" /></td>
                    </tr>                    
                    <tr>
                        <td>Email</td>
                        <td><input type="text" id="email1" name="email1" /></td>
                    </tr>
                    <tr>
                        <td>Repeat Email</td>
                        <td><input type="text" id="email2" name="email2" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" id="pass1" name="pass1"  /></td>
                    </tr>
                    <tr>
                        <td>Repeat Password</td>
                        <td><input type="password" id="pass2" name="pass2" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="Login.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
<!-- ------------------------------------------------------------------ -->
	<!-- Entries used in this JSP - 'fname' 'lname' 'email1' 'pass1' -->
<!-- ------------------------------------------------------------------ -->
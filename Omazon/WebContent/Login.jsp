<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Omazon Login</title>
<script type="text/javascript">
           
function validate()
            {
	           	var e1 = document.getElementById("email").value;
            	var p1 = document.getElementById("pass").value;
            	if((e1 == null  || e1 ==""))
            	{
            		document.getElementById("email").style.borderColor = "#E34234";            		
            		alert("Email field cannot be empty..!!");
            		document.getElementById("email").style.borderColor = "grey";            		
            		return false;f
            	}
            	else if (p1 == null  || p1 =="")
            	{  
            		document.getElementById("pass").style.borderColor = "#E34234";
            		alert("Password field cannot be empty..!!");
            		document.getElementById("pass").style.borderColor = "grey";
                	return false;            			
            	}            	
            	else { 
            		
            	    var filter = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            	    if (!filter.test(e1)) {
            	    document.getElementById("email").style.borderColor = "#E34234";             	    	
            	    alert('Please provide a valid email address');
            	    document.getElementById("email").style.borderColor = "grey";
            	    return false; }
            	    
            	    else {      
						return true;
            	    }
            	}
            		
              }
        </script>

</head>
<body>
<%  
	String valid = (String)session.getAttribute( "theValid" );
if ( valid != null ) {
	if (valid.equals("F")) {
		session.invalidate();
		// System.out.println(valid);
		%>
		<script>
		alert('Email and Password do not match'); 	
		</script>
<%	}	}
%>
        <form id = "regform"  method="post" onsubmit="return validate()" action="dbLogin.jsp">
        
        <img src="Images/Omazon.jpg" alt="Omazon"  width="1000" height="400"></img>
        
            <center>
            <table border="10" style="outset" width="50%" cellpadding="10">
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" id="email" name="email" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" id="pass" name="pass"  /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>                    
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
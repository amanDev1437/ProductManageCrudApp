<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
   <h1 class="text-centre">User Registered with following details</h1>
   <h2 class="text-centre"> Name:${user.name}</h2>
   <h2 class="text-centre"> Email:${user.email}</h2>
   <form action="/" method = "post">
           <div class="container">
                       <button type="submit" class="btn btn-primary">Login</button>
                     </div>
       </form>

   </body>
</html>

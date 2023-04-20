<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nixsolution.ppp.jpa_hibernate.entity.User" %>
<%@ page import="com.nixsolution.ppp.jpa_hibernate.entity.Role" %>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
   <title>Admin</title>
   <link href='./css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>

   <div class='mydiv'>
		<c:choose>
            <c:when test="${not empty user}">
                <h1 align='center'>Update user</h1>
            </c:when>
            <c:otherwise>
				<h1 align='center'>New user</h1>
            </c:otherwise>        
        </c:choose>
      <form method='post' action='admin'>
      Login: <input type='text' name='login' value = '${user.login}' required='required'/>
      Password: <input type='text' name='password' value = '${user.password}' required='required'/>
      Email: <input type='text' name='email' value = '${user.email}' required='required'/>
      First name: <input type='text' name='firstName' value = '${user.firstName}' required='required'/>
      Last name: <input type='text' name='lastName' value = '${user.lastName}' required='required'/>
      <label for="start">Birthday:</label>
      <th><input type="date" name="birthday"></th>


      Role: <input type='text' name='role' value = '${user.getRole().getName()}' required='required'/>

         <c:choose>
            <c:when test="${not empty user}">
                <button type='submit' name = 'Butt' value = '${user.id}' class='btn btn-primary btn-block btn-large'>UPDATE</button>
            </c:when>
            <c:otherwise>
				<button type='submit' name = 'Butt' value = '0' class='btn btn-primary btn-block btn-large'>CREATE</button>
            </c:otherwise>        
        </c:choose>
      </form>
   </div>
</body>
</html>
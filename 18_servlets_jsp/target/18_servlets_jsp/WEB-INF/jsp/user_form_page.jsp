<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nixsolution.ppp.servlet_jsp.entity.User" %>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
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
      <input type="date" id="start" name="trip-start"
      min="1000-01-01" max="3000-12-31">
      Role: <input type='text' name='roleId' value = '${user.roleId}' required='required'/>




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
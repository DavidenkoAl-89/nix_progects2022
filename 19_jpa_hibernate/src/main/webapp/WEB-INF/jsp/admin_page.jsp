<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nixsolution.ppp.jpa_hibernate.entity.User" %>
<%@ page import="com.nixsolution.ppp.jpa_hibernate.entity.Role" %>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<html>
<head>
	<title>Admin</title>
	<link href='./css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<div align='right'>
		<div style="display: inline-block; padding-right: 50px;">
			<form method="get" action="hello">
				<button type="submit" class="btn btn-primary btn-block btn-large">Log out</button>
			</form>
		</div>
	</div>

	<h1 align='center'>Admin page</h1>
	<div align='center' >

	    <table border='1'>
            <caption><h2>Users</h2></caption>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Birthday</th>
                <th>Role</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.birthday}"/></td>
                       <td><c:out value="${user.getRole().getName()}" /></td>
                    <td>
                        <form method="get" action="data">
                            <button type="submit" name = "Butt" value = "${user.id}"
                                class="btn btn-primary btn-block btn-large">Update</button>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="admin">
                            <button type="submit" name = "removeButt" value = "${user.id}"
                                class="btn btn-primary btn-block btn-large">Remove</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
         </table>

	    <div align='center'  style="display: inline-block;">
    	    <form method="get" action="data">
                <button type="submit" name = "Butt" value = "0"
                 class="btn btn-primary btn-block btn-large">Add new user</button>
            </form>
        </div>
	</div>
</body>
</html>
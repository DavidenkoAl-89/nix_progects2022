<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nixsolution.ppp.jpa_hibernate.entity.User" %>

<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<html>
<head>
	<title>Message</title>
	<link href='./css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class='mydiv'>
        <h1 align='center'>${message}</h1>
        <form method='get' action='admin'>
		    <button type='submit' class='btn btn-primary btn-block btn-large'>Go to admin page</button>
	    </form>

	</div>
</body>
</html>
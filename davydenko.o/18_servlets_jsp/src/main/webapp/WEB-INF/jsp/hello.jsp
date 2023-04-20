<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
	<title>Hello</title>
	<link href='./css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<c:choose>
		<c:when test="${empty userInSession}">
			<h1 align='center'> Invalid login or password!</h1>

		</c:when>
		<c:when test="${roleId == 1}">
		       <div align='right'>
               		<div style="display: inline-block; padding-right: 50px;">
               			<form method="get" action="admin">
               				<button type="submit" class="btn btn-primary btn-block btn-large">Log out</button>
               			</form>
               		</div>
               	</div>
        	 <h1 align='center'>Admin page</h1>
        	 <h1 align='center'> Hello, <c:out value = "${userInSession.firstName}"/>
                    			        <c:out value = "${userInSession.lastName}"/>!</h1>
             <div align='center'>
             	<div style="display: inline-block;">
             		<form method="get" action="admin">
                         <button type="submit" class="btn btn-primary btn-block btn-large">Show user list</button>
                    </form>
             	</div>
             </div>
        </c:when>
		<c:otherwise>
			<div align='right'>
				<div style="display: inline-block; padding-right: 50px;">
					<form method="get" action="hello">
						<button type="submit" class="btn btn-primary btn-block btn-large">Log out</button>
					</form>
				</div>
			</div>
			<h1 align='center'> Hello, <c:out value = "${userInSession.firstName}"/>
			                           <c:out value = "${userInSession.lastName}"/>!</h1>

          </c:otherwise>
	</c:choose>
</body>
</html>
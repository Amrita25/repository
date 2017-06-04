<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>success page</title>

</head>
<body>
	<h1 align="center">Successfully registered</h1>
<%-- <c:set var="root" value="${pageContext.request.contextPath}"/> --%>
	
		<table>
			<tr>
				<td>${msg}</td>
				
			</tr>

		</table></br>
		Go Back To <a href="<c:url value='list'/>">List Of All Students</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>welcome page</title>

</head>
<body>

<!-- <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> -->
	<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.jqueryui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css"/>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#allstudents').DataTable();
		});
	</script>


	<div>
		<h1 align="center">Welcome to ABC University</h1>
	</div>
	<div>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<input type="button" onclick="location.href='${root}/addnew'" value="Add student">
	</div></br>
<h2 align="center">List Of All Students</h2></br>
	<table id="allstudents" class="display" cellspacing="0" width="100%">
		<thread>
		<tr>
			<th align="left">First Name</th>
			<th align="left">Last Name</th>
			<th align="left">Gender</th>
			<th  align="left">Date Of Birth</th>
			<th  align="left">Email</th>
			<th  align="left">Remove</th>
			<th  align="left">Edit</th>
		</tr>
		</thread>

		<tbody>

			<c:forEach items="${students}" var="stdnt">
				<tr>
					<td>${stdnt.firstName}</td>
					<td>${stdnt.lastName}</td>
					<td>${stdnt.gender}</td>
					<td>${stdnt.dob}</td>
					<td>${stdnt.email}</td>
					<td><a href="${root}/remove/${stdnt.studentId}">Remove</a></td>
					<td><a href="${root}/update/${stdnt.studentId}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
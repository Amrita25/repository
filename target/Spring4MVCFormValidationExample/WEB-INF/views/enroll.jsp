<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<div>
<c:set var="root" value="${pageContext.request.contextPath}"/>
</div>
	<div class="form-container">
		<h1>Enrollment Form</h1>
		<form:form action ="${root}/addnew/save" method="POST" modelAttribute="student"
			class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-10 control-lable" for="firstName">First
						Name</label>
					<div class="col-md-12">
						<form:input type="text" path="firstName" id="firstName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="firstName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="sex">Sex</label>
					<div class="col-md-7" class="form-control input-sm">
						<form:radiobutton path="sex" value="M" />
						Male
						<form:radiobutton path="sex" value="F" />
						Female
						<div>
							<form:errors path="sex"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="dob">Date of
						birth</label>
					<div class="col-md-7">
						<form:input type="text" path="dob" id="dob"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="dob" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Subjects : </label>
					<div class="col-md-7">
						<form:select path="subjects" multiple="true">
						<form:options items="${subjectlist}"/>
						</form:select>
						<div class="has-error">
							<form:errors path="subjects"/>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="layout/styles.jsp" %>
</head>
<body>
	<%@include file="layout/navigation.jsp" %>
	<div class="container">
		<h1><spring:message code="hello"/></h1>
	</div>
	<%@include file="layout/scripts.jsp" %>
</body>
</html>
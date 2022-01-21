<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<jsp:include page="common/header.jsp"/>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Hello world!</h1>
		<P>The time on the server is ${serverTime}.</P>
	</body>
</html>

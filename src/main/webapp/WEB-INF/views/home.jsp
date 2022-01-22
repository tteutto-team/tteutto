<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<%@ page session="false"%>
<jsp:include page="common/header.jsp"/>
<html>
	<head>
		<title>Home</title>
	</head>
	<body class="home">
		<div class="test">
			<h1>Hello world!</h1>
			<P>The time on the server is ${serverTime}.</P>
		</div>
	</body>
</html>
<jsp:include page="common/footer.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<c:set var="test" value="Parametr 1" scope="session"></c:set>
	<jsp:useBean class="pl.imsi.CreateAcc" id="createAcc" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="createAcc" value="${ param.name }"/>
	<jsp:setProperty property="login" name="createAcc" value="${ param.login }"/>
	<jsp:setProperty property="email" name="createAcc" value="${ param.email }"/>
	<c:out value="${ loginBean.name }"></c:out>
	<c:out value="${ loginBean.login }"></c:out>
	<c:out value="${ loginBean.email }"></c:out> --%>
	<form action="CreateAcc">
		<p>User name:</p>
		<input type="text" name="name" value="${ param.name }">
		<p>User login:</p>
		<input type="text" name="login" value="${ param.login }" >
		<p>User e-mail:</p>
		<input type="text" name="email" value="${ param.email }" >
		<br/><br/>
		<input type="submit" value="Stwórz konto">
	</form>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="test" value="Parametr 1" scope="session"></c:set>
	<jsp:useBean class="pl.imsi.LoginBean" id="loginBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="loginBean" value="${ param.user }"/>
	<jsp:setProperty property="password" name="loginBean" value="${ param.password }"/>
	<c:out value="${ loginBean.name }"></c:out>
	<c:out value="${ loginBean.password }"></c:out>
	<form action="LoginServlet">
		<p>Login:</p>
		<input type="text" name="user" value="${ param.user }">
		<p>Haslo:</p>
		<input type="password" name="password" value="${ param.password }" >
		<br/><br/>
		<input type="submit" value="Zaloguj">
	</form>
	<c:out value="${ param.user }"></c:out>
	<a href="CreateAccount.jsp">Stwórz konto</a>
</body>
</html>
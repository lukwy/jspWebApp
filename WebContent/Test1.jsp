<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${ sessionScope.test }"></c:out>
	<c:out value="${ sessionScope.loginBean.name }"></c:out>
	<c:out value="${ sessionScope.loginBean.password }"></c:out>
	
	<c:remove var="test"/>
	
	
	<form action="ChangePass">
		<p>Stare haslo:</p>
		<input type="text" name="oldPass" value="${ param.oldPass }">
		<p>Nowe haslo:</p>
		<input type="text" name="newPass" value="${ param.newPass }" >
		<p>Powtorz nowe haslo:</p>
		<input type="text" name="newPass1" value="${ param.newPass1 }" >
		<br/><br/>
		<input type="submit" value="Zmien haslo">
	</form>
	
	<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<form method="post">

<table border="2">
   <tr>
        <td>IP</td>
        <td>Operacja</td>
        <td>Data</td>
   </tr>
   <%
   try
   {
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String server = "localhost\\sqlexpress";
        int port = 53528;
        String cuid = (String) session.getAttribute("currentUserId");
        String user = "172075"; // Sql server username
        String password = "172075";
        String database = "MyBase";
       String jdbcUrl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+password+";databaseName="+database+"";
        	
       String query="select * from actions where userId = " + cuid;
       Connection conn=DriverManager.getConnection(jdbcUrl);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
     <tr>  <td><%=rs.getString("ip") %></td>
       <td><%=rs.getString("description") %></td>
       <td><%=rs.getTimestamp("czas") %></td></tr>

   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String failureMessage = (String)request.getAttribute("loginFailure"); %>

<% if (failureMessage != null) {%>
    <%=failureMessage %>
<%} %>

<form action="loginservlet" method="post">
    <input type="text" name="user_id">
    <input type="password" name="password">
    <input type="submit" value="ログイン">
</form>
</body>
</html>
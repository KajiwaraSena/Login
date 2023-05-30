<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%String userId = (String)request.getAttribute("user_id"); %>

<h1>ログイン成功！！</h1>
<h2>こんにちは！<%=userId %>さん</h2>
</body>
</html>
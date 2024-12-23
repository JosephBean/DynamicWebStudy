<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGE2</title>
</head>
<body>
	<h1>EL(Expression language) 방식</h1>
	<h3><%= request.getSession().getAttribute("name") %></h3>
</body>
</html>
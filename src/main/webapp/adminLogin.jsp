<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="admin">
<form action= "AdminLogin" method="post">
<h3>Please fill the required details</h3>
<label for="adminName"> Name</label>
<br>
<input id="adminName" name="adminName" type="text">
<br>
<label for="adminPassword"> Password</label>
<br>
<input id="adminPassword" name="adminPassword" type="password">
<br>
<button type="submit">Login</button>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Online Voting System</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@ include file="navbar.jsp" %>
<!--  to add color or to find color code number Go to "colorhunt.co" -->
<div class="form-container">
<form action="VoterLogin" method="post">
<h3>Enter your voter card number</h3>
<label for="voterNumber" > Voter ID </label>

<input name="voterNumber" id="voterNumber" type="text" placeholder="Enter voter number">
<br>
<button type="submit"> Login </button>
<br>
<a href="adminLogin.jsp">Admin</a>
</form>
</div>
</body>
</html>
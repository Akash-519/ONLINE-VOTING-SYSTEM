<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Contact Us </title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<%@ include file="navbar.jsp" 	 %>

<div class="contactUs">
<form action="Contact" method="post">
<h3>Please fill the required details:</h3>
<label for="uName">Name  </label>
<br>
<input name="uName" id="uName" type="text">
<br>
<label for="pNumber" > Phone Number </label>
<br>
<input name="pNumber" id="pNumber" type="number">
<br>
<label for="email"> Email </label>
<br>
<input name="email" id="email" type="email">
<br>
<label for="comment">Comment  </label>
<br>
<textarea name="comment" id="comment" rows="4" cols="8"></textarea>
<br>
<button type="submit">Submit</button>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Wellcome Voter</title>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<%@ include file="navbar.jsp" %>
<body>


<!--  to add color or to find color code number Go to "colorhunt.co" -->
<div class="form-container">
<form action="Vote" method="post">
<h3>Please full the required details </h3>
<label for="voterNumber" >Voter Number</label>
<br>
<input id="voterNumber" name="voterNumber" type="text">
<br>
<label for="partie">Choose a partie</label>
<br>
<select name="partie" id="partie">
<option value="aap">Aam Aadhmi Party</option>
<option value="bjp">BJP</option>
<option value="bsp">BSP</option>
<option value="congress">Congress</option>
<option value="cpi">CPI</option>
</select>
<br>
<button type="submit">Vote</button>
</form>
</div>
</body>
</html>
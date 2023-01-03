<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Results</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<%
String a[]=new String[100];
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineVotingDb","root","Akash630");

PreparedStatement st=con.prepareStatement("select partie,count(partie) as c from vote group by partie");
ResultSet rs=((java.sql.Statement)st).executeQuery("select partie,count(partie) as c from vote group by partie");
		
		int i=0;
while(rs.next())
{
	a[i]=rs.getString("c");
	i++;
}
%>
</head>
<body>
<%@ include file="adminNavbar.jsp" %>

<div class="check-table">
<table>
<tr>
<th>
Parties
</th>
<th>
Names
</th>
<th>
Votes
</th>
</tr>

<tr>
<td>
<img src="images/aap1.jpg" alt="AAP party">
</td>
<td>
Aam Aadmi Party
</td>
<td><%=a[0]==null?0:a[0]%></td>
</tr>

<tr>
<td>
<img src="images/BJP.jfif" alt="BJP Party">
</td>
<td>
BJP
</td>
<td><%=a[1]==null?0:a[1]%></td>
</tr>

<tr>
<td>
<img src="images/bsp2.png" alt="BSP Party">
</td>
<td>BSP</td>
<td><%=a[2]==null?0:a[2]%></td>
</tr>

<tr>
<td>
<img src="images/Congress.png" alt="Congress Party">
</td>
<td>Congress</td>
<td><%=a[3]==null?0:a[3]%></td>
</tr>

<tr>
<td>
<img src="images/cpi.jpg" alt="CPI Party">
</td>
<td>CPI</td>
<td><%=a[4]==null?0:a[4]%></td>
</tr>
</table>
</div>
</body>
</html>
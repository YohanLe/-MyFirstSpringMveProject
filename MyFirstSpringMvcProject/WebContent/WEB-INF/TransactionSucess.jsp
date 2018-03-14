<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javasrc.Transaction"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculated Transaction results</title>
</head>
<body>
<% Transaction Transaction1= new Transaction();
Transaction1.calculetedAmount(20);
%>
<table>
	<tr>
		<td>The premium amount used :-</td>
		<td>${Transaction1.premiumAmount}</td>
	</tr>
	<tr>
		<td>Year Band :- </td>
		<td>${Transaction1.yearBand}</td>
	</tr>
	<!--  
	<tr>
		<td>calculetedAmount :-</td>
		<td><%=Transaction1.calculetedAmount(20)%></td>
	</tr>-->
	
</table>
<h1>${msg}</h1>
</body>
</html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1> Student admission form</h1>
	<form:errors path="student1.*"/>
	<form action ="/MyFirstSpringMvcProject/submitRegistration.html" method = "post">
		<table>
			<tr>
				<td>Student First Name : <input type = "text" name ="firstname"></td>
			</tr>
			<tr>
				<td>Student Last Name : <input type = "text" name ="lastname"></td>
			</tr>
			<tr>
				<td>Student SSN : <input type = "text" name ="ssn"></td>
			</tr>
			<tr>
				<td>Student Email : <input type = "text" name ="email"></td>
			</tr>
	
		</table>
		
				<input type ="submit"  value = "Submit this form by clickinhg here">
	</form>
</body>
</html>
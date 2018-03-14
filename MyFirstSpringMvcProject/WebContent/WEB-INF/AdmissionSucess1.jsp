
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>${headermessage}</h1>
<table>
	<tr>
		<td>Student Name :-</td>
		<td>${student1.studentname}</td>
	</tr>
	<tr>
		<td>Student Hobby :- </td>
		<td>${student1.studenthobby}</td>
	</tr>
	<tr>
		<td>Student Mobile :-</td>
		<td>${student1.studentMobile}</td>
	</tr>
	<tr>
		<td>Student Date of Birth :- </td>
		<td>${student1.studentDOB}</td>
	</tr>
	
	<tr>
		<td>Student Skills :- </td>
		<td>${student1.studentSkills}</td>
	</tr>  
	<tr>
		<td>Student Address :- </td>
		<td>Country :${student1.studentAddress.country}
		    City : ${student1.studentAddress.city}
		    Street : ${student1.studentAddress.street}
		    pincode : ${student1.studentAddress.pincode}</td>
	</tr>
	
</table>
</body>
</html>
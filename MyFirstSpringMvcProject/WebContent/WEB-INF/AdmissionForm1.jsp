
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1> Student admission form</h1>
	<form:errors path="student1.*"/>
	<form action ="/MyFirstSpringMvcProject/submitAdmissionForm1.html" method = "post">
		<table>
			<tr>
				<td>Student Name : <input type = "text" name ="studentname"></td>
			</tr>
			<tr>
				<td>Student Hobby : <input type = "text" name ="studenthobby"></td>
			</tr>
			<tr>
				<td>Student Mobile : <input type = "text" name ="studentMobile"></td>
			</tr>
			<tr>
				<td>Student DOB : <input type = "text" name ="studentDOB"></td>
			</tr>
		   <tr>
				<td>Students Skill sets's :</td><td> <select name="studentSkills" multiple>
													  <option value ="Java core"> Java core </option>
													  <option value = "Spring core"> Spring Core </option>
													  <option value = "Selenium in java"> Selenium in java </option>  
													  </select></td>
			</tr>
		</table>
		<table>
			<tr><td>Students address</td></tr>
			<tr>
				<td>Country: <input type="text" name="studentAddress.country"></td>
				<td>City: <input type="text" name="studentAddress.city"></td>
				<td>Street: <input type="text" name="studentAddress.street"></td>
				<td>Pincode: <input type="text" name="studentAddress.pincode"></td>
			</tr>
		</table>
		
				<input type ="submit"  value = "Submit this form by clickinhg here">
	</form>
</body>
</html>
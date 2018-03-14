
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Insurance Broker System - Register</title>
</head>
<body style="background-color:powderblue;">
	<h1 style="color:blue;"> Account and Transaction Management System</h1>
	<form:errors path="student1.*"/>
	<form action ="/MyFirstSpringMvcProject/submitAdmissionForm1.html" method = "post">
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: left;
    padding: 16px;
    text-decoration: none;
}
 
li a:hover {
	 background-color: red;
}

</style>
</head>
<body>

<ul>
  <li><a href="home">Home</a></li>
  <li><a href="Transaction Manager">Transaction Manager</a></li>
  <li><a href="Login">Login</a></li>
  <li><a href="Registration.html">Registration</a></li>
</ul>

	</form>
</body>
</html>
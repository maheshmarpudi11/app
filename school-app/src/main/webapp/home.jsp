<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Home Page </h3>


<form action="addStudent" method="post">
	<label>Name</label><input type="text" name="name"> <br>
	<label>Gender</label> <label>M</label> <input type="radio" name="gender" value="M"> 
						  <label>F</label> <input type="radio" name="gender" value="F"> <br>
	<label>Address</label><input type="text" name="address"> <br>
	<label>Email</label><input type="email" name="email"> <br>
	<input type="submit" value="SUBMIT">
</form>

<table border="1px">
	<thead>
		<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Email</th>
		<tr>
	</thead>
	<tbody>
		<tr>
			<td>${student.name}</td>
			<td>${student.gender}</td>
			<td>${student.address}</td>
			<td>${student.email}</td>
		</tr>
	</tbody>
	
</table>

</body>
</html>
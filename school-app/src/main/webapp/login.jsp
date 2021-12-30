<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Welcome to Login Page </h3>

<form action="login" method="post">
	<label>Username</label> <input type="text" name="username"> 
	<label>Password</label> <input type="password" name="password"> 
	<input type="submit" value="SUBMIT">
</form>
<h4 style="color: red">${message}</h4>

</body>
</html>
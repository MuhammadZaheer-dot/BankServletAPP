<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="LoginServlet" method="post">
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<br>
<!-- Forgot Password button -->
<form action="reset.jsp" method="get">
    <input type="submit" value="Forgot Password?">
</form>

</body>
</html>

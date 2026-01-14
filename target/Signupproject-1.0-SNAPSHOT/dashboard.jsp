<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head><title>Dashboard</title></head>
<body>

<h2>Welcome!</h2>
<p>Logged in as: <b><%= session.getAttribute("email") %></b></p>

<a href="login.jsp">Logout</a>

</body>
</html>

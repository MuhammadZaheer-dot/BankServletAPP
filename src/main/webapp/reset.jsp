<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head><title>Reset Password</title></head>
<body>

<h2>Reset Your Password</h2>

<form action="ResetPasswordServlet" method="post">
    <input type="email" name="email" required><br>
    New Password:
    <input type="password" name="newPassword" required><br><br>
    <input type="submit" value="Reset Password">
</form>

</body>
</html>

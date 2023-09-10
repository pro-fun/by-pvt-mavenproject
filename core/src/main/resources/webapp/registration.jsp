<%@ page import = "by.academypvt.controller.RegisterServlet"%>
<%@ page import = "java.util.*"%>
<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>

<html>
<body>
<form method="post"
      action="http://localhost:8081/register" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        <h1>Register</h1>
        <p>Please, enter registration data</p>
        <hr>

        <label><b>Login</b></label>
        <input type="text" placeholder="Login" name="login">

        <label><b>Password</b></label>
        <input type="text" placeholder="Password" name="password">

        <label><b>Name</b></label>
        <input type="text" placeholder="Name" name="name">

        <label><b>Surname</b></label>
        <input type="text" placeholder="Surname" name="surname">
        <hr>
        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>

<form name="Form"
      method="get"
      action="http://localhost:8081/register">
      <input type=submit value="Type all registered accs">
</form>
</body>
</html>
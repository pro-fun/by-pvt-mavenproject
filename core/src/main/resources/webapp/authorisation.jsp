<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<div>
<b>Выберите необходимое действие</b>
</div>
<br>
<form name="Form"
      method="Post"
      action="http://localhost:8081/authorisation">
      <table>

                  <tr>
                  <td><B>Login</B></td>
                  <td><input type = textbox name="login" size="25" value=""></td>
                  </tr>

                        <tr>
                        <td><B>Password</B></td>
                        <td><input type = textbox name="password" size="25" value=""></td>
                        </tr>
                        </table>

                        <input type = submit value="Submit">

</form>
</body>
</html>
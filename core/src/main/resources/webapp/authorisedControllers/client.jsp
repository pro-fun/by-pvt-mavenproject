<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.*"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<div>
<b>Здравствуйте, </b> <c:out value = "${userResponse.name}"/>
</div>
<br>

<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/goods">
      <input type=submit value="Все товары магазина">
      </form>
      <br>
</body>
</html>



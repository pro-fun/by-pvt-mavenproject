<%@ page import="java.util.*"%>
<%@ page import = "by.academypvt.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<html>
<body>
<div>
<b>Список всех клиентов</b>

<br>

<c:out value="${users}" />
</div>
</body>
</html>
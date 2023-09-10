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

<form name="Form"
      method="Post"
      action="http://localhost:8081/goods">
    <div>
    <label><b>Наименование товара</b></label>
    <input type="text" placeholder="Название товара" name="name">

    <select name="type">
    <option disabled>Выберите тип товара</option>
    <option value="PHONES">Мобильные телефоны</option>
    <option value="NOTEBOOKS">Ноутбуки</option>
    <option value="TV">Телевизоры</option>
    <option value="PLAYSTATION">Игровые приставки</option>
    </select>

        <label><b>ID товара</b></label>
        <input type="text" placeholder="ID" name="id">

        <label><b>Код товара</b></label>
        <input type="text" placeholder="Код" name="code">

        <label><b>Цена товара</b></label>
        <input type="text" placeholder="Цена" name="price">

        <label><b>Количество товара</b></label>
        <input type="text" placeholder="Количество" name="quantity">

    <input type="hidden" name="action" value = "add">
    <input type=submit value="Добавить товар">
    </div>
</form>
<br>
<form name="Form"
      method="post"
      action="http://localhost:8081/goods">
    <div>
        <label><b>Id товара</b></label>
        <input type="text" placeholder="ID" name="idDelete">

    <input type="hidden" name="action" value = "delete">
    <input type=submit value="Удалить товар">
    </div>
</form>
<br>
<form name="Form"
      method="post"
      action="http://localhost:8081/goods">
    <div>
        <label><b>Id товара</b></label>
        <input type="text" placeholder="ID" name="idFind">

    <input type="hidden" name="action" value = "find">
    <input type=submit value="Найти товар">
    </div>
</form>
<br>




</body>
</html>
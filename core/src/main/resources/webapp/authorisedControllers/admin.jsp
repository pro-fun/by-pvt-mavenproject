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
<b>Список всех товаров в магазине</b>
<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/goods">
      <input type=submit value="Все товары магазина">
      </form>
      <br>

<b>Добавить товар в магазин</b>
<form name="Form"
      method="Post"
      action="http://localhost:8081/goodsupdate">
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

<b>Удалить товар из магазина</b>
<form name="Form"
      method="post"
      action="http://localhost:8081/goodsupdate">
    <div>
        <label><b>Id товара</b></label>
        <input type="text" placeholder="ID" name="idDelete">

    <input type="hidden" name="action" value = "delete">
    <input type=submit value="Удалить товар">
    </div>
</form>
<br>


<b>Найти товар по ID</b>
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
<b>Список всех клиентов магазина</b>
<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/usersupdate">
      <input type=submit value="Все клиенты магазина">
      </form>
      <br>

<b>Найти клиента по ID</b>
<form name="Form"
      method="post"
      action="http://localhost:8081/usersupdate">
    <div>
        <label><b>Id клиента</b></label>
        <input type="text" placeholder="ID" name="id">
            <input type="hidden" name="action" value = "find">
    <input type=submit value="Найти клиента по ID">
    </div>
</form>
      <br>

<b>Удалить клиента по ID</b>
<form name="Form"
      method="post"
      action="http://localhost:8081/usersupdate">
    <div>
        <label><b>Id клиента</b></label>
        <input type="text" placeholder="ID" name="idDelete">
            <input type="hidden" name="action" value = "delete">
    <input type=submit value="Удалить клиента по ID">
    </div>
</form>

<b>Все заказы магазина</b>
<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/ordersforadmin">
      <input type=submit value="Все заказы магазина">
      </form>
      <br>


<b>Удалить заказ</b>
<br>
<form name="Form"
      method="post"
      action="http://localhost:8081/ordersforadmin">
    <div>
        <label><b>Id заказа</b></label>
        <input type="text" placeholder="ID" name="idDelete">

    <input type="hidden" name="action" value = "delete">
    <input type=submit value="Удалить заказ">
    </div>
</form>
<br>

<b>Найти заказ по ID</b>
<form name="Form"
      method="post"
      action="http://localhost:8081/ordersforadmin">
    <div>
        <label><b>Id товара</b></label>
        <input type="text" placeholder="ID" name="idFind">

    <input type="hidden" name="action" value = "find">
    <input type=submit value="Найти заказ по ID">
    </div>
</form>

<b>Выйти из профиля</b>
<form name="Form"
      method="get"
      action="http://localhost:8081/logout">
    <input type=submit value="LogOut">
</form>

</body>
</html>
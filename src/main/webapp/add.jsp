<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 12.07.2022
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<header>
    <div class="header-intro">
        <div class="go-back">
            <a href="/cars?back=<%=request.getParameter("backurl")%>">
                <img id="image-go-back" src="${pageContext.request.contextPath}/static/go-back.png" alt="not found">
            </a>
        </div>
    </div>
</header>
<div class="main">
    <div class="form-container">
        <form method="post" class="add">
            <div><input type="text" name="mark" placeholder="enter a mark"></div>
            <div><input type="text" name="model" value="${car.model}" placeholder="enter a model"></div>
            <div><input type="text" name="engine" value="${car.engine}" placeholder="enter a engine"></div>
            <div><input type="date" name="releaseDate" value="${car.releaseDate}" placeholder="enter a release date"></div>
            <div><input type="number" name="price" value="${car.price}" placeholder="enter a price"></div>
            <div><input type="number" name="quantity" value="${car.quantity}" placeholder="enter quantity"></div>
            <div><input type="submit" name="addSubmit" value="add"></div>
        </form>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
<header>
    <div class="header-intro">
        <div class="go-back">
            <a href="/orders?back=<%=request.getParameter("backurl")%>" >
                <img id="image-go-back" src="${pageContext.request.contextPath}/static/go-back.png" alt="not found" >
            </a>
        </div>
    </div>
</header>
<div class="main">
<div class="form-container">
    <form method="post" class="add">
        <div>
            <select name="car_select">
            <c:forEach var="car" items="${cars}">
            <option value="${car.id}">${car.mark} ${car.model}</option>
            </c:forEach>
            </select>
        </div>
        <div><input type="date" name="purchase_date" ></div>
        <div><input type="number" name="full_price" ></div>
        <div><input type="submit" name="addSubmit" value="add"></div>
    </form>
</div>
</div>
<div class="footer">

</div>
</body>
</html>

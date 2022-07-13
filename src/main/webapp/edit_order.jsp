<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<header>
    <div class="header-intro">
        <div class="go-back">
            <a href="/orders?back=<%=request.getParameter("backurl")%>">
                <img id="image-go-back" src="${pageContext.request.contextPath}/static/go-back.png" alt="not found">
            </a>
        </div>
    </div>
</header>
<div class="main">
    <div class="form-container">
        <form method="post" class="edit">
            <div><select name="car_select">
                <option value="${order.car.id}">${order.car.mark} ${order.car.model}</option>
                <c:forEach var="car" items="${cars}">
                    <option value="${car.id}">${car.mark} ${car.model}</option>
                </c:forEach>
            </select></div>
            <div><input type="date" name="purchase_date" value="${order.purchaseDate}"></div>
            <div><input type="number" name="full_price" value="${order.fullPrice}"></div>
            <div><input type="submit" name="editOrderSubmit" value="Edit"></div>

        </form>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>

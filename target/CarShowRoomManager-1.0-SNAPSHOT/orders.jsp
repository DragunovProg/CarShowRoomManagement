<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
<header>
    <div class="header-intro">
        <div class="go-back">
            <a href="<%=request.getParameter("back")%>">
                <img id="image-go-back" src="${pageContext.request.contextPath}/static/go-back.png" alt="not found">
            </a>
        </div>
    </div>
</header>
<div class="main">
    <div class="table-container">
        <table class="order-table">
            <thead>
            <tr>
                <th>Employee</th>
                <th>Car</th>
                <th>Purchase date</th>
                <th>Full price</th>

            </tr>
            </thead>
            <c:forEach var="order" items="${requestScope.orders}" >
                <tr>
                    <td>${order.user.firstName} ${order.user.lastName}</td>
                    <td>${order.car.mark} ${order.car.model}</td>
                    <td>${order.purchaseDate}</td>
                    <td>${order.fullPrice}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>

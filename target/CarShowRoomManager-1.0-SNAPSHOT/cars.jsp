<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
    <header>
        <div class="header-intro">
            <div class="go-back">
                <img src="${pageContext.request.contextPath}/static/go-back.png" alt="not found">
            </div>
        </div>
    </header>
    <div class="main">
        <div class="table-container">
            <table class="cars-table">
                <thead>
                    <tr>
                        <th>Mark</th>
                        <th>Model</th>
                        <th>Engine</th>
                        <th>Release date</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <c:forEach var="car" items="${requestScope.cars}" >
                    <tr>
                        <td>${car.mark}</td>
                        <td>${car.model}</td>
                        <td>${car.engine}</td>
                        <td>${car.releaseDate}</td>
                        <td>${car.price}</td>
                        <td>${car.quantity}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="footer">

    </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link rel="stylesheet" href="/static/style.css">
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
                <tbody>
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
                </tbody>
            </table>
        </div>
    </div>
    <div class="footer">

    </div>
</body>
</html>

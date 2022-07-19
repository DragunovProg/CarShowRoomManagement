<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

</head>
<body>
    <header>
        <div class="header-intro">
            <div class="user-profile">
                <h4>${user.firstName} ${user.lastName}</h4>
            </div>
            <div class="user-nav">
                <ul>
                    <li><a id="employee-link" href="/employees?back=${homeURI}">Employees</a></li>
                    <li><a id="cars-link" href="/cars?back=${homeURI}">Cars</a></li>
                    <li><a id="orders-link" href="/orders?back=${homeURI}">Orders</a></li>
                    <li><a id="logout" href="${pageContext.request.contextPath}/logout">
                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                    </a></li>
                </ul>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="main-container">
            <div class="left-box">
                <table class="leaderboard-by-sales">
                    <caption class="sales-leaderboard">Sales Leaderboard</caption>
                    <thead>
                    <tr>
                        <th>Employee</th>
                        <th>Email</th>
                        <th>Sales</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="entry" items="${sales_leaderboard}">
                        <tr>
                            <td>${entry.key.lastName} ${entry.key.firstName}</td>
                            <td>${entry.key.email}</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="right-box">
                <table class="car-rating">
                    <caption class="car-rating-caption">Top 5 best selling cars</caption>
                    <thead>
                    <tr>
                        <th>Car</th>
                        <th>Price</th>
                        <th>Sales</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="entry" items="${car_rating}">
                        <tr>
                            <td>${entry.key.mark} ${entry.key.model} ${entry.key.releaseDate}</td>
                            <td>${entry.key.price}$</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="total-sales">
            <span class="sales">Total sales : ${all_sales}  </span>
        </div>
    </div>
    <div class="footer">

    </div>

</body>
</html>

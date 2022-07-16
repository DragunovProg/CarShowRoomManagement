<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
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
        <div class="home-container">
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
                <table class="leaderboard-by-currency">
                    <caption class="fullprice-leaderboard">Sales Leaderboard by price </caption>
                    <thead>
                    <tr>
                        <th>Employee</th>
                        <th>Email</th>
                        <th>Sales</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="entry" items="${full_price_leaderboard}">
                        <tr>
                            <td>${entry.key.lastName} ${entry.key.firstName}</td>
                            <td>${entry.key.email}</td>
                            <td>${entry.value}$</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="footer">

    </div>
</body>
</html>

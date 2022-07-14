
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
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
                </ul>
            </div>
        </div>
    </header>
    <div class="main">
        Hello ${user.email}
    </div>
    <div class="footer">

    </div>
</body>
</html>

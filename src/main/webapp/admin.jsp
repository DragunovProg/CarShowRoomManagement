
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
        Hello ${user.email}
    </div>
    <div class="footer">

    </div>
</body>
</html>

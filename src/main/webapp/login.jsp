<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
    <header>
        <div class="header_into">

        </div>
    </header>
    <div class="main">
        <div class="login-form">
            <form method="post" class="login">
                <div><input type="email" name="email" placeholder="Enter a email"></div>
                <div><input type="password" name="password" placeholder="Enter a password"></div>
                <div><input type="submit" value="Sign In"></div>
                <div>${error}</div>
            </form>
        </div>
    </div>
</body>
</html>

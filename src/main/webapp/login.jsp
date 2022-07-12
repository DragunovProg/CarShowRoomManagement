<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style><%@include file="static/style.css"%></style>
</head>
<body>
    <header>
        <div class="header_into">

        </div>
    </header>
    <div class="main">
        <div class="login-form">
            <form method="post" class="login">
                <div><input type="email" name="emailLogin" placeholder="Enter a email"></div>
                <div><input type="password" name="passwordLogin" placeholder="Enter a password"></div>
                <div><input type="submit" name="submitLogin" value="Sign In"></div>
                <div class="error">${error}</div>
            </form>
        </div>
    </div>
</body>
</html>

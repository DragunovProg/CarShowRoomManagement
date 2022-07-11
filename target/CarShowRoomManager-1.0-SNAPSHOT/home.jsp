<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 10.07.2022
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
    <header>
        <div class="header-intro">
            <div class="user-profile">
                <h4>${user.firstName} ${user.lastName}</h4>
            </div>
            <div class="user-nav">
                <ul>
                    <li>
                        <form method="post" class="cars-submit">
                            <input type="submit" value="Cars">
                        </form>
                    </li>
                    <li><form method="post" class="orders-submit">
                        <input type="submit" value="Orders">
                    </form>
                    </li>
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

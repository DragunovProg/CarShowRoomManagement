<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Car</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
    <header>
        <div class="header-intro">
            <div class="go-back">
                <a href="/cars?back=<%=request.getParameter("backurl")%>">
                    <img id="image-go-back" src="${pageContext.request.contextPath}/static/go-back.png" alt="not found">
                </a>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="form-container">
            <form method="post" class="edit">
                <div><input type="text" name="mark" value="${car.mark}"></div>
                <div><input type="text" name="model" value="${car.model}"></div>
                <div><input type="text" name="engine" value="${car.engine}"></div>
                <div><input type="date" name="releaseDate" value="${car.releaseDate}"></div>
                <div><input type="number" name="price" value="${car.price}"></div>
                <div><input type="number" name="quantity" value="${car.quantity}"></div>
                <div class="submit-car-edit"><input type="submit" name="editSubmit" value="Edit"></div>
            </form>
        </div>
    </div>
    <div class="footer">

    </div>
</body>
</html>

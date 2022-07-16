<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                        <th>Action</th>
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
                        <td>
                            <div class="action">
                                <a href="<c:url value='/update-car?id=${car.id}&backurl=${backUrl}'/>" class="edit-btn"><i class="fa fa-edit"></i></a>
                                <form class="delete-btn-form" action="<c:url value='/delete-car?id=${car.id}&backurl=${backUrl}'/>" method="post" >
                                    <button type="submit"  class="delete-btn"><i class="fa fa-trash"></i></button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="pagination-cars" class="pagenumbers"></div>
        <div class="add-form-container">
            <a href="<c:url value='/add?backurl=${backUrl}'/>" class="add-car">Add new Car</a>
        </div>
    </div>
    <div class="footer">

    </div>
    <script src="${pageContext.request.contextPath}/static/scripts/carPagination.js"></script>
</body>
</html>

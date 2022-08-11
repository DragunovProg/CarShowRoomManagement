<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <style><%@include file="static/style.css"%></style>
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
        <table class="order-table">
            <thead>
            <tr>
                <th>Employee</th>
                <th>Car</th>
                <th>Purchase date</th>
                <th>Full price</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach var="order" items="${requestScope.orders}" >
                <tr>
                    <td>${order.user.firstName} ${order.user.lastName}</td>
                    <td>${order.car.mark} ${order.car.model}</td>
                    <td>${order.purchaseDate}</td>
                    <td>${order.fullPrice}</td>
                    <td>
                        <a href="<c:url value='/edit-order?id=${order.id}&backurl=${backUrl}'/>" class="edit-btn"><i class="fa fa-edit"></i></a>
                        <form class="delete-btn-form" action="<c:url value='/delete-order?id=${order.id}&backurl=${backUrl}'/>" method="post" >
                            <button type="submit"  class="delete-btn"><i class="fa fa-trash"></i></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="pagination" class="pagenumbers"></div>
    <div class="add-form-container">
        <a href="<c:url value='/add-order?backurl=${backUrl}'/>" class="add-order">Add new Order</a>
    </div>
</div>
<div class="footer">

</div>
<script src="${pageContext.request.contextPath}/static/scripts/orderPagination.js"></script>
</body>
</html>

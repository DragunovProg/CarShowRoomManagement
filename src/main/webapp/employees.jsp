<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
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
            <table class="employees-table">
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${requestScope.employees}" >
                    <tr>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.email}</td>
                        <td>
                            <div class="action">
                                <form class="delete-btn-form" action="<c:url value='/delete-employee?id=${employee.id}&backurl=${backUrl}'/>" method="post" >
                                    <button type="submit"  class="delete-btn"><i class="fa fa-trash"></i></button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="pagination" class="pagenumbers"></div>
    </div>
    <div class="footer">

    </div>
    <script src="${pageContext.request.contextPath}/static/scripts/employeePagination.js"></script>
</body>
</html>

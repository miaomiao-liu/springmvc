<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-1-30
  Time: 下午4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
<body>

<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<c:if test="${empty requestScope.employees}">
没有任何员工信息
</c:if>
<c:if test="${!empty requestScope.employees}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${requestScope.employees}" var="emp">
            <tr>
                <th>${emp.id}</th>
                <th>${emp.lastName}</th>
                <th>${emp.email}</th>
                <th>${emp.gender == 0 ? 'female' : 'male'}</th>
                <th>${emp.department.departmentName}</th>
                <th><a href="emp/${emp.id}">Edit</a></th>
                <th><a class="delete" href="emp/${emp.id}">Delete</a></th>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br><br>
<a href="emp">Add New Employee</a>

</body>
</html>

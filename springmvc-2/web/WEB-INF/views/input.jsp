<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-1-30
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--数据类型转换--%>
<form action="testConversionServiceConverter" method="post">
    <%--格式为：lastname-email-gender-department.id---%>
    Employee: <input type="text" name="employee">
        <input type="submit" value="Submit">
</form>

<br><br>


<form:errors path="*"></form:errors>

<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">

    <%--如果id为空，则为添加employee，显示lastName--%>
    <c:if test="${employee.id == null}">
    <!--path属性对应html表单属性的name属性-->
    LastName：<form:input path="lastName"></form:input>
    </c:if>
    <c:if test="${employee.id != null}">
        <form:hidden path="id"></form:hidden>
        <input type="hidden" name="_method" value="PUT">
    </c:if>

    <br>
    Email：<form:input path="email"></form:input>
    <br>
    <%
        Map<String,String> genders = new HashMap<>();
        genders.put("1","Male");
        genders.put("0","FeMale");

        request.setAttribute("genders",genders);
    %>
    Gender：<form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
    <br>
    Department：<form:select path="department.id" items="${deparments}"
                            itemLabel="departmentName" itemValue="id"></form:select>
    <br>
    <%--
    1.数据类型转换
    2.数据类型格式化
    3.数据校验  ： 使用JSR 303 验证标准
                  加入hibernate validator 验证框架的jar包
                  在SpringMVC配置中加入<mvc:annotation-driven/>
                  需要在bean的属性上添加对应的注解
                  在目标方法 bean 类型的前面添加@Valid注解
    --%>
    Birth：<form:input path="birth"/>
    <br>
    Salary：<form:input path="salary"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>

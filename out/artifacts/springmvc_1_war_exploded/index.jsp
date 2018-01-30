<%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-1-26
  Time: 下午5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>



<a href="springmvc/testRedirect">Test Redirect</a>

<br><br>
<a href="springmvc/testView">Test View</a>

<br><br>
<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>

<br><br>
<!--
模拟修改操作：
1.原始数据为：1,Tom,123456,tom@atguigu.com,12
2.密码不能改
3.表单回显，模拟操作直接在填写表单对应的属性值
-->
<form action="springmvc/testModelAttribute" method="Post">
    <input type="hidden" name="id" value="1">
    username:<input type="text" name="username" value="Tom">
    <br>
    email:<input type="text" name="email" value="tom@atguigu">
    <br>
    age:<input type="text" name="age" value="12">
    <br>
    <input type="submit" value="submit">
</form>

<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>

<br><br>
<a href="springmvc/testMap">Test Map</a>

<br><br>
<a href="springmvc/testModelAndView">Test ModelAndView</a>

<br><br>
<a href="springmvc/testServletAPI">Test ServletAPI</a>

<br><br>
<form action="springmvc/testPojo" method="post">
    username:<input type="text" name="username">
    <br>
    password:<input type="password" name="password">
    <br>
    email:<input type="text" name="email">
    <br>
    age:<input type="text" name="age">
    <br>
    province:<input type="text" name="address.province">
    <br>
    city:<input type="text" name="address.city">
    <br>
    <input type="submit" name="submit">
</form>

<br><br>
<a href="springmvc/testCookieValue">Test CookieValue</a>

<br><br>
<a href="springmvc/testRequestHeader">Test RequestHeader</a>

<br><br>
<a href="springmvc/testRequestParam?username=atguigu&age=11">Test RequestParam</a>

<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="Test Rest PUT">
</form>

<br><br>
<form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Test Rest DELETE">
</form>

<br><br>
<form action="springmvc/testRest" method="post">
    <input type="submit" value="Test Rest Post">
</form>

<br><br>
<a href="springmvc/testRest/1">Test Rest Get</a>

<br><br>
<a href="springmvc/testPathVariable/1">Test PathVariable</a>

<br><br>
<a href="springmvc/testAntPath/mnxyz/abc">Test AntPath</a>

<br><br>
<a href="springmvc/testParamsAndHeaders?username=atguigu&age=11">Test ParamsAndHeaders</a>

<br><br>
<form action="springmvc/testMethod" method="post">
    <input type="submit" value="submit">
</form>

<br><br>
<a href="springmvc/testRequestMapping">Test RequestMapping</a>

<br><br>
<a href="helloworld">Hello World</a>

</body>
</html>

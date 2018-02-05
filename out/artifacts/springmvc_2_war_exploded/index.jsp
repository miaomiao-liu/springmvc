<%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-1-30
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="scripts/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#testJson").click(function () {
               var url = this.href;
               var args = {};
               $.post(url,args,function (data) {
                   for (var i = 0; i < data.length; i++){
                       var id = data[i].id;
                       var lastName = data[i].lastName;

                       alert(id + ":" +lastName);
                   }
               });
                return false;
            });
        })
    </script>
</head>
<body>


<form action="testFileUpload" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file">
    Desc:<input type="text" name="desc">
    <input  type="submit" name="Submit">
</form>

<a href="emps">List All Employees</a>
<br><br>

<a href="testJson" id="testJson">Test Json</a>
<br><br>

<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file">
    Desc:<input type="text" name="desc">
    <input  type="submit" name="Submit">
</form>
<br><br>

<a href="/testResponseEntity">Test ResponseEntity</a>
<br><br>

<a href="i18n">I18N PAGE</a>
<br><br>

<a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
<br><br>

<a href="testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
<br><br>

<a href="testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
<br><br>

<a href="testSimpleMappingExceptionResolve?i=2">Test SimpleMappingExceptionResolve</a>


</body>
</html>

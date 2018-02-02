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

<a href="emps">List All Employees</a>
<br><br>

<a href="testJson" id="testJson">Test Json</a>

</body>
</html>

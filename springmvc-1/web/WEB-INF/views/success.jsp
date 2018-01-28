<%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-1-26
  Time: 下午6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Success Page</h4>

time:${requestScope.time}
<br><br>

names:${requestScope.names}
<br><br>

request user:${requestScope.user}
<br><br>

session user:${sessionScope.user}
<br><br>

request school:${requestScope.school}
<br><br>

session school:${sessionScope.school}
<br><br>

</body>
</html>

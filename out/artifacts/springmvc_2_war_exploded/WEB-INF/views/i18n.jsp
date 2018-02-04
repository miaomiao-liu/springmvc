<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
 <%--
  Created by IntelliJ IDEA.
  User: miaomiao
  Date: 18-2-2
  Time: 下午5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:message key="i18n.user"></fmt:message>

<br><br>

<a href="i18n2">I18N2 PAGE</a>
<br><br>

<%--
通过超链接切换Locale（切换中英文）
在Springmvc配置文件中配置：SessionLocalResolver ， 配置LocaleChange]Interceptor
--%>
<a href="i18n?locale=zh_CN">中文</a>
<br><br>

<a href="i18n?locale=en_US">英文</a>

</body>
</html>

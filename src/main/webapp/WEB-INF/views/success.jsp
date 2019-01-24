<%--
  Created by IntelliJ IDEA.
  User: Yien
  Date: 2018/7/3
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>视图渲染成功</title>
</head>
<body>
<p>
    登录成功！欢迎您~：
    <%=request.getAttribute("user") %> <br>

</p>
</body>
</html>

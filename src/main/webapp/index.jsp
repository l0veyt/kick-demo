<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    主页 当前用户：${sessionScope.user.username}<hr/>
    <a href="${pageContext.request.contextPath}/showOnlineUsersServlet">查看在线用户</a>
</body>
</html>

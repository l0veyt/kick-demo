<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>显示在线用户</title>
  </head>
  <body>
    <c:if test="${empty map}">
    	没有登陆者
    </c:if>
    <c:if test="${!empty map}">
    	<c:forEach items="${map}" var="me">
    		${me.key}&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/kickServlet?username=${me.key}">踢出</a>
    	</c:forEach>
    </c:if>
  </body>
</html>

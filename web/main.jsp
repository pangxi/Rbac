<%--
  Created by IntelliJ IDEA.
  User: 庞小西
  Date: 2019/10/22
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<dl>
    <c:forEach items="${user.menus }" var="menu">
        <dt>${menu.name }</dt>
        <c:forEach items="${menu.children }" var="child">
            <dd>${child.name }</dd>
        </c:forEach>
    </c:forEach>
</dl>
<c:forEach items="${user.elements}" var="element">
    <c:if test="${element.eleno eq 'grant'}">
        <input type="button" name="garnt" value="授权"/>
    </c:if>
</c:forEach>
<input type="button" value="新增"/>
</body>
</html>

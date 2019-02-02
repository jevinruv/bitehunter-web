<%-- 
    Document   : chef_homepage
    Created on : Dec 30, 2017, 2:45:08 PM
    Author     : Jevin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


    <c:forEach items="${lists}" var="lists">
        ${lists}
    </c:forEach>

</body>
</html>

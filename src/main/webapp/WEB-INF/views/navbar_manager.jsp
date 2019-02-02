<%-- 
    Document   : navbar
    Created on : Nov 9, 2017, 8:35:24 PM
    Author     : Ludowica
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <c:choose>
            <c:when test="${(sessionScope.user.username != null) and  (sessionScope.user.userType == 'manager')}">

                <input type="hidden" id="restaurantId" value="${sessionScope.user.location}" />

                <br />
                <div class="col-sm-10">

                    <nav class="navbar navbar-inverse bg-faded" >
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li><a href="manage_reservations">Manage Reservation</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#">Restaurant Id: <c:out value="${sessionScope.user.location}"/></a></li>

                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                        <span class="glyphicon glyphicon-user"></span>
                                        <c:out value="${sessionScope.user.username}"/>
                                        <span class="caret"></span> </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </nav>

                </div>
            </c:when>

            <c:otherwise>
                <c:redirect url = "not_logged"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>

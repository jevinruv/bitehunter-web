<%-- 
    Document   : navbar_admin
    Created on : Nov 9, 2017, 8:35:24 PM
    Author     : Jevin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body onload="startTime()">

        <c:choose>
            <c:when test="${(sessionScope.user.username != null) and (sessionScope.user.userType == 'admin')}">

                <input type="hidden" id="restaurantId" value="${sessionScope.user.location}" />

                <br />
                <div class="col-sm-10">

                    <nav class="navbar navbar-inverse bg-faded" >
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li><a href="#">Time : 11:12:25 </a></li>
                                <li><a href="#">Manage Reservation</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
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


        <script>
            function startTime() {
                var today = new Date();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                document.getElementById('txt').innerHTML =
                        h + ":" + m + ":" + s;
                var t = setTimeout(startTime, 500);
            }
            function checkTime(i) {
                if (i < 10) {
                    i = "0" + i
                }
                ;  // add zero in front of numbers < 10
                return i;
            }
        </script>
    </body>
</html>

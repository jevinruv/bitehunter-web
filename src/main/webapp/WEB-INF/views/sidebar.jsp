<%-- 
    Document   : sidebar
    Created on : 13-Oct-2017, 20:14:29
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="col-sm-2 sidenav hidden-xs" >
            <img src="<c:url value="/resources/images/bitehunter_logo.png" />" alt="Bitehunter" style="width:50%;" class="w3-round"><br><br>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="home"><span class="glyphicon glyphicon-home"> Home</span> </a></li>
                <li><a href="#"><span class="glyphicon glyphicon-home"> Menus</span> </a></li>
                <li><a href="add_floor_plan"><span class="glyphicon glyphicon-home"> Foorplans</span></a></li>

            </ul><br>
        </div>


        
    </body>
</html>

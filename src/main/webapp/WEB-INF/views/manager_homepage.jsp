<%-- 
    Document   : manager_homepage
    Created on : Nov 6, 2017, 9:17:13 AM
    Author     : Jevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bitehunter</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet" >
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>

    </head>
    <body>


        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_manager.jsp" %>

                <div class="row">
                    <div class="col-sm-5">
                        <div class="well">

                        </div>
                    </div>

                    <div class="col-sm-4">
                        <div class="well">
                            second container 
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>

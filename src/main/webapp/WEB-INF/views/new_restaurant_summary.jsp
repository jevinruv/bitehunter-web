<%-- 
    Document   : new_restaurant_summary
    Created on : Jan 23, 2018, 11:29:06 PM
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
                <%@ include file="navbar_admin.jsp" %>

                <div class="row">
                    <div class="col-sm-7">
                        <div class="well">
                            <h3>Restaurant Summary</h3><br>

                            <form method="POST" class="form-horizontal" action="new_restaurant_save_final">   

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Name</label>
                                    <div class="col-sm-8">
                                        <c:out value="${sessionScope.restaurantDetails.restaurantName}"/>    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2">Table Count</label>
                                    <div class="col-sm-4">
                                        <c:out value="${sessionScope.restaurantDetails.tableCount}"/>     
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Time Open</label>
                                    <div class="col-sm-4">
                                        <c:out value="${sessionScope.restaurantDetails.timeOpen}"/>  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Time Close</label>
                                    <div class="col-sm-4">
                                        <c:out value="${sessionScope.restaurantDetails.timeClose}"/>       
                                    </div>
                                </div>


                                <div class="form-group">        
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-success">Save Restaurant</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>

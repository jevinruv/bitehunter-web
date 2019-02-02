<%-- 
    Document   : new_restaurant
    Created on : Jan 15, 2018, 7:44:06 PM
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

                    <form:form 
                        class="form-horizontal"
                        method="POST" 
                        action="new_restaurant_save" 
                        modelAttribute="restaurantDetails"
                        enctype="multipart/form-data">

                        <div class="col-sm-6">
                            <div class="well">
                                <h3>New Restaurant Details</h3><br>


                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Name</label>
                                    <div class="col-sm-4">
                                        <form:input type="text" path="restaurantName" required="required" class="form-control" placeholder="Restaurant Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2">Table Count</label>
                                    <div class="col-sm-4">
                                        <form:input type="number" path="tableCount" required="required" class="form-control" placeholder="Table Count" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Time Open</label>
                                    <div class="col-sm-4">
                                        <form:input type="time" path="timeOpen" required="required" class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Time Close</label>
                                    <div class="col-sm-4">
                                        <form:input type="time" path="timeClose" required="required" class="form-control" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2">Image</label>
                                    <input type="file" id="file" name="file" required="required" />
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2">Description</label>
                                    <form:textarea path="restaurantDescription" required="required" rows="3" cols="28" id="description"/>
                                </div>

                                <div class="form-group">        
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-success">Submit</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </body>
</html>

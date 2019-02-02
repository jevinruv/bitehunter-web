<%-- 
    Document   : manager_reservations
    Created on : Nov 6, 2017, 7:17:13 AM
    Author     : Jevin
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bitehunter </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>" >
        <link href="<c:url value="/resources/css/table_styles.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">




    </head>
    <body onload="initData()">


        <!-- /*Navigation Bar*/ -->
        <div class="container-fluid">
            <div class="row content">

                <%@ include file="sidebar.jsp" %>
                <br>
                <%@ include file="navbar_manager.jsp" %>

                <!-- /*Update Table Status*/ -->
                <div class="row">
                    <div class="col-sm-5">
                        <div class="well">
                            <form action="UpdateTableServlet" method="POST" target="hiddenFrame" >

                                <h4>Update Reservation Status</h4>
                                <!-- Search <input type="text" name="search_id"  /> <br>-->

                                Table ID &nbsp;&nbsp;&nbsp;&nbsp; 
                                <select id="input_table_id" name="input_table_id" class="btn btn-primary dropdown-toggle">
                                    <option>Select</option>
                                </select>
                                &nbsp;
                                <input type="submit" class="btn btn-success" value="Vacant" id="button" name="buttonPressed" onclick="changeTableStateManual('table_vacant')" />
                                &nbsp;
                                <input type="submit" class="btn btn-danger" value="Reserved" id="button" name="buttonPressed" onclick="changeTableStateManual('table_reserved')" />

                            </form>
                        </div>

                        <div class="well">
                            <h4> Reservations </h4>
                            <table  id="myTable" class="table table-bordered table-striped table-hover">
                                <thead >
                                    <tr>
                                        <th>Resv ID</th>
                                        <th>Name</th>
                                        <th>Table ID</th>
                                        <th>Check In</th>
                                        <th>Check Out</th>
                                    </tr>
                                </thead>
                                <tbody  class="data"></tbody >
                            </table>
                        </div>
                    </div>
                    <!-- /* End Update Table Status*/ -->

                    <div class="floor_plan">
                        <div class="table_vacant" id="t1">T1</div>
                        <div class="table_vacant" id="t2">T2</div>
                        <div class="table_vacant" id="t3">T3</div>
                        <div class="table_vacant" id="t4">T4</div>
                        <div class="table_vacant" id="t5">T5</div>
                        <div class="table_vacant" id="t6">T6</div>
                        <div class="table_vacant" id="t7">T7</div>
                        <div class="table_vacant" id="t8">T8</div>
                        <div class="table_vacant" id="t9">T9</div>
                        <div class="table_vacant" id="t10">T10</div>
                        <div class="table_vacant" id="t11">T11</div>
                        <div class="table_vacant" id="t12">T12</div>
                        <div class="table_vacant" id="t13">T13</div>
                        <div class="table_vacant" id="t14">T14</div>
                        <div class="table_vacant" id="t15">T15</div>
                    </div>

                    <!-- /*End of Tables*/ -->

                </div>

            </div>
        </div>

        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/manageReservations.js" />"></script>

    </body>
</html>

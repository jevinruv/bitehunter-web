var host = 'http://bitehunter.vimly.ml/database_operations/';
var HOSTURL = 'http://bitehunter.vimly.ml/database_operations/webapp/';
var restaurantId; //restaurant id 
var reservationTableName;

// get data from the database and call addTableID(), loadTablePositions()
function initData_viewReservations(thisrestaurantId) {
    restaurantId = thisrestaurantId; //restaurant id set 

    getRestaurantDetails();
    getTablePositions();

}

function getTablePositions() {
    $.ajax({
        url: HOSTURL + 'get_table_positions.php',
        type: 'POST',
        data: {restaurant_id: restaurantId},
        dataType: 'json',
        success: function (rows)
        {
            var tablesJson = rows['table_data'];

            for (var i in tablesJson)
            {
                var row = tablesJson[i];

                var table_id = row['table_id'];
                var left_margin = row['left_margin'];
                var top_margin = row['top_margin'];

                addTableID(table_id);
                loadTablePositions(table_id, left_margin, top_margin);
            }
        },
        error: function (request, status, error) {
            alert("Error: " + status);
        }
    });

//    setInterval(getReservedTables, 1000);
    setInterval(getReservedTables, 1000);
    setInterval(getReservationDetails, 1000); // check every 1 sec
}

function getRestaurantDetails() {
    $.ajax({
        url: HOSTURL + 'get_restaurant_details.php',
        type: 'POST',
        data: {restaurant_id: restaurantId},
        dataType: 'json',
        success: function (row)
        {
            reservationTableName = row['reservation_table_name'];

        },
        error: function (request, status, error) {
            alert("Error: " + status);
        }
    });
}

//add tableid to options
function addTableID(table_id) {
    var select = document.getElementById("input_table_id");
    var opt = table_id;
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    select.appendChild(el);
}

function getAllTableId() {
    var x = document.getElementById("input_table_id");

    var txt;
    for (var i = 1; i < x.length; i++) {
        txt = x.options[i].text;
    }

    alert(txt);
}

//load table positions from the database & assigns
function loadTablePositions(table_id, left_margin, top_margin) {
    var vtable_id = document.getElementById(table_id);
    vtable_id.style.display = 'block'; //set tables visible
    vtable_id.style.left = (left_margin) + "px";
    vtable_id.style.top = (top_margin) + "px";
}

// change table state from reserve to vacant & vice versa
function changeTableStateManual(state) {

    var e = document.getElementById("input_table_id");
    var id = e.options[e.selectedIndex].value;

    if (id == "Select") {
        alert("Select Table ID");
    } else {
        var table = document.getElementById(id);
        table.className = state;
    }
}


function changeTableStateAuto(reservedTableList) {

    /* reset table state to vacant  */
    var x = document.getElementById("input_table_id");
    for (var i = 1; i < x.length; i++) {
        var id = x.options[i].text;

        var table_id = document.getElementById(id);
        table_id.className = "table_vacant";
    }

    /*  table state to reserved  */
    if (reservedTableList != null) {
        for (var j = 0; j < reservedTableList.length; j++) {
            var table_id = document.getElementById(reservedTableList[j]);
            table_id.className = "table_reserved";
        }
    }
}




function getReservedTables() {
    $.ajax({
        url: HOSTURL + 'get_reserved_tables_real_time.php',
        type: 'POST',
        data: {reservation_table_name: reservationTableName},
        dataType: 'json',
        success: function (rows)
        {
            var tableList = [];

            if (rows['success'] == 1) {
                var tablesJson = rows['table_list'];

                for (var i in tablesJson)
                {
                    var row = tablesJson[i];
                    var table_id = row['table_id'];
                    tableList.push(table_id);
                }
                changeTableStateAuto(tableList);
            } else {
                changeTableStateAuto(null);
            }
        },
        error: function (request, status, error) {
            // alert("Error: " + status);
        }
    });
}

function setVacantTable() {
    $.ajax({
        url: host + 'get_reserved_tables_real_time.php',
        type: 'POST',
        data: {restaurant_id: restaurantId},
        dataType: 'json',
        success: function (rows)
        {
            if (rows['success'] == 1) {
                var tablesJson = rows['table_list'];

                for (var i in tablesJson)
                {
                    var row = tablesJson[i];
                    var table_id = row['table_id'];

                    changeTableStateAuto(table_id);
                }
            } else {
                changeTableStateAuto(null);
            }
        },
        error: function (request, status, error) {
            // alert("Error: " + status);
        }
    });
}

function getReservationDetails() {

    $.ajax({
        url: HOSTURL + 'get_reservation_details_real_time.php',
        type: 'POST',
        data: {reservation_table_name: reservationTableName},
        dataType: 'json',
        success: function (rows)
        {
            var reservation_list = rows['reservation_list'];
            //$("tbody").children().remove()

            var html = "";
            var t = document.getElementById("myTable");
            //t.style.display = 'inline-block';

            for (var i in reservation_list)
            {
                var row = reservation_list[i];

                var res_id = row["res_id"];
                var cus_name = row["cus_name"];
                var table_id = row["table_id"];
                var checkin = row["checkin"];
                var checkout = row["checkout"];

                html += "<tr>";
                html += "<td>" + res_id + "</td>";
                html += "<td>" + cus_name + "</td>";
                html += "<td>" + table_id + "</td>";
                html += "<td>" + checkin + "</td>";
                html += "<td>" + checkout + "</td>";
                html += "</tr>";
            }
            $(".data").html(html);

        },
        error: function (request, status, error) {
            alert("Status: " + status);
            //alert("Error message: " + error); 
        }
    });

}
var host = 'http://bitehunter.vimly.ml/database_operations/webapp/';

function initUpdateFloorplan(restaurantId) {

    $.ajax({
        url: host + 'get_table_positions.php',
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
                loadTablePositions(table_id, left_margin, top_margin);
                addRow(table_id, left_margin, top_margin);
            }
        },
        error: function (request, status, error) {
            alert("Error: " + status);
        }
    });
}

$('#myTable').on('click', '.apply', function () {

    var tableID = $(this).closest('tr').find('.tableID').val();
    var topMargin = $(this).closest('tr').find('.topMargin').val();
    var leftMargin = $(this).closest('tr').find('.leftMargin').val();

    loadTablePositions(tableID, leftMargin, topMargin);
});

$('#myTable').on('click', '.delete', function () {

    $(this).closest('tr').remove();
});

//load table positions from the database & assigns
function loadTablePositions(table_id, left_margin, top_margin) {
    var vtable_id = document.getElementById(table_id);
    vtable_id.style.display = 'block'; //set tables visible
    vtable_id.style.left = (left_margin) + "px";
    vtable_id.style.top = (top_margin) + "px";
}



function saveDetails_updateFloorplan() {

    var tableData = new Array();
    var fullData = new Array();
    var emptyCount = 0;


    $('tr').each(function () {
        if (
                $(this).find('.tableID').val() === "" ||
                $(this).find('.leftMargin').val() === "" ||
                $(this).find('.topMargin').val() === ""
                )
        {
            emptyCount++;
        }
    });


    if (emptyCount > 0) {
        alert("Floorplan Table is Empty");
    } else {
        $('#myTable tr').each(function (row, tr) {
            tableData[row] = {
                "tableID": $(tr).find('.tableID').val()
                , "leftMargin": $(tr).find('.leftMargin').val()
                , "topMargin": $(tr).find('.topMargin').val()
            };
        });
        tableData.shift();  // first row is the table header - so remove
        tableData.shift();  // shift again to fill 0 element

        fullData = JSON.stringify(tableData);
        document.getElementById("floorplan").value = fullData;
    }
}




function addRow(table_id, left_margin, top_margin) {
    $('#myTable').append("<tr>\n\
                            <td><input type='text' value='" + table_id + "' style='width:40px;' class='tableID' /></td>\n\
                            <td><input type='text' value='" + top_margin + "'style='width:50px; ' class='topMargin' /> px </td>\n\
                            <td><input type='text' value='" + left_margin + "'style='width:50px; ' class='leftMargin' /> px </td>\n\
                            <td><input type='button' value='Apply' class='btn btn-success apply'/>\n\
                             &nbsp; <input type='button' value='Delete' class='btn btn-danger delete'/></td>\n\
                         </tr>");

}


function addNewRow_updateFloorplan() {
    $('#myTable').append('<tr>\n\
                            <td><input type="text" style="width:40px;" class="tableID" /></td>\n\
                            <td><input type="text" style="width:50px;" class="topMargin" /> px </td>\n\
                            <td><input type="text" style="width:50px;" class="leftMargin" /> px </td>\n\
                            <td><input type="button" value="Apply" class="btn btn-success apply"/>\n\
                            &nbsp; <input type="button" value="Delete" class="btn btn-danger delete"/></td>\n\
                         </tr>');
}

// apply values when pressed enter
$(document).keypress(function (e) {
    if (e.which === 13) {
        $('.apply').click();
    }
});

function formSubmit_updateFloorplan() {
    var floorplan = document.getElementById("floorplan").value;

    if (floorplan === "") {
        alert("Please Click Save First");
        return false;
    }
    return true;
}

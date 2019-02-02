function initAddFloorplan() {
    var elms = document.querySelectorAll("[class='table_vacant']");

    for (var i = 0; i < elms.length; i++)
        elms[i].style.display = 'inline-block';
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



function addNewRow_addFloorplan() {
    $('#myTable').append('<tr>\n\
                            <td><input type="text" style="width:40px;" class="tableID" required="required"/></td>\n\
                            <td><input type="text" style="width:50px;" class="topMargin" required="required"/> px </td>\n\
                            <td><input type="text" style="width:50px;" class="leftMargin" required="required"/> px </td>\n\
                            <td><input type="button" value="Apply" class="btn btn-success apply"/>\n\
                            &nbsp; <input type="button" value="Delete" class="btn btn-danger delete"/></td>\n\
                         </tr>');
}


function saveDetails_addFloorplan() {

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
                "tableID": $(tr).find('.tableID').val(),
                "leftMargin": $(tr).find('.leftMargin').val(),
                "topMargin": $(tr).find('.topMargin').val()
            };
        });
        tableData.shift();  // first row is the table header - so remove
        fullData = JSON.stringify(tableData);

        document.getElementById("hiddenArrayField").value = fullData;
    }
}



// apply values when pressed enter
$(document).keypress(function (e) {
    if (e.which === 13) {
        $('.apply').click();
    }
});
//load table positions 
function loadTablePositions(table_id, left_margin, top_margin) {
    var vtable_id = document.getElementById("t" + table_id);
    //  vtable_id.style.display = 'block'; //set tables visible
    vtable_id.style.left = (left_margin) + "px";
    vtable_id.style.top = (top_margin) + "px";
//    vtable_id.className = table_vacant;
}

function formSubmit_addFloorplan() {
    var hiddenArrayField = document.getElementById("hiddenArrayField").value;
    if (hiddenArrayField === "") {
        alert("Please Click Save First");
        return false;
    }
    return true;
}
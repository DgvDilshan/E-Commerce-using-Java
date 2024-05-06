$(document).ready(function() {
    function fetchOrders() {
        $.ajax({
            url: contextPath + '/OrderServlet',
            type: 'GET',
            dataType: 'json',
            success: function(orders) {
                console.log(orders);
                var tbody = $('#ordersTableBody');
                tbody.empty();

                if (orders.length === 0) {
                    tbody.append('<tr><td colspan="6" class="text-center">No orders available</td></tr>');
                } else {
                    $.each(orders, function(index, order) {
                        var row = $('<tr>');
                        row.append($('<td>').text(order.orderCode));
                        row.append($('<td>').text(order.userName));
                        row.append($('<td>').text('$' + order.total.toFixed(2)));
                        row.append($('<td>').html('<span class="'+ getStatusBadgeClass(order.status) + '">' + order.status + '</span>'));
                        row.append($('<td>').text(order.date));
                        tbody.append(row);
                    });
                }
            },
            error: function() {
                alert('Error fetching orders.');
            }
        });
    }

    function getStatusBadgeClass(status) {
        switch (status) {
            case 'Received':
                return 'alert-success';
            case 'Cancelled':
                return 'alert-danger';
            case 'Pending':
                return 'alert-warning';
            default:
                return '';
        }
    }
    
    fetchCategories();
    fetchProducts();
    fetchOrders();
});

var editMode = false;

function addProduct(){
    event.preventDefault();
    var formData = new FormData($('#addProductForm')[0]);
    
    var fileInput = $('#pro_img')[0];
    var fileName = "";
    if (fileInput.files.length > 0) {
        fileName = fileInput.files[0].name;
    } else {
        console.log("No file selected");
    }

    formData.append('pro_img', fileName);

    $.ajax({
        type: "POST",
        url: contextPath + "/AddProductServlet",
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            $("#loadingIndicator").hide();
            alert(response);
        }
    });
    return false;
}

function deleteProduct(proId){
    $.ajax({
        url: contextPath + '/RemoveProductsServlet',
        type: 'POST',
        data: {proId: proId},
        success: function(response){
            alert(response);
            location.reload();
            
        },
        error: function(){
            alert("Error Deleting category");
        }
    });
}


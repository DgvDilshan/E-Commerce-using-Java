$(document).ready(function() {
    function fetchProducts() {
    $.ajax({
        url: contextPath + '/ProductsServlet',
        type: 'GET',
        dataType: 'json',
        success: function(products) {
            populateProductGrid(products);
        },
        error: function() {
            alert('Error fetching products.');
        }
    });
}

    function populateProductGrid(products) {
        var productGrid = $('#productGrid');
        productGrid.empty();

        if (products.length === 0) {
            productGrid.append('<div class="col"><p>No products available</p></div>');
        } else {
            $.each(products, function(index, product) {
                var card = $('<div>').addClass('col');
                var cardBody = $('<div>').addClass('card-body text-center');

                var img = $('<img>').addClass('img-fluid mb-3').attr('src', contextPath + '/uploads/' + product.proImg).attr('alt', '');
                var title = $('<h6>').addClass('product-title').text(product.proName);
                var price = $('<p>').addClass('product-price fs-5 mb-1').html('<span>$' + product.proPrice + '</span>');
                var rating = $('<div>').addClass('rating mb-0');

                for (var i = 0; i < Math.round(product.proReviews); i++) {
                    rating.append('<i class="bi bi-star-fill text-warning"></i>');
                }
                var reviews = $('<small>').text(product.proReviews + ' Reviews');

                var actions = $('<div>').addClass('actions d-flex align-items-center justify-content-center gap-2 mt-3');
                var editButton = $('<button>').addClass('btn btn-sm btn-outline-primary').attr('onclick', 'editProduct('+ product.proId +')').html('<i class="bi bi-pencil-fill"></i> Edit');
                var deleteButton = $('<button>').addClass('btn btn-sm btn-outline-danger').attr('onclick', 'deleteProduct('+ product.proId +')').html('<i class="bi bi-trash-fill"></i> Delete');

                actions.append(editButton);
                actions.append(deleteButton);

                cardBody.append(img);
                cardBody.append(title);
                cardBody.append(price);
                cardBody.append(rating);
                cardBody.append(reviews);
                cardBody.append(actions);

                card.append(cardBody);
                productGrid.append(card);
            });
        }
    }
    
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

function editProduct(proId) {
    window.location.href = contextPath + '/admin/editProduct.jsp?proId=' + proId;
}

function changeImage(){
    event.preventDefault();
    var imgInput = $('#image_input');
    var imageBox = $('#image_box');
    imageBox.addClass('hidden');
    imgInput.removeClass('hidden');
    imgInput.addClass('active');
}

function cancelImageChange(){
    event.preventDefault();
    var imgInput = $('#image_input');
    var imageBox = $('#image_box');
    imgInput.removeClass("active");
    imgInput.addClass("hidden");
    imageBox.removeClass("hidden");
    imageBox.addClass("active");    
}

function updateProduct(){
    event.preventDefault();
    var formData = $("#editProductForm").serialize();
    var proNewImg = $("#pro_img").val();
    
    if (proNewImg) {
        formData += "&pro_img=" + proNewImg;
    } else {
        var proImg = $("#img_input").val();
        formData += "&pro_img=" + proImg;
    }


    $.ajax({
        type: "POST",
        url: contextPath + "/UpdateProductsServlet",
        data: formData,
        success: function(response) {
            window.location.href = contextPath +'/admin/products.jsp';
       }
    });
    return false;
}




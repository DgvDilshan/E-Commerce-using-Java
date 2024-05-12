//Add Category
function addCategory(){
    var formData = $("#categoryForm").serialize();
    $.ajax({
        type: "POST",
        url: contextPath + "/AddCategoryServlet",
        data: formData,
        success: function(response) {
            $("#loadingIndicator").hide();
            alert(response);
        }
    });
    return false;
}

//Delete Category
function deleteCategory(catId){
    $.ajax({
        url: contextPath + '/DeleteServlet',
        type: 'POST',
        data: {catId: catId},
        success: function(response){
            alert(response);
            location.reload();
            
        },
        error: function(){
            alert("Error Deleting category");
        }
    })
}


//Switch add category to Edit Category
var editMode = false;

function switchMode(catId) {
    editMode = !editMode;
    var buttonText = editMode ? "Edit Category" : "Add Category";
    var onClickFunction = editMode ? "updateCategory()" : "addCategory()";
    $("#catBtn").text(buttonText).attr("onclick", onClickFunction);
}

//Get Edit Category Data
function editCategory(catId) {
    $.ajax({
        url: contextPath + '/GetCategoryServlet',
        type: 'GET',
        data: { catId: catId },
        dataType: 'json',
        success: function(category) {
            console.log(category);
            var catId = category[0].catId;
            var catName = category[0].catName;
            var catSlug = category[0].catSlug;
            $('#catId').val(catId);
            $('#catName').val(catName);
            $('#catSlug').val(catSlug);
            switchMode(catId);
        },
        error: function() {
            alert('Error fetching category data.');
        }
    });
}

//Update category
function updateCategory(){
    var formData = $("#categoryForm").serialize();
    
    $.ajax({
        type: "POST",
        url: contextPath + "/UpdateCategoryServlet",
        data: formData,
        success: function(response) {
            $("#loadingIndicator").hide();
            alert(response);
        }
    });
    return false;
}



$(document).ready(function() {
    //Display Categories
    function fetchCategories() {
        $.ajax({
        url: contextPath + '/CategoriesServlet',
        type: 'GET',
        dataType: 'json',
        success: function(categories) {
            var tbody = $('#categoriesTableBody');
            var dropdown = $('#pro_cat');
            tbody.empty(); 
            
            if (categories.length === 0) {
                tbody.append('<tr><td colspan="5" class="text-center">No categories available</td></tr>');
            } else {
                $.each(categories, function(index, category) {
                    var row = $('<tr>').addClass('category-row').attr('data-cat-id', category.catId);
                    row.append($('<td>').addClass('cat-id').text(category.catId));
                    row.append($('<td>').addClass('cat-name').text(category.catName));
                    row.append($('<td>').addClass('cat-slug').text(category.catSlug));
                    row.append($('<td>').addClass('cat-order').text(category.catOrder));
                    row.append($('<td>').addClass('action').html(
                        '<div class="d-flex align-items-center gap-3 fs-6">' +
                        '<button class="text-warning edit-info" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Edit info" aria-label="Edit" onclick="editCategory(' + category.catId + ')"><img src="../assets/images/icons/edit.png"/></button>' +
                        '<button class="text-danger delete-category" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Delete" aria-label="Delete" onclick="deleteCategory(' + category.catId + ')"><img src="../assets/images/icons/trash.png"/></button>' +
                        '</div>'
                    ));
                    tbody.append(row);
                    
                    dropdown.append($('<option>').text(category.catName).val(category.catId));
                });
            }
        },
        error: function() {
            alert('Error fetching categories.');
        }
        });
    }
    
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
            url: contextPath + '/OrdersServlet',
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




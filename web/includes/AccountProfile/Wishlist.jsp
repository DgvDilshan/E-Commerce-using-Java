<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Wishlist</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        #wishlist-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 20px;
        }
        .wishlist-item {
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 10px;
            padding: 10px;
            width: 200px;
            text-align: center;
        }
        .wishlist-item img {
            width: 100px;
            height: 100px;
            margin-bottom: 10px;
        }
        .wishlist-item button {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .wishlist-item button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Wishlist</h1>
    <div id="wishlist-container">
        <!-- Wishlist products will be loaded here dynamically -->
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            fetchWishlist();
        });

        function fetchWishlist() {
            $.ajax({
                url: 'WishlistServlet',
                type: 'GET',
                dataType: 'json',
                success: function (products) {
                    $('#wishlist-container').empty();
                    products.forEach(function (product) {
                        var productHtml = '<div class="wishlist-item">' +
                            '<img src="' + product.proImage + '" alt="' + product.proName + '">' +
                            '<h3>' + product.proName + '</h3>' +
                            '<p>$' + product.proPrice + '</p>' +
                            '<button onclick="addToCart(' + product.proId + ')">Add to Cart</button>' +
                            '<button onclick="removeFromWishlist(' + product.proId + ')">Remove</button>' +
                            '</div>';
                        $('#wishlist-container').append(productHtml);
                    });
                }
            });
        }

        function addToCart(productId) {
            // Implement adding the product to the cart
        }

        function removeFromWishlist(productId) {
            // Implement removing the product from the wishlist
            
            
        }
        
        
        $(document).ready(function () {
    fetchWishlist();
});

function fetchWishlist() {
    $.ajax({
        url: 'WishlistServlet',
        type: 'GET',
        dataType: 'json',
        success: function (wishlistItems) {
            $('#wishlist-container').empty();
            wishlistItems.forEach(function (item) {
                var productHtml = '<div class="wishlist-item">' +
                    '<img src="' + item.pro_image + '" alt="' + item.pro_name + '">' +
                    '<h3>' + item.pro_name + '</h3>' +
                    '<p>$' + item.price + '</p>' +
                    '<button onclick="addToCart(' + item.pro_id + ')">Add to Cart</button>' +
                    '<button onclick="removeFromWishlist(' + item.wishlist_id + ')">Remove</button>' +
                    '</div>';
                $('#wishlist-container').append(productHtml);
            });
        }
    });
}

function addToCart(productId) {
    // Implement the logic to add the product with productId to the cart
    // For example, you can send an AJAX request to a servlet to add the product to the cart
    // You can also perform any other necessary actions, such as updating the UI to reflect the addition
    alert('Product added to cart: ' + productId);
}

function removeFromWishlist(wishlistId) {
    $.ajax({
        url: 'RemoveFromWishlistServlet',
        type: 'POST',
        data: {wishlist_id: wishlistId},
        success: function (response) {
            alert(response);
            fetchWishlist(); // Reload wishlist after removal
        }
    });
}

    </script>
</body>
</html>

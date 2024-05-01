<%-- 
    Document   : cart_sidebar
    Created on : Apr 30, 2024, 2:50:49 AM
    Author     : Anush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1"/>
    <link rel="stylesheet" type="text/css" href="../css/cartsidebar.css">
    <title>E commerce side cart</title>
</head>
<body>
    <!-- Open Btn -->
    <button id="open_cart_btn">
        <img src="../assets/icons/cart.svg" alt="" style="width: 30px;">
    </button>

    <!-- Items -->
    <div class="items"></div>
    
    <!-- backdrop -->
    <div class="backdrop"></div>
    <!-- Side Cart -->
    <div id="sidecart" class="sidecart">
        <div class="cart_content">
            <!-- Cart Header -->
            <div class="cart_header">
                <img src="../assets/icons/cart.svg" alt="" style="width: 30px">
                <div class="header_title">
                    <h2>Your cart</h2>
                    <span id="items_num">2</span>
                </div>
                <span id="close_btn" class="close_btn">&times;</span>
            </div>
            <!-- Cart Items -->
            <div class="cart_items"></div>
            <!-- Cart Actions -->
            <div class="cart_actions">
                <div class="subtotal">
                    <p>SUBTOTAL: $<span id="subtotal_price">0.00</span></p>
                </div>
                <button>View cart</button>
                <button>Checkout</button>
            </div>
        </div>
    </div>
    <!-- Script -->
    <script src="cartsidebar.js" defer></script>
</body>
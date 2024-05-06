//Profile DropDown
window.toggleProfileDropdown = function(){
    var profileDropdown = document.getElementById("profile-dropdown");
    profileDropdown.classList.toggle("active");
};

//Search Toggle
window.toggleSearch = function(){
    var searchWrapper = document.getElementById("search-wrapper");
    searchWrapper.classList.toggle("active");
};

//Mobile Nav Toggle
window.openMobileNav = function() {
    var mobileNav = document.getElementById("mobile-nav");
    mobileNav.classList.add("active");
};
window.closeMobileNav = function() {
    var mobileNav = document.getElementById("mobile-nav");
    mobileNav.classList.remove("active");
};

function togglePasswordVisibility() {
    event.preventDefault();
    var passwordInput = document.getElementById("passwordInput");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
 }
 

 function validatePassword(password) {
    if(password.length < 8){
        return false;
    }
     if (!/[A-Z]/.test(password)) {
         return false;
     }
     if (!/\d/.test(password)) {
         return false;
     }
     if (!/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(password)) {
         return false;
     }
     return true;
}

function signUp(){
    event.preventDefault();
    
    var firstName = $("#signup-fname").val();
    var lastName = $("#signup-lname").val();
    var email = $("#signup-email").val();
    var password = $("#passwordInput").val();
    var phoneNumber = $("#signup-pno").val();
    var agreement = $("#signup-terms").prop("checked");
    
    if (firstName.length === 0 || lastName.length === 0 || email.length === 0 || password.length === 0 || phoneNumber.length === 0 || !agreement) {
        alert("Please fill in all fields and agree to the terms.");
        return;
    }
    if (!validatePassword(password)) {
        alert("Password must be at least 8 characters long and contain at least one uppercase letter, one digit, and one special character.");
        return;
    }
    var formData = $("#signup-form").serialize();
    
    $.ajax({
        type: "POST",
        url: "SignupServlet",
        data: formData,
        success: function (response) {
            alert(response);
            if(response === "Successfully Registered"){
                window.location.href = "signin.jsp";
            }

        },
        error: function (xhr, status, error) {
            alert("Error occurred: " + error);
        }
    });
        
}

function signIn(){
    event.preventDefault();
    
    var email = $('#signin-email').val();
    var password = $('#passwordInput').val();
    
    if(email.length === 0 || password.length === 0){
        alert("Please fill in all fields and agree to the terms.");
        return;
    }
    
    var formData = $("#signin-form").serialize();
    
    $.ajax({
        type: "GET",
        url: "SigninServlet",
        data: formData,
        success: function (response) {
            if(response === "Authentication successful as admin!"){
                window.location.href = "admin";
            }else if(response === "Authentication successful"){
                alert(response);
                window.location.href = "index.jsp";
            }else {
                alert(response);
            }

        },
        error: function (xhr, status, error) {
            alert("Error occurred: " + error);
        }
    });
    
}

function signOut() {
    $.ajax({
        type: "GET",
        url: "SignoutServlet",
        success: function(response) {
            if(response === 'Sign out Succesfully'){
                window.location.href = "signin.jsp";
            }
        },
        error: function(xhr, status, error) {
            alert("Error occurred: " + error);
        }
    });
}

// Display Cart 
 $(document).ready(function() {
    function fetchCartItemsAndUpdateTotal() {
        $.ajax({
            url: 'CartServlets',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                var tbody = $('.cart-table tbody');
                var sumSubtotal = 0; 
                $.each(data, function(index, item) {
                    var minusButton = $('<button>').addClass('minus-btn').attr({id:'minus-btn_' + item.cartId, 'data-cart-id': item.cartId}).append(
                        $('<img>').attr('src', 'assets/icons/Minus.png')
                    ).click(function() {
                        var cartId = $(this).attr('data-cart-id');
                        minus(cartId);
                    }).prop('disabled', false);

                    var addButton = $('<button>').addClass('add-btn').attr({id:'add-btn', 'data-cart-id': item.cartId}).append(
                        $('<img>').attr('src', 'assets/icons/Add.png')
                    ).click(function() {
                        var cartId = $(this).attr('data-cart-id');
                        add(cartId);
                    });

                    var removeButton = $('<button>').addClass('remove-btn').append(
                        $('<img>').attr('src', 'assets/icons/close.png')
                    ).text('Remove').data('cart-id', item.cartId).click(function() {
                        removeCartItem(item.cartId);
                    });

                    var row = $('<tr>').addClass('cart-item').attr({id: 'cartItem_' + item.cartId, 'data-pro-id': item.productId });

                    var productDetailsColumn = $('<td>').append(
                        $('<div>').addClass('cart-product-details').append(
                            $('<img>').attr('src', contextPath + '/uploads/' + item.productImage).addClass('pro-img'),
                            $('<div>').addClass('pro-details').append(
                                $('<h3>').text(item.productName),
                                $('<span>').text('Color: Black'),
                                removeButton
                            )
                        )
                    );

                    var quantityColumn = $('<td>').append(
                        $('<div>').addClass('cart-product-element').append(
                            $('<div>').addClass('quantity-wrapper').append(
                                minusButton,
                                $('<input>').attr({
                                    type: 'text',
                                    value: item.quantity,
                                    id: 'quantity_' + item.cartId
                                }),
                                addButton
                            )
                        )
                    );

                    var priceColumn = $('<td>').append(
                        $('<div>').addClass('cart-product-element').append(
                            $('<div>').addClass('price').text('$' + item.price)
                        )
                    );

                    var subtotal = item.quantity * item.price;
                    var subtotalColumn = $('<td>').append(
                        $('<div>').addClass('cart-product-element').append(
                            $('<div>').addClass('sub-total').attr({id: 'subtotal_' + item.cartId}).text('$' + subtotal.toFixed(2))
                        )
                    );

                    sumSubtotal += subtotal;
                    row.append(productDetailsColumn, quantityColumn, priceColumn, subtotalColumn);
                    tbody.append(row);

                });
                
                $('.cart-sum-sub-total .price').text('$' + sumSubtotal.toFixed(2));
                $('.cart-sum-total .price').text('$' + sumSubtotal.toFixed(2));
                
            },
            error: function() {
                alert('Error fetching cart items.');
            }
        });
    }
    
    
    function fetchOrderSummary(){
        $.ajax({
            url: 'OrderSummaryServlets',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                var orderSummaryList = $('.order-summary-list');
                var sumSubtotal = 0;
                var shippingMethod = "";
                var total = 0;

                orderSummaryList.empty();

                $.each(data, function(index, item) {
                    var product = $('<div>').addClass('list-item').append( 
                        $('<div>').addClass('product').append(
                            $('<img>').addClass('pro-img').attr('src', contextPath + '/uploads/' + item.productImg),
                            $('<div>').addClass('details').append(
                                $('<h3>').text(item.productName),
                                $('<span>').text('Quantity: ' + item.quantity)
                            )
                        ),
                        $('<div>').addClass('price').css('display', 'none').text('$' + item.productPrice.toFixed(2)),
                        $('<div>').addClass('sub-total').text('$' + (item.productPrice * item.quantity).toFixed(2)), 
                        $('<input>').attr({
                        type: 'hidden',
                        class: 'order-id',
                        id: 'order-id',
                        value: item.orderId 
                    })
                    );

                    orderSummaryList.append(product);

                    sumSubtotal += item.productPrice * item.quantity;
                    total = item.total;

                    shippingMethod = item.shippingMethod;

                });

                // Add classes to shipping, subtotal, and total elements
                orderSummaryList.append(
                    $('<div>').addClass('shipping').append(
                        $('<span>').addClass('text').text('Shipping'),
                        $('<span>').addClass('value').text(shippingMethod)
                    ),
                    $('<div>').addClass('shipping').append(
                        $('<span>').addClass('text').text('SubTotal'),
                        $('<span>').addClass('value').text('$' + sumSubtotal.toFixed(2))
                    ),
                    $('<div>').addClass('total-cost').append(
                        $('<span>').addClass('text').text('Total'),
                        $('<span>').addClass('value').text('$' + total.toFixed(2))
                    )
                );
            },
            error: function() {
                alert('Error fetching cart items.');
            }
    });
    
}
    
    function fetchContactInformation() {
        $.ajax({
            url: 'ContactInformations',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                if (data.length > 0) {
                    var contactInfo = data[0];

                    $('#fname').val(contactInfo.firstName);
                    $('#lname').val(contactInfo.lastName);
                    $('#email').val(contactInfo.email); 
                    $('#phone').val(contactInfo.phoneNo); 
                }
            },
            error: function() {
                alert('Error fetching contact information.');
            }
        });
    }
    
    function fetchAddressInformation(){
        $.ajax({
            url: 'AddressInfoServlets',
            type: 'GET',
            dataType: 'json',
            success: function(data){
                if(data.length > 0){
                    var addressInfo = data[0];
                    
                    $('#street').val(addressInfo.streetAddress);
                    $('#city').val(addressInfo.city);
                    $('#state').val(addressInfo.state);
                    $('#postalCode').val(addressInfo.postalCode);
                    $('#db-country').text(addressInfo.country);
                }
            },
            error: function(){
                alert('Error fetching contact information.');
            }
        });
    }

    function fetchOrderComplete() {
    $.ajax({
        url: 'OrderCompleteServlets',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var orderCode = '';
            var orderedDate = '';
            var total;
            var paymentMethod = '';

            var orderedItems = $('.ordered-items');
            orderedItems.empty();

            $.each(data, function(index, item) {
                var orderedItem = $('<div>').addClass('ordered-item').append(
                    $('<span>').addClass('circle').text(item.quantity),
                    $('<img>').attr('src', contextPath + '/uploads/' + item.productImg)
                );
                orderedItems.append(orderedItem);
                
                orderCode = item.orderCode;
                orderedDate = item.orderedDate;
                total = item.total;
                paymentMethod = item.paymentMethod;
            });
            
            $('.order-details .details li:nth-child(1)').text(orderCode);
            $('.order-details .details li:nth-child(2)').text(orderedDate);
            $('.order-details .details li:nth-child(3)').text('$' + total.toFixed(2));
            $('.order-details .details li:nth-child(4)').text(paymentMethod);
        },
        error: function() {
            alert('Error fetching order details.');
        }
    });
}
    
    fetchCartItemsAndUpdateTotal();
    fetchOrderSummary();
    fetchContactInformation();
    fetchAddressInformation();
    fetchOrderComplete();
     
 });
    
//Remove Cart Item
function removeCartItem(cartId) {
    $.ajax({
        url: 'RemoveCartItemServlet',
        type: 'POST',
        data: { cart_id: cartId },
        success: function(response) {
            location.reload();
        },
        error: function(xhr, status, error) {
            console.error('Error removing item:', error);
        }
    });
}

//Send Cart Data
function sendData() {
    var total = $('.cart-sum-total .price').text().trim();
    var total = total.replace('$', '');
    var cartItems = [];
    var shipping = parseInt($('input[name=shipping-method]:checked').val());
    if(shipping === 15){
        shippingMethod = 'Express Shipping';
    }else {
        shippingMethod = "Free Shiping";
    }

    $('.cart-item').each(function() {
      var cartId = $(this).attr('id').split('_')[1];
      var proId = $(this).data('pro-id');
      var quantity = parseInt($('input[id^=quantity_]', this).val()); 

      cartItems.push({
        cartId: cartId,
        productId: proId,
        quantity: quantity
      });
    });
    
    console.log(JSON.stringify(cartItems));
    $.ajax({
        url: contextPath + '/CartDetailsServlets',
        type: 'POST',
        data: {
            total_price: total,
            cart_items: JSON.stringify(cartItems), 
            shipping_method: shippingMethod
        },
        success: function(response) {
            if (response.startsWith("Success")) {
                window.location.href = 'checkout.jsp';
            } else {
                console.error("Error in processing order:", response);
                alert("Error in processing order. Please try again later.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("AJAX Error:", textStatus, errorThrown);
            alert("Error sending data. Please try again later.");
        }
    });
}


//Send CheckOut Data 
function sendCheckoutData(){
    var firstName = $('#fname').val();
    var lastName = $('#lname').val();
    var email = $('#email').val(); 
    var phoneNo = $('#phone').val();
    var street = $('#street').val();
    var city = $('#city').val();
    var state = $('#state').val();
    var postalCode = $('#postalCode').val();
    var country = $('#country').val();
    var orderId = $('#order-id').val();
    var paymentMethod = $('input[name=payment-method]:checked').val();
    
    $.ajax({
        url: 'CheckoutDetailsServlets',
        type: 'POST',
        data: {
            firstName: firstName,
            lastName: lastName,
            email: email,
            phoneNo: phoneNo,
            street: street,
            city: city,
            state: state,
            postalCode: postalCode,
            country: country,
            orderId: orderId,
            paymentMethod: paymentMethod
        },
        success: function(response) {
            if (response.startsWith("Success")) {
                window.location.href = 'orderCompletes.jsp';
            } else {
                console.error("Error in processing order:", response);
                alert("Error in processing order. Please try again later.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("AJAX Error:", textStatus, errorThrown);
            alert("Error sending data. Please try again later.");
        }
    });
}


function togglePasswordVisibility() {
    event.preventDefault();
    var passwordInput = document.getElementById("passwordInput");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
 }
 

 function validatePassword(password) {
    if(password.length < 8){
        return false;
    }
     if (!/[A-Z]/.test(password)) {
         return false;
     }
     if (!/\d/.test(password)) {
         return false;
     }
     if (!/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(password)) {
         return false;
     }
     return true;
}


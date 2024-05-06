$(document).ready(function() {
    function populateProductGrid(shops) {
    var productGrid = $('#productGrid');
    productGrid.empty();

    if (shops.length === 0) {
        productGrid.append('<div class="col"><p>No products available</p></div>');
    } else {
        $.each(shops, function(index, shop) {
            var card = $('<div>').addClass('col-md-3');
            var cardWrapper = $('<a>').addClass('pro-card-wrapper').attr('href', '#');
            var proCard = $('<div>').addClass('pro-card');
            var proCardImg = $('<div>').addClass('pro-card-img');
            var proAddToCart = $('<div>').addClass('pro-add-to-cart');
            var addToCartForm = $('<form>').attr('id', 'addToCartForm').attr('method', 'POST');
            var proIdInput = $('<input>').attr('type', 'hidden').attr('name', 'pro_id').val(shop.proId);
            var quantityInput = $('<input>').attr('type', 'hidden').attr('name', 'quantity').val(1);
            var subTotalInput = $('<input>').attr('type', 'hidden').attr('name', 'sub_total').val(shop.discountPrice);
             var addToCartButton = $('<button>').attr({
                                'id': 'shoppingNowButton',
                                'style': 'background-color: #141718; color: #fff; border-radius: 8px; width: 100%;',
                                'onclick': 'addToCart()'
                            }).text('Add To Cart').addClass("button");

            addToCartForm.append(proIdInput, quantityInput, subTotalInput, addToCartButton);
            proAddToCart.append(addToCartForm);
            proCardImg.append(proAddToCart);

            if (shop.isNew) {
                proCardImg.append('<div class="new">New</div>');
            }

            if (shop.discountPercentage > 0) {
                proCardImg.append('<div class="discount"></div>');
            }

            proCardImg.append('<button class="add-to-wishlist"><img src="assets/icons/wishlist.png" /></button>');
            proCardImg.append('<img class="img-fluid mb-3" src="' + contextPath + '/assets/ElementsTh/' + shop.proImg + '" alt="">');

            var proCardDetails = $('<div>').addClass('pro-card-details');
            var rating = $('<div>').addClass('rating');
            var ratingStars = '';

            for (var i = 0; i < Math.round(shop.proReviews); i++) {
                ratingStars += '<i class="bi bi-star-fill text-warning"></i>';
            }

            rating.append(ratingStars);
            proCardDetails.append(rating);
            proCardDetails.append('<h2>' + shop.proName + '</h2>');
            proCardDetails.append('<div class="prices"><span class="discount-price">$' + shop.discountPrice + '</span><span class="price"><s>$' + shop.proPrice + '</s></span></div>');

            proCard.append(proCardImg, proCardDetails);
            cardWrapper.append(proCard);
            card.append(cardWrapper);
            productGrid.append(card);
        });
    }
}

    function fetchProducts() {
    $.ajax({
        url: contextPath + '/ShopServlet',
        type: 'GET',
        dataType: 'json',
        success: function(shops) {
            populateProductGrid(shops);
        },
        error: function() {
            alert('Error fetching products.');
        }
    });
}


    fetchProducts();
});






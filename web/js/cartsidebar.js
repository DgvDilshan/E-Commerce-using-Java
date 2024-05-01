var ITEMS = [
    {
        id: 1,
        name: 'Tray Table',
        price: 19,
        image: 'images/product6.png',
        qty: 1,
    },
    {
        id: 2,
        name: 'Tray Table',
        price: 19,
        image: 'images/productt.png',
        qty: 1,
    },
    {
        id: 3,
        name: 'Table Lamp',
        price: 39,
        image: 'images/product6.png',
        qty: 1,
    },
]

var openBtn = document.getElementById('open_cart_btn')
var cart = document.getElementById('sidecart')
var closeBtn = document.getElementById('close_btn')
var backdrop = document.querySelector('.backdrop')
var itemsE1 = document.querySelector('.items')
var cartItems = document.querySelector('.cart_items')
var itemNum = document.getElementById('items_num')
var subtotalPrice = document.getElementById('subtotal_price')

var cart_data = []

openBtn.addEventListener('click', openCart)
closeBtn.addEventListener('click', closeCart)
backdrop.addEventListener('click', closeCart)

renderItems()
renderCartItems()

// Open Cart
function openCart() {
    cart.classList.add('open');
    backdrop.style.display = 'block';
    
    setTimeout(function() {
        backdrop.classList.add('show');
    }, 0);
}

// Close Cart
function closeCart() {
    cart.classList.remove('open');
    backdrop.classList.remove('show');

    setTimeout(function() {
        backdrop.style.display = 'none';
    }, 500);
}


// Add Items to Cart
function addItem(idx, itemId){
    // Find same items
    var foundedItem = cart_data.find(
    (item) => item.id.toString() === itemId.toString()
    )

    if(foundedItem){
      increaseQty(itemId)
    } else{
      cart_data.push(ITEMS[idx])

    }

    updateCart()
    openCart()
}

// Remove cart Items
function removeCartItem(itemId) {
    cart_data = cart_data.filter(item => item.id !== itemId)

    updateCart()
}

// Increase Qty
function increaseQty(itemId) {
    cart_data = cart_data.map(function(item) {
        if (item.id.toString() === itemId.toString()) {
            return { id: item.id, qty: item.qty + 1 };
        } else {
            return item;
        }
    });
    
    updateCart();
}


// Decrease Qty
function decreaseQty(itemId) {
    cart_data = cart_data.map(function(item) {
        if (item.id.toString() === itemId.toString()) {
            return { id: item.id, qty: item.qty > 1 ? item.qty - 1 : item.qty };
        } else {
            return item;
        }
    });
    
    updateCart();
}


// Calculate Item Number
function calcItemsNum(){
    var itemsCount = 0

    cart_data.forEach((item) => (itemsCount += item.qty))

    itemNum.innerText = itemsCount // Corrected the variable name
}

// Calculate Subtotal Price
function calcSubtotalPrice() {
    var subtotal = 0;

    cart_data.forEach(function(item) {
        subtotal += item.price * item.qty;
    });

    // Update the subtotal price in the DOM
    subtotalPrice.innerText = subtotal.toFixed(2);
}



// Render Items
function renderItems() {
    ITEMS.forEach(function(item, idx) {
        var itemE1 = document.createElement('div');
        itemE1.classList.add('item');
        itemE1.onclick = function() { addItem(idx, item.id); };
        itemE1.innerHTML = '<img src="' + item.image + '" alt="" />' +
                           '<button>Add to Cart</button>';
        itemsE1.appendChild(itemE1);
    });
}


// Display / Render Cart Items
function renderCartItems(){
    // Remove everything from cart
    cartItems.innerHTML=''
    // Add new data
    cart_data.forEach(function(item) {
        var cartItem = createCartItem(item);
        cartItems.appendChild(cartItem);
    });
}
function createCartItem(item) {
    var cartItem = document.createElement('div');
    cartItem.classList.add('cart_item');
    cartItem.innerHTML = '<div class="remove_item" onclick="removeCartItem(' + item.id + ')">' +
                            '<span>&times;</span>' +
                        '</div>' +
                        '<div class="item_img">' +
                            '<img src="' + item.image + '" alt=""/>' +
                        '</div>' +
                        '<div class="item_details">' +
                            '<p>' + item.name + '</p>' +
                            '<strong>' + item.price + '</strong>' +
                            '<div class="qty">' +
                                '<span onclick="decreaseQty(' + item.id + ')">-</span>' +
                                '<strong>' + item.qty + '</strong>' +
                                '<span onclick="increaseQty(' + item.id + ')">+</span>' +
                            '</div>' +
                        '</div>';

    return cartItem;
}

Array.from(cartItems.children).forEach(function(item) {
    var cartItem = createCartItem(item);
    cartItems.appendChild(cartItem);
});
function updateCart(){
    // Render cart items with updated data
    renderCartItems()
    // Update Items number in Cart
    calcItemsNum()
    // Update Subtotal
    calcSubtotalPrice()
}

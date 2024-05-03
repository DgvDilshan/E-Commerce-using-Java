<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Wishlist</title>
    <style>
        /* Customize your styles here */
        #wishlist table {
            width: 100%;
            border-collapse: collapse;
        }
        #wishlist tr {
        border-bottom: 1px solid black;
       }

        #wishlist th, #wishlist td {
            padding: 10px;
            text-align: left;
            vertical-align: top;
            border: 0px solid #ddd;
        }

        #wishlist img {
            max-width: 50px;
        }

        .product-info {
            display: flex;
            align-items: center;
        }

        .product-info img {
            max-width: 50px;
            margin-right: 10px;
        }

        .remove-btn {
            background-color: transparent;
            border: none;
            cursor: pointer;
        }

        .remove-btn img {
            width: 20px;
            height: 20px;
            opacity: 0.5;
        }

        .remove-btn:hover img {
            opacity: 1;
        }
    </style>
</head>
<body>
    <div id="wishlist">
        <h2>Your Wishlist</h2>
        <table style="width:70%">
            <tr>
                <th></th>
                <th>Product</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <!-- Items will be dynamically added here -->
        </table>
    </div>

    <!-- Template for wishlist items -->
    <template id="item-template">
        <tr>
            <td>
                <button class="remove-btn"><img src="assets/icons/delete.png" alt="Remove"></button>
            </td>
            <td>
                <div class="product-info">
                    <img src="" alt="">
                    <div>
                        <span></span><br>
                        <small></small>
                    </div>
                </div>
            </td>
            <td></td>
            <td><button>Add to cart</button></td>
        </tr>
    </template>

    <script>
        // Sample data for wishlist items
        var items = [
            { image:'assets/Elements/product6.png', name: 'Tray Table', color: 'Black', price: '$19.19' },
            { image: 'assets/Elements/product4.png', name: 'Sofa', color: 'Gray', price: '$345' },
            { image:'assets/Elements/product11.png', name: 'Bamboo basket', color: 'Beige', price: '$8.80' },
            { image:'assets/Elements/product12.png', name: 'Pillow', color: 'Beige', price: '$8.80' },
            // Add more items as needed
        ];

        // Populate the wishlist
        var table = document.querySelector('#wishlist table');
        var template = document.querySelector('#item-template').content;

        items.forEach(item => {
            var clone = document.importNode(template, true);
            var td = clone.querySelectorAll('td');
            td[1].querySelector('img').src = item.image;
            td[1].querySelector('span').textContent = item.name;
            td[1].querySelector('small').textContent = `Color: ${item.color}`;
            td[2].textContent = item.price;

            table.appendChild(clone);
            document.addEventListener('click', function(event) {
                if (event.target.classList.contains('remove-btn')) {
                    var row = event.target.closest('tr');
                    row.remove(); // Remove the entire row when the remove button is clicked
                }
            });
        });
    </script>
</body>
</html>

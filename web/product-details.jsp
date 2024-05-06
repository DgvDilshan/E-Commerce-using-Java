<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="/WEB-INF/tlds/buttonTags" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce</title>
        
        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/product-details.css">
        <link rel="icon" type="image/png" sizes="32x32" href="{%static './assets/favicon-32x32.png' %}">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        
        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" >
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
                       
        <%@include file="includes/navbar.jsp" %>
        <%@include file="includes/searchbar.jsp" %>
        
        <section class="container">
            <div class="container flex">
                <div class="left">
                    <div class="main-img">
                        <img id="slide" src="./assets/products/Paste image 1.jpg">
                    </div>
                    <div class="option flex1">
                        <img id="slide" src="./assets/products/Table 1.1.jpg" onclick="img('./assets/products/Table 1.1.jpg')">
                        <img id="slide" src="./assets/products/Table 2.2.jpg" onclick="img('./assets/products/Table 2.2.jpg')">
                        <img id="slide" src="./assets/products/Table 2.2.jpg" onclick="img('./assets/products/Table 2.2.jpg')">
                    </div>
                </div>
                <div class="right">
                    <div class="product-content">
                        <div class="product-up">
                            <div class="product-rating">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star-half-stroke"></i>
                                <span>11 Review</span>
                            </div>
                            <h2 class="product-title">Tray Table</h2>
                            <p class="product-description">Buy one or buy a low and make every space where you sit more convenient. 
                            Light and easy to move around with removable tray top, handy for serving snacks.
                            </p>
                            <div class="product-price">
                                <span class="discount-price">$200.00</span>
                                <span class="price"><s>$400.00</s></span>
                            </div>
                        </div>
                        <hr>
                        <div class="product-mid">
                            <p>offer expires in</p>
                            <div class="row">
                                <div class="col-2">
                                    <span class="exp-date rounded">02</span>
                                </div>
                                <div class="col-2">
                                    <span class="exp-date rounded">12</span>
                                </div>
                                <div class="col-2">
                                    <span class="exp-date rounded">45</span>
                                </div>
                                <div class="col-2">
                                    <span class="exp-date rounded">05</span>
                                </div>
                            </div>
                            <div class="row">
                                <span class="col-2 time">Days</span>
                                <span class="col-2 time">Hours</span>
                                <span class="col-2 time">Minutes</span>
                                <span class="col-2 time">Seconds</span>
                            </div>
                        </div>
                        <hr>
                        <!--Product down-->
                        <div class="product-down">
                            <p>Measurements :</p>
                            <h5>17 1/2 x 20 5/8"</h5>
                            
                            <h6>Choose color: Black</h6>
                            <div class="swatches-group-colorsmall">
                                <div class="select-img">
                                    <div class="btn small-image col-2">
                                        <img src="./assets/products/black table 1.jpg" class="color-img">
                                    </div>
                                    <div class="btn small-image col-2">
                                        <img src="./assets/products/gray table 2.jpg" class="color-img">
                                    </div>
                                    <div class="btn small-image col-2">
                                        <img src="./assets/products/red table 3.jpg" class="color-img">
                                    </div>
                                    <div class="btn small-image col-2">
                                        <img src="./assets/products/white table 4.jpg" class="color-img">
                                    </div>
                                </div>
                            </div>
                            <!--button options-->
                            <div class="row select-op">
                                <div class="d-flex align-items-center col-2">
                                    <button class="btn btn-quantity" type="button">-</button>
                                    <input type="text" class="form-control bg-gray text-center" value="1" style="max-width: 50px;" />
                                    <button class="btn btn-quantity" type="button">+</button>
                                </div>
                                <div class="wishlist col-2">
                                    <button type="button" class="btn">Wishlist</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="cart-btn">
                                    <button type="button" class="btn btn-secondary btn-md btn-block">Add to cart</button>
                                </div>
                            </div>
                            <div class="row cate">
                                <div class="col mb-10 text-gray"><b>SKU</b></div>
                                <div class="col mb-10">1117</div>
                                <div class="w-100"></div>
                                <div class="col mb-10 text-gray"><b>CATEGORY</b></div>
                                <div class="col mb-10">Living Room, Bedroom </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <script>
            function changeImage(imagePath) {
                var imageElement = document.getElementById('slide'); // Assuming you have an element with id="slide"
                if (imageElement) {
                   imageElement.src = imagePath;
                } else {
                    console.error("Error: Could not find element with id='slide'");
                }
            }

            function changeBackgroundColor(color) {
                var line = document.getElementById('home'); // Assuming you have an element with id="home"
                if (line) {
                    line.style.background = color;
                } else {
                    console.error("Error: Could not find element with id='home'");
                }
            }
        </script>
        
        <script>
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="js/index.js"></script>


        
    </body>




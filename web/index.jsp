<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>E-Commerce</title>

  <!--CSS-->
  <link rel="stylesheet" type="text/css" href="css/styles.css" />
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" type="text/css" href="css/contactus.css" />

  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link
    href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap"
    rel="stylesheet"
  />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <header class="header">
                       
        <%@include file="includes/navbar.jsp" %>
        <%@include file="includes/searchbar.jsp" %>
        
        <div class="container">
            <div class="hero-wrapper">
                <div class="hero-text">
                    <h1>More than just a game. It’s a lifestyle.</h1>
                    <p>Whether you’re just starting out, have played your whole life or you're a Tour pro, your swing is like a fingerprint.</p>
                    <a>
                        <b:Button text="Shopping Now" rounded="false" outlined="false"/>
                    </a>
                </div>
            </div>
        </div>
    </header>
        
        <!------------feature products-------------->
        
        <section class="shop-index">
            <div class="container">
                <h2 class="pro-title">Feature Products</h2>
                <div class="row mt-5" id="productGrid"> 
                <!--pro-box 1-->
                <div class="col-md-3 mb-5">
                        <a href="#" class="pro-card-wrapper">
                            <div class="pro-card">
                                <div class="pro-card-img">
                                    <div class="pro-add-to-cart">
                                        <form id="addToCartForm" method="POST">
                                            <input type="hidden" name="pro_id" value="1" id="pro_id" />
                                            <input type="hidden" name="quantity" value="1" id="quantity" />
                                            <input type="hidden" name="sub_total" value="199.10" id="sub_total" />
                                            <div id="add-to-cart">
                                                <b:Button text="Add To Cart" rounded="false" outlined="false" onclick="addToCart()"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="new">new</div>
                                    <div class="discount">-50%</div>
                                    <button class="add-to-wishlist"><img src="assets/icons/wishlist.png" /></button>
                                    <img class="img-fluid mb-3" src="assets/Elements/product1.png" alt="" />
                                </div>
                                <div class="pro-card-details">
                                    <div class="rating">
                                       <img src="assets/icons/star.png" />
                                    </div>
                                    <h2>Loveseat Sofa</h2>
                                    <div class="prices">
                                       <span class="discount-price">$200.00</span>
                                       <span class="price"><s>$400.00</s></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                
                <!--pro-box 2-->
                <div class="col-md-3 mb-5">
                        <a href="#" class="pro-card-wrapper">
                            <div class="pro-card">
                                <div class="pro-card-img">
                                    <div class="pro-add-to-cart">
                                        <form id="addToCartForm" method="POST">
                                            <input type="hidden" name="pro_id" value="1" id="pro_id" />
                                            <input type="hidden" name="quantity" value="1" id="quantity" />
                                            <input type="hidden" name="sub_total" value="199.10" id="sub_total" />
                                            <div id="add-to-cart">
                                                <b:Button text="Add To Cart" rounded="false" outlined="false" onclick="addToCart()"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="new">new</div>
                                    <div class="discount">-50%</div>
                                    <button class="add-to-wishlist"><img src="assets/icons/wishlist.png" /></button>
                                    <img class="img-fluid mb-3" src="assets/Elements/product12.png" alt="" />
                                </div>
                                <div class="pro-card-details">
                                    <div class="rating">
                                       <img src="assets/icons/star.png" />
                                    </div>
                                    <h2>Pink Pillow</h2>
                                    <div class="prices">
                                       <span class="discount-price">$3.99</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                
                <!--pro-box 3-->
                <div class="col-md-3 mb-5">
                        <a href="#" class="pro-card-wrapper">
                            <div class="pro-card">
                                <div class="pro-card-img">
                                    <div class="pro-add-to-cart">
                                        <form id="addToCartForm" method="POST">
                                            <input type="hidden" name="pro_id" value="1" id="pro_id" />
                                            <input type="hidden" name="quantity" value="1" id="quantity" />
                                            <input type="hidden" name="sub_total" value="199.10" id="sub_total" />
                                            <div id="add-to-cart">
                                                <b:Button text="Add To Cart" rounded="false" outlined="false" onclick="addToCart()"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="new">new</div>
                                    <div class="discount">-50%</div>
                                    <button class="add-to-wishlist"><img src="assets/icons/wishlist.png" /></button>
                                    <img class="img-fluid mb-3" src="assets/Elements/product3.png" alt="" />
                                </div>
                                <div class="pro-card-details">
                                    <div class="rating">
                                       <img src="assets/icons/star.png" />
                                    </div>
                                    <h2>Table Lamp</h2>
                                    <div class="prices">
                                       <span class="discount-price">$7.99</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                
                <!--pro-box 4-->
                <div class="col-md-3 mb-5">
                        <a href="#" class="pro-card-wrapper">
                            <div class="pro-card">
                                <div class="pro-card-img">
                                    <div class="pro-add-to-cart">
                                        <form id="addToCartForm" method="POST">
                                            <input type="hidden" name="pro_id" value="1" id="pro_id" />
                                            <input type="hidden" name="quantity" value="1" id="quantity" />
                                            <input type="hidden" name="sub_total" value="199.10" id="sub_total" />
                                            <div id="add-to-cart">
                                                <b:Button text="Add To Cart" rounded="false" outlined="false" onclick="addToCart()"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="new">new</div>
                                    <div class="discount">-50%</div>
                                    <button class="add-to-wishlist"><img src="assets/icons/wishlist.png" /></button>
                                    <img class="img-fluid mb-3" src="assets/Elements/product4.png" alt="" />
                                </div>
                                <div class="pro-card-details">
                                    <div class="rating">
                                       <img src="assets/icons/star.png" />
                                    </div>
                                    <h2>Family Sofa</h2>
                                    <div class="prices">
                                       <span class="discount-price">$189.99</span>
                                       <span class="price"><s>$369.90</s></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <!--Show more btn-->
                    <button class="shm-btn">Show More</button>                  
                </div>
            </div>
        </section>
        
       <%@include file="includes/newsletter.jsp" %>
       <%@include file="includes/footer.jsp" %>
       
 
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"
  ></script>
  <script src="js/index.js"></script>
</body>

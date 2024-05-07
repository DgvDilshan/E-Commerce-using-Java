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
<<<<<<< HEAD
   <link rel="stylesheet" type="text/css" href="css/shopbycategories.css"
=======
  <link rel="stylesheet" type="text/css" href="css/contactus.css" />
>>>>>>> 33633ac5da06e0a36570eb21591345b66ff7f554

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
       <%@include file="includes/newsletter.jsp" %>
       <%@include file="includes/footer.jsp" %>
       
 
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"
  ></script>
  <script src="js/index.js"></script>
  
    <section class="categories" id="categories">
        <h2 class="heading">Shop by Categories</h2>
        <div class="box-container">
            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\a.png" alt="">
                </a>
                <h6>Golf Clubs</h6>
                
            </div>

            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\b.png" alt="">
                </a>
                <h6>Golf Balls</h6>
                
            </div>

            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\c.png" alt="">
                </a>
                <h6>Golf Bags</h6>
                
            </div>

            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\d.png" alt="">
                </a>
                <h6>Clohing & Rainwear</h6>
                
            </div>

            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\e.png" alt="">
                </a>
                <h6>Footwear</h6>
                
            </div>

            <div class="box">
                <a href="default.asp">
                <img src="assets\shopcategories\f.png" alt="">
                </a>
                <h6>Accessories</h6>
                
            </div>
        </div>
    </section>
  
        
    </body>


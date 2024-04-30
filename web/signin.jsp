<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="/WEB-INF/tlds/buttonTags" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce</title>
        
        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="css/signInAndSignup.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        
        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" >
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        
        <div class="authentication-section">
            <div class="row">
                <div class="col-md-6 authentication-img">
<!--                    <img src="assets/authentication.png" />-->
                    <a href="index.jsp" class="logo"><img src="assets/logo.png"></a>
                </div>
                <div class="col-md-6">
                    <form class="authentication-form" id="signin-form">
                        <h3>Sign In</h3>
                        <p>Don’t have an accout yet? <a href="signup.jsp">Sign Up</a></p>
                        <p class="error" id="error"></p>
                        
                        
                        <div class="outlined-input">
                            <div class="input-wrapper">
                                <input type="email" placeholder="Email Address" name="email" id="signin-email" style="color: #000"/>
                            </div>
                        </div>
                        <div class="outlined-input">
                            <div class="input-wrapper">
                                <input type="password" placeholder="Password" id="passwordInput" name="password"  style="color: #000"/>
                            </div>
                            <button onclick="togglePasswordVisibility()"><img src="assets/icons/eye.png" /></button>
                        </div>
                        
                        <b:Button outlined="false" rounded="false" text="Sign in" id="sign-in" onclick="signIn()"/>
                    </form>
                </div>
            </div>
        </div>
        
        
        
        
        <script>
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="js/index.js"></script>

    </body>
</html>

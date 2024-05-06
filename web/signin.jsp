<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">


    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/signin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

    <div class="container-fluid position-relative">
        <a href="index.jsp" class="logo"><img src="assets/logo.png" class="img-fluid" alt="Logo"></a>
        <div class="row">
            <div class="col-md-6 p-0">
                <div class="img-container">
                    <img src="assets/authentication.png" class="img-fluid" alt="Authentication Image">
                </div>
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-center">
                <div class="card shadow">
                    <div class="card-body">
                        <h3 class="text-center mb-4">Sign In</h3>
                        <p class="text-center mb-4">Don't have an account? <a href="signup.jsp">Sign up</a></p>
                        <form id="signin-form">
                            <div class="mb-3 input-group">
                                <input type="email" class="form-control" placeholder="Email" name="email" id="signin-email">
                            </div>
                            <div class="mb-3 input-group">
                                <input type="password" class="form-control" placeholder="Password" name="password" id="passwordInput">
                                <button class="btn btn-outline-secondary" type="button" onclick="togglePasswordVisibility()">
                                    <img src="assets/icons/eye.png" />
                                </button>
                            </div>
                            <button type="submit" class="btn btn-primary w-100" onclick="signIn()">Sign In</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
 <script>
        var contextPath = "<%= request.getContextPath()%>";
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="js/index.js"></script>
</body>
</html>
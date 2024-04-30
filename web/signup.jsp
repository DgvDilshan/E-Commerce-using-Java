<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce</title>
    
    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/signup.css">
    
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
    
    <style>
        .logo {
            position: absolute;
            top: 20px;
            margin-left:280px;
            margin-top:60px; 
            transform: translateX(-50%);
            z-index: 1; /* Ensures the logo appears above the image */
        }
        .img-fluid{
            margin-top:-100px;
        }
        .card {
            margin-top: -90px;
            margin-left:10px;/* Adjust the top margin as needed */
        }
      
        .img-container {
            height: 700px; /* Adjust the height as needed */
            overflow: hidden;
        }
        .form-control {
            margin-bottom: 20px; /* Increase the gap between input fields */
        }
        .btn-primary {
            background-color: black; /* Set button color to black */
            border-color: black; /* Set button border color to black */
        }
         .input-group button {
            width: 40px; /* Adjust width as needed */
            height: 37px; /* Adjust height as needed */
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .btn-primary:hover {
            background-color:#cccccc;/* Change to ash color on hover */
            border-color:#cccccc;
            
}
    </style>
</head>
<body>
    
<div class="container-fluid position-relative">
    <a href="index.jsp" class="logo"><img src="assets/logo.png" class="img-fluid" alt="Logo"></a>
    <div class="row">
        <div class="col-md-6 p-0">
             <div class="img-container">
                 <img src="assets/authentication.png" class="img-fluid" alt="Authentication Image"></div>
        </div>
        
        <div class="col-md-6 d-flex align-items-center justify-content-center">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="text-center mb-4">Sign up</h3>
                    <p class="text-center mb-4">Already have an account? <a href="signin.jsp">Sign in</a></p>
                    <form id="signup-form">
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="First Name" name="fname" id="signup-fname">
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Last Name" name="lname" id="signup-lname">
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" placeholder="Email Address" name="email" id="signup-email">
                        </div>
                        <div class="mb-3">
                            <div class="input-group">
                                <input type="password" class="form-control" placeholder="Password" id="passwordInput" name="password">
                                <button class="btn btn-outline-secondary" type="button" onclick="togglePasswordVisibility()"><img src="assets/icons/eye.png" /></button>
                            </div>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Phone Number" name="pno" id="signup-pno">
                        </div>
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="signup-terms">
                            <label class="form-check-label" for="signup-terms">I agree with Privacy Policy and Terms of Use</label>
                        </div>
                        <button type="submit" class="btn btn-primary w-100" onclick="signUp()">Sign Up</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/index.js"></script>

</body>
</html>

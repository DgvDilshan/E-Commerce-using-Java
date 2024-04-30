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
                window.location.href = "index.jsp";
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
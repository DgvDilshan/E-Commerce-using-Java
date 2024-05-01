<!DOCTYPE html>
<html>
    <% if (request.getAttribute("error") != null) {%>
    <script>
        // Extract the error message
        var errorMessage = "<%= request.getAttribute("error")%>";
        // Display the error message in a pop-up dialog
        alert(errorMessage);
        // Redirect to the myaccount page after the user clicks OK
        window.location.href = "myaccount?action=details";
    </script>
    <% } %>

    <% if (request.getAttribute("error") != null) {%>
    <script>
        // Extract the error message
        var errorMessage = "<%= request.getAttribute("error")%>";
        // Display the error message in a pop-up dialog
        alert(errorMessage);
    </script>
    <% }%>
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/accountDetails.css"> 
    </head>

    <body>
        <%@include file="sideNav.jsp" %>
        <h2 class="main-header">MY ACCOUNT</h2>
        <div class="ru_card2">
            <div class="ru_card-header">
                <h3 class="text-center">Account Details</h3>
            </div>
            <div class="card-body">

                <form action="myaccount" method="post">
                    <table>
                        <tr>
                        <input type="hidden" name="requestType" value="update"/>
                        <input type="hidden" name="user_id" value="${user.user_id}"/>
                        <div class="form-group row">
                            <label for="first_name" class="col-sm-3 col-form-label">First Name:</label>
                            <div class="col-sm-9">
                                <input type="text" id="first_name" value="${user.first_name}" name="first_name" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="last_name" class="col-sm-3 col-form-label">Last Name:</label>
                            <div class="col-sm-9">
                                <input type="text" id="last_name" value="${user.last_name}" name="last_name" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="display_name" class="col-sm-3 col-form-label">Display Name:</label>
                            <div class="col-sm-9">
                                <input type="text" id="display_name" value="${user.display_name}" name="display_name" placeholder="Enter your display name" class="form-control">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="email" class="col-sm-3 col-form-label">Email:</label>
                            <div class="col-sm-9">
                                <input type="email" id="email" value="${user.email}" name="email" class="form-control" >
                            </div>
                        </div>
                        <br>

                        <h3 class="ru_card-header">Change Password</h3>

                        <input type="hidden" name="real_password" value="${user.password}"/>
                        <div class="form-group row">
                            <label for="old_password" class="col-sm-3 col-form-label">Old Password:</label>
                            <div class="col-sm-9">
                                <input type="password" id="old_password" name="old_password" placeholder="Enter your old password" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="new_password" class="col-sm-3 col-form-label">New Password:</label>
                            <div class="col-sm-9">
                                <input type="password" id="new_password" name="new_password" placeholder="Enter your new password" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="confirm_password" class="col-sm-3 col-form-label">Confirm Password:</label>
                            <div class="col-sm-9">
                                <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm your password" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-9 offset-sm-3">
                                <input type="submit" value="Submit" class="btn btn-primary">
                            </div>
                        </div>
                </form>
            </div>
        </div>
        <script>
            function toggleNav() {
                var sidenav = document.getElementById("mySidenav");
                if (sidenav.style.width === "250px") {
                    sidenav.style.width = "0";
                    document.body.removeEventListener("click", closeNavOutside);
                } else {
                    sidenav.style.width = "250px";
                    document.body.addEventListener("click", closeNavOutside);
                }
            }

            function closeNavOutside(event) {
                var sidenav = document.getElementById("mySidenav");
                var openbtn = document.querySelector(".openbtn");
                if (!sidenav.contains(event.target) && event.target !== openbtn) {
                    sidenav.style.width = "0";
                    document.body.removeEventListener("click", closeNavOutside);
                }
            }
        </script>
    </body>
</html>

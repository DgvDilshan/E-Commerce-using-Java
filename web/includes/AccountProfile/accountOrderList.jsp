<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/accountOrders.css"> 
        <title>User Management Application</title>

    </head>

    <body>
        <%@include file="sideNav.jsp" %>       
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Code</th>
                    <th>Total</th>
                    <th>Shipping Method</th>
                    <th>Ordered Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><c:out value="${order.order_id}" /></td>
                        <td><c:out value="${order.order_code}" /></td>
                        <td><c:out value="${order.total}" /></td>
                        <td><c:out value="${order.shipping_method}" /></td>
                        <td><c:out value="${order.order_date}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <script>
            function toggleNav() {
                var sidenav = document.getElementById("mySidenav");
                var openbtn = document.querySelector(".openbtn");

                if (sidenav.style.width === "250px" || sidenav.style.width === "") {
                    sidenav.style.width = "0";
                    document.body.removeEventListener("click", closeNavOutside); // Remove event listener
                } else {
                    sidenav.style.width = "250px";
                    document.body.addEventListener("click", closeNavOutside); // Add event listener
                }
            }

            // Function to close the navigation menu when clicking outside of it
            function closeNavOutside(event) {
                var sidenav = document.getElementById("mySidenav");
                var openbtn = document.querySelector(".openbtn");

                if (!event.target.matches('.openbtn') && !event.target.closest('.sidenav')) {
                    sidenav.style.width = "0";
                    document.body.removeEventListener("click", closeNavOutside);
                }
            }



        </script>

    </body>



</html>
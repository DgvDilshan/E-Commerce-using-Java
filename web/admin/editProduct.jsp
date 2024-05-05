<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce</title>
        
        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="../css/admin.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        
        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" >
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script>
        $(document).ready(function() {
            function getUrlParameter(name) {
                name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
                var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
                var results = regex.exec(location.search);
                return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
            };

            var proId = getUrlParameter('proId');
            
            $.ajax({
                url: '${pageContext.request.contextPath}/GetProductServlet',
                type: 'GET',
                data: { proId: proId },
                dataType: 'json',
                success: function(product) {
                    console.log(product);
                    var catId = product[0].catId;
                    var catName = product[0].catName;
                    var proName = product[0].proName;
                    var proPrice = product[0].proPrice;
                    var proImg = product[0].proImg;
                    var proDesc = product[0].proDesc;
                    
                    var imageUrl = '${pageContext.request.contextPath}/uploads/' + proImg;
                    
                    $('#pro_id').val(proId);
                    $('#pro_name').val(proName);
                    $('#pro_price').val(proPrice);
                    $('#pro_img').attr('src', imageUrl);
                    $('#pro_desc').val(proDesc);
                    $('#img_input').val(proImg);
                    $('#cat').val(catId);
                    $('#cat').text(catName);
                },
                error: function() {
                    alert('Error fetching product data.');
                }
            });
        });
    </script>
    </head>
    <body>
        <%@include file="../includes/admin/sidebar.jsp" %>
        
        <main class="page-content" id="page-content">
            <%@include file="../includes/admin/editProduct.jsp" %>
        </main>
        

        <script src="../js/admin.js"></script>
        <script>
            var contextPath = "${pageContext.request.contextPath}";
        </script>
    </body>
</html>

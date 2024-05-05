<% String path = request.getServletPath(); 
    String active = "";
    boolean pass;
    if(path.equals("/cart.jsp")){
        active = "cart";
    }else if(path.equals("/checkout.jsp")){
        active = "checkout";
    }else if(path.equals("/orderComplete.jsp")){
        active = "orderComplete";
    }

%>

<section class="title-section">
    <div class="container">
        <div class="title-wrapper">
            <h1 class="title" id="title">Cart</h1>
            
            <div class="process-wrapper">
                <button class="process-element <% if(active.equals("cart")) { %>active<% }else if(active.equals("checkout")) { %>pass<%}else if(active.equals("orderComplete")){%>pass<%}%>" id="cart-button" data-process-button-id="cart-button">
                    <div class="process">
                        <span class="circle">1</span>
                        <span class="text">Shopping cart</span>
                    </div>
                </button>
                <button class="process-element <% if(active.equals("checkout")) { %>active<%}else if(active.equals("orderComplete")){%>pass<%}%>" id="checkout-button" data-process-button-id="checkout-button" onclick="loadContent('includes/cartPage/checkoutSection.jsp', this)">
                    <div class="process">
                        <span class="circle">2</span>
                        <span class="text">Checkout details</span>
                    </div>
                </button>
                <button class="process-element <%if(active.equals("orderComplete")){%>active<%}%>" id="order-button" data-process-button-id="order-button" onclick="loadContent('includes/cartPage/orderCompleteSection.jsp', this)">
                    <div class="process">
                        <span class="circle">3</span>
                        <span class="text">Order complete</span>
                    </div>
                </button>
            </div>
        </div>
    </div>
</section>



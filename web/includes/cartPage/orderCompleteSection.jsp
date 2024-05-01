<%@taglib prefix="b" uri="/WEB-INF/tlds/buttonTags" %>

<section class="cart-section">
    <div class="container">
        <div class="order-complete-box">
            <h2>Thank you!</h2>
            <h1>Your order has been received</h1>
            <div class="ordered-items">
                <div class="ordered-item">
                    <span class="circle">2</span>
                    <img src="assets/pro1.png"/>
                </div>
            </div>
            <div class="order-details">
                <ul class="titles" role="list">
                    <li>Order code:</li>
                    <li>Date:</li>
                    <li>Total:</li>
                    <li>Payment method:</li>
                </ul>
                <ul class="details" role="list">
                    <li>#0123_45678</li>
                    <li>October 19, 2023</li>
                    <li>$1,345.00</li>
                    <li></li>
                </ul>
            </div>
            
            <a>
                <b:Button rounded="true" outlined="false" text="Purchase History"/>
            </a>
        </div>
    </div>
</section>
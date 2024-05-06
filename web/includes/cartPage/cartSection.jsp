<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="cart-section">
    <div class="container">
        <div class="cart-section-wrapper">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            
            <div class="cart-summary">
                <h2>Cart summary</h2>
                
                <div class="shipping-details">
                    <div class="radio-inputs-wrapper">
                        <div class="radio-input">
                            <input type="radio" name="shipping-method" id="shipping-method" value="0" onclick="getShipping()"/>
                            <label>Free shipping</label>
                        </div>
                        <p>$0.00</p>
                    </div>
                    <div class="radio-inputs-wrapper">
                        <div class="radio-input">
                            <input type="radio"name="shipping-method" value="15" onclick="getShipping()"/>
                            <label>Express shipping</label>
                        </div>
                        <p>+$15.00</p>
                    </div>
                </div>
                
                <div class="cart-sum-sub-total" id="cart-sum-sub-total">
                    <span class="text">
                        Subtotal
                    </span>
                    <span class="price">
                        $1234.00
                    </span>
                </div>
                <div class="cart-sum-total">
                    <span class="text">
                        Total
                    </span>
                    <span class="price" id="cart-full-total" value="0">
                        $1234.00
                    </span>
                    <span class="shipping" id="shipping-cost" hidden>$0.00
                    </span>
                </div>
                
                <div class="checkout-btn" onclick="sendData()">
                    <b:Button rounded="false" outlined="false" text="Checkout" name="checkout"/>
                </div>
            </div>
        </div>
    </div>
</section>


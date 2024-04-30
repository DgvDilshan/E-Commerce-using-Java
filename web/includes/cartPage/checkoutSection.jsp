<%@taglib prefix="b" uri="/WEB-INF/tlds/buttonTags" %>

<div class="cart-section checkout-section">
    <div class="container">
        <div class="cart-section-wrapper">
            <div class="checkout-wrapper">
                <div class="checkout-box">
                    <h2>Contact Infomation</h2>
                    
                    <div class="input-wrapper">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-box">
                                    <label>First Name</label>
                                    <input type="text" placeholder="First Name" name="fname" id="fname"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-box">
                                    <label>Last Name</label>
                                    <input type="text" placeholder="Last Name" name="lname" id="lname"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="input-wrapper">
                        <div class="input-box">
                            <label>Phone Number</label>
                            <input type="text" placeholder="Phone Number" name="pno" id="phone"/>
                        </div>
                    </div>
                    <div class="input-wrapper">
                        <div class="input-box">
                            <label>Email Address</label>
                            <input type="text" placeholder="Email Address" name="email" id="email"/>
                        </div>
                    </div>
                </div>
                
                <div class="checkout-box">
                    <h2>Shipping Address</h2>
                    
                    <div class="input-wrapper">
                        <div class="input-box">
                            <label>Street Address*</label>
                            <input type="text" placeholder="Street Address" name="address" id="street" required/>
                        </div>
                    </div>
                    <div class="input-wrapper">
                        <div class="input-box">
                            <label>Country*</label>
                            <select id="country">
                                <option id="db-country">Country</option>
                                <option value="sri-lanka">Srilanka</option>
                                <option value="india">India</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-wrapper">
                        <div class="input-box">
                            <label>Town/city*</label>
                            <input type="text" placeholder="Town/city" name="city" id="city" required/>
                        </div>
                    </div>
                    <div class="input-wrapper">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-box">
                                    <label>State</label>
                                    <input type="text" placeholder="State" id="state" name="state"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-box">
                                    <label>Zip Code</label>
                                    <input type="text" placeholder="Zip Code" id="postalCode" name="zipcode"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="checkout-box">
                    <h2>Payment method</h2>
                    
                    <div class="radio-inputs-wrapper">
                        <div class="radio-input">
                            <input type="radio" name="payment-method" id="credit-card" value="credit card" onclick="showPaymentInfo('credit-card')"/>
                            <label>Pay by Card Credit</label>
                        </div>
                        <p><img src="assets/icons/money.png"/></p>
                    </div>
                    <div class="radio-inputs-wrapper">
                        <div class="radio-input">
                            <input type="radio" name="payment-method" id="paypal" value="paypal" onclick="showPaymentInfo('paypal')" />
                            <label>Paypal</label>
                        </div>                      
                    </div>
                    
                    <div class='payment-info' id="card-info">
                        <%@include file="cardInfo.jsp" %>
                    </div>
                    <div class='payment-info' id="paypal-info" style="display: none;">
                        <%@include file="paypalInfo.jsp" %>
                    </div>
                </div>
                
                
            </div>
            <div class="cart-summary">
                <h2>Order summary</h2>
                
                <div class='order-summary-list'>
                    <div class='list-item'>
                        <div class='product'>
                            <img src='assets/pro1.png' class='pro-img'/>
                            <div class='details'>
                                <h3>Tray Table</h3>
                                <span>Color: Black</span>
                                <div>
                                    x2
                                </div>
                            </div>
                        </div>
                        <div class="price" style='display: none;'>
                            $19.00
                        </div>
                        <div class="sub-total">
                            $38.00
                        </div>
                    </div>
                    
                    <div class='shipping'>
                        <span class='text'>Shipping</span>
                        <span class='value'>Free</span>
                    </div>
                    <div class='shipping'>
                        <span class='text'>SubTotal</span>
                        <span class='value'>$99.00</span>
                    </div>
                    <div class='total-cost'>
                        <span class='text'>Total</span>
                        <span class='value'>$99.00</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="place-order-btn" onclick="sendCheckoutData()">
            <b:Button rounded="false" outlined="false" text="Place Order" name="order"/>
        </div>
    </div>
</div>
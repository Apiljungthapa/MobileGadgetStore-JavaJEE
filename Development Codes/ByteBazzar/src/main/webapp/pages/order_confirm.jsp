<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Shopping Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/order_confirm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />
</head>
<body>

<!-- nav bar start -->
	<jsp:include page="header.jsp" />
	<!-- nav bar ends -->


  <div class="container">
  
   <form action="${pageContext.request.contextPath}/Orderservlet" method="post" class="ddi">
   
    <div class="grid-container">
      <div class="cart-container">
        <div class="border rounded-lg p-4 showe">
          <div class="flex items-center justify-between">
            <h2 class="text-lg font-semibold">Your Cart</h2>
          </div>
          <div class="my-4"></div>
          <div class="grid gap-4">
          
         
          
           <c:choose>
            <c:when test="${not empty chooseproductsInCart}">
                <c:forEach var="product" items="${chooseproductsInCart}">
                    <div class="flex items-center gap-4">
                        <img class="rounded-lg object-cover" src="${product.imageUrl}" alt="Product Image" width="64" height="64">
                        <div class="flex-1">
                            <div class="text-left">
                                <div class="font-medium">${product.productName}</div>
                                <div class="text-gray-500">Quantity: ${product.quantity}</div>
                            </div>
                        </div>
                    </div>  
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>The cart is empty.</p>
            </c:otherwise>
        </c:choose>
        
        

          <div class="my-4"></div>
          <div class="grid gap-2">
            
            <div class="my-2"></div>
            <div class="flex items-center justify-between">
              <div class="text-lg font-semibold">Total</div>
            <div class="text-lg font-semibold">RS. ${grandTotal}</div>
            
            
               <input type="hidden" name="grandTotal" value="<c:out value='${grandTotal}' />">
            
            
            </div>
          </div>
        </div>
      </div>
      <div class="address-container">
        <div class="border rounded-lg p-4">
          <div class="text-lg font-semibold">Shipping Address</div>
          <div class="my-4"></div>
          
            
            <div class="grid gap-2">
              <label for="address">Address</label>
              <textarea class="input" id="address" placeholder="Enter your address" name="address" required></textarea>
            </div>
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
              <div class="grid gap-2">
                <label for="city">City</label>
                <input class="input" type="text" id="city" placeholder="Enter your city" name="city" required>
              </div>              
            </div>
        </div>
        <br><br>
        <div class="border rounded-lg p-4">
          <div class="text-lg font-semibold">Payment</div>
          <div class="my-4"></div>
          <div class="grid gap-4">
            <select class="select" id="payment-method" name ="pay" required>
              <option value="eSewa">eSewa</option>
              <option value="Khalti">Khalti</option>
              <option value="Credit Card">Credit Card</option>
            </select>
           
             
                <button class="button">Place Order</button>
             
           
            
          </div>
        </div>
      </div>
    </div>
    
    </form>
    
  </div>
  
  	<!-- info section ends -->
	<jsp:include page="footer.jsp" />
	<!-- footer section starts -->


	<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>
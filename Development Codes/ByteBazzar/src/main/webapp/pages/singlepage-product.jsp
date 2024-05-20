<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Details</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/singlepage-product.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />

</head>
<body>

 
<!-- nav start -->
  <jsp:include page="header.jsp" />
<!-- nav end -->
  
   <c:if test="${not empty requestScope.error}">
    <section style="color: green; height:500px; display:flex; justify-content:center; align-items:center;">
        <div style="color: white; background-color: #d81c5c; padding:85px; border-radius: 10px; margin-bottom: 15px;  height:150px; width:100%; display:flex; justify-content:center; align-items:center; font-size:22px; ">
            <c:out value="${requestScope.error}" />
        </div>
    </section>
</c:if>

               
  <!-- product card start -->
  <c:forEach var="product" items="${MatchingProducts}">
  <section class="outbind">
  <div class="rish-product-details">
    <div class="rish-grid-container">
      <div class="rish-product-image">
        <img alt="Product Image" src="${product.imageUrl}">
      </div>
      <div class="rish-product-info">
        <h1>${product.productName}</h1>
        <p class="rish-price">RS.${product.price}</p>
        <div class="rish-features">
          <ul>
            <li><strong>Screensize: </strong> ${product.screenSize}</li>
            <li><strong>RAM: </strong> ${product.ram}</li> 
            <li><strong>Storage: </strong> ${product.storage}</li>
            <li><strong>Processor: </strong> ${product.processor}</li>
            <li><strong>CAMERA: </strong> ${product.camera}</li>
            <li><strong>Discount: </strong> ${product.discount}%</li>
            <li><strong>Warranty: </strong> ${product.warranty}</li>
          </ul>
           
        </div>
        <p class="rish-feat-desc"><strong>Features:</strong> ${product.features}</p>
             
          <form action="${pageContext.request.contextPath}/CartServlet" method="post">
          <input type="hidden" name="product_id_cart" value="${product.productID}">
          <div class="tha-quantity-control"> 
            <button class="tha-button tha-button-secondary minus" type="button">-</button>
            <input class="tha-inputt" type="text" value="1" name="quant">
            <button class="tha-button tha-button-secondary plus" type="button">+</button>
        </div>
          <button type="submit" class="rish-add-to-cart" id="counter_id">Add to Cart</button>      
        </form>
        
      </div>
    </div>
  </div>
  </section>
  
  
 </c:forEach>
  
  
  <!-- product card end -->



   <!-- footer start -->
   <jsp:include page="footer.jsp" />
  <!-- footer ends -->

  <script src="${pageContext.request.contextPath}/js/home.js"></script>
  

  
   
  <script>
  document.addEventListener('DOMContentLoaded', function () {
      const quantityControls = document.querySelectorAll('.tha-quantity-control');
      quantityControls.forEach(function (control) {
          const input = control.querySelector('.tha-inputt');
          const plusButton = control.querySelector('.plus');
          const minusButton = control.querySelector('.minus');
          plusButton.addEventListener('click', function () {
              input.value = parseInt(input.value) + 1;
          });
          minusButton.addEventListener('click', function () {
              let value = parseInt(input.value);
              if (value > 1) {
                  input.value = value - 1;
              }
          });
      });
  });
 
</script>
  
 

</body>
</html>
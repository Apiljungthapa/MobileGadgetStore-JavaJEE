<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Shopping Cart</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/cart-list.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />

</head>

<body>

  <!-- Include header -->

  <jsp:include page="header.jsp" />

  <!-- Cart list start -->

  <section class="tha-cover-list">

      <div class="tha-container">

          <header class="tha-headerr">

              <h1 class="tha-text-xl">Shopping Cart</h1>

          </header>

          <div class="tha-main-content">

              <div class="tha-table-container">

                  

                     <form action="${pageContext.request.contextPath}/RemoveFromCartServlet" method="post">

    <table class="tha-tablee">

        <thead>

            <tr>

                <th>Image</th>

                <th>Product</th>

                <th>Price</th>

                <th>Discount</th>

                <th>Total</th>

                <th>Remove</th>

            </tr>

        </thead>

        <tbody>

    <c:set var="grandTotal" value="0" />

    <c:forEach var="product" items="${productsInCart}">

        <tr>

            <td><img src="${product.imageUrl}" alt="Product Image" style="max-width: 100px;"></td>

            <td>${product.productName}</td>

            <td>${product.price}</td>

            <td>${product.discount}%</td>

            <c:set var="total" value="${(product.price * product.discount / 100) * product.quantity}" />

            <td>RS.${total}</td>

            <td>

                <button type="submit" name="productId" value="${product.productID}" class="tha-rem-but">X</button>

            </td>

            <!-- Update grand total -->

            <c:set var="grandTotal" value="${grandTotal + total}" />

            

	        </tr>

	        

	   	 </c:forEach>

	

	</tbody>

	

	    </table>

	</form>



                  </tbody>

                  </table>

              </div>

              <div class="tha-btoon_cart">

                  <a href="${pageContext.request.contextPath}/FetchProdutsServlet"><button class="tha-button tha-button-primary">Continue Shopping</button></a>

                 

                  <!-- Display grand total -->

                  <p class="tha-ttll">All Total: Rs.<c:out value="${grandTotal}"/></p>

                  <form action="${pageContext.request.contextPath}/CheckOutServlet" method="post">

                  

                  

    				<input type="hidden" name="grandTotal" value="<c:out value='${grandTotal}' />">

                  

                  

                  <button class="tha-proc-but" type="submit">Proceed</button></a>

                  </form>

              </div>

          </div>

      </div>

  </section>

  <!-- Cart list end -->

  <!-- Include footer -->

  <jsp:include page="footer.jsp" />

  <!-- Footer ends -->

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

  

  

  <script>

    document.addEventListener('DOMContentLoaded', function() {

        const minusButtons = document.querySelectorAll('.minus');

        minusButtons.forEach(button => {

            button.addEventListener('click', function(event) {

                event.preventDefault();

                // Your minus button functionality here

            });

        });



        const plusButtons = document.querySelectorAll('.plus');

        plusButtons.forEach(button => {

            button.addEventListener('click', function(event) {

                event.preventDefault();

                // Your plus button functionality here

            });

        });

    });

</script>

</body>

</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    
      <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/thanku.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />
      
</head>
<body>

 <!-- nav start -->
 
 <jsp:include page="header.jsp" />

  <!-- nav end -->


<div class="mon-bodyiem">
    <div class="mon-main-container">
        <div class="mon-icon-check_circle">
            <svg viewBox="0 0 24 24" width="100" height="100">
                <path fill="currentColor" d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-1.41 14.59l-4.24-4.24L7.41 10l3.18 3.18L15.59 7l1.41 1.41-5.18 5.18z"></path>
            </svg>
        </div>
        <h2 class="mon-h2">Thank you!</h2>
        <p class="mon-lead">Your order was successfully completed.</p>
        <p class="mon-lead">We will contact you through phone or SMS soon.</p>
        <a href="${pageContext.request.contextPath}/FetchProdutsServlet" class="mon-btn-primary">Back to shop</a>
    </div>
</div>


  <!-- footer start -->
 
   <jsp:include page="footer.jsp" />
   
  <script src="${pageContext.request.contextPath}/js/home.js"></script>

  <!-- footer ends -->



</body>
</html>

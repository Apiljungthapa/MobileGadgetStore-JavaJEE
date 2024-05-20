<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    <!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8" />
  <title>Reset Password</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/login.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>

<!-- nav starts -->

<jsp:include page="header.jsp" />
<!-- nav ends -->

<!-- signin form start -->
<div class="ras-bodym">

  <div class="ras-container">
    <div class="ras-title">Login</div>
    <div class="ras-content">
      <form action="reset_password.jsp">
        <div class="ras-user-details">
          <div class="ras-input-box">
            <span class="details">Enter the Code</span>
            <input type="text" required />
          </div>
        </div>
        <div class="ras-button">
          <input type="submit" value="Confirm" />
        </div>
      </form>
    </div>
  </div>
</div>
<!-- signin form ends -->

<!-- footer starts -->

<jsp:include page="footer.jsp" />

<!-- footer ends -->

<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>
    
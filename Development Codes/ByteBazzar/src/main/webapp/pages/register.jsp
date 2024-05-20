<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
   <!DOCTYPE html>
	<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <title>ByteBazzar Signup</title>
     
      <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
         <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/register.css" />
      
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>
  <body>
    <!-- nav starts -->
    <jsp:include page="header.jsp" />
    <!-- nav ends -->

    <!-- register form start -->
    <div class="sab-bodyrrr">
      <div class="sab-container">
      
	   <c:if test="${not empty requestScope.valError}">
	    <div style="color: white; background-color: #d81c5c; padding: 15px; border-radius: 10px; margin-bottom: 15px;">
	        <c:out value="${requestScope.valError}" />
	    </div>
	   </c:if>
               
      
        <div class="sab-title">Registration</div>
        <div class="sab-content">
        
                   
          <form action="/ByteBazzar/RegisterServlet" method="post">
            <div class="sab-user-details">
              <div class="sab-input-box">
                <span class="details">Full Name</span>
                <input type="text" placeholder="Enter your name"  name="fullname_" required />
              </div>
              <div class="sab-input-box">
                <span class="details">User Name</span>
                <input type="text" placeholder="Enter your user name" name="userID_" required />
              </div> 
              <div class="sab-input-box">
                <span class="details">Email</span>
                <input type="text" placeholder="Enter your email" name="email_" required />
              </div>
              <div class="sab-input-box">
                <span class="details">Phone Number</span>
                <input type="tel" placeholder="Enter your number"  name="phoneNumber_" value="+977" required />
              </div>
              <div class="sab-input-box">
                <span class="details">Password</span>
                <input
                  type="password"
                  placeholder="Enter your password"
                  name="password_"
                  required
                />
              </div>
              <div class="sab-input-box">
                <span class="details">Confirm Password</span>
                <input
                  type="password"
                  placeholder="Confirm your password"
                  name="retypePassword_"
                  required
                />
              </div>
            </div>
            <div class="sab-role-details">
              <input type="radio" name="gender" id="sab-dot-1" value="Male"  required/>
              <input type="radio" name="gender" id="sab-dot-2" value="Female" required />
              <span class="sab-role-title">Gender</span>
              <div class="sab-category">
                <label for="sab-dot-1">
                  <span class="sab-dot one"></span>
                  <span class="gender">Male</span>
                </label>
                <label for="sab-dot-2">
                  <span class="sab-dot two"></span>
                  <span class="gender">Female</span>
                </label>
              </div>
            </div>
            <div class="sab-button">
              <input type="submit" value="Register" />
            </div>
            <p style="text-align: center">
              Already have an account? <a href="${pageContext.request.contextPath}/pages/login.jsp">Login</a>
            </p>
          </form>
        </div>
      </div>
    </div>
    <!-- register form close -->

    <!-- footer starts -->
    <jsp:include page="footer.jsp" />
    <!-- footer ends -->

    <script src="${pageContext.request.contextPath}/js/home.js"></script>
  </body>
</html>
   
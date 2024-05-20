<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/profile.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />

</head>
<body>

  <!-- nav start start -->
  <jsp:include page="header.jsp" />

  <!-- nav end end -->

    <div class="bodydy">
    <div class="sabbb-container">
    
  <c:set var="img" value="${requestScope.imgUsers}" />
   <c:forEach var="usr" items="${userDetail}">
     
        <c:if test="${not empty requestScope.nosuccpass}">
     	<div id="m" style="color: white; background-color: #d63a4c; padding: 10px;  border-radius: 10px; margin-bottom: 15px; display: flex; justify-content: space-between; align-items: center">
        <c:out value="${requestScope.nosuccpass}" />
        <button id="h" style="padding: 5px 13px;">X</button>
    	</div>
	</c:if>

     
        <!-- profile img form start -->
        <form action="/ByteBazzar/UpdatePhoto" method="post" enctype="multipart/form-data">
            <div class="sabbb-profile-section">
                <div class="sabbb-profile-info">
                    <img class="sabbb-profile-image" src="${img}" alt="">
                    
                   
                    
                    <div class="sabbb-profile-details">
                        <h2 class="sabbb-profile-name">${usr.fullName}</h2>
                        <p class="sabbb-profile-email">@${usr.userId}</p>
                        <!-- Button to trigger image upload -->
                        <label for="uploadImage" class="sabbb-btn sabbb-change-profile-btn">Change Profile</label>
                        <input type="file" id="uploadImage" name="profileImage"  accept="image/*" style="display: none;" accept="image/*">
                        <button type="submit" class="sabbb-btn sabbb-change-profile-btn" style="background-color:#2b7b76;">Save Profile</button> 
                    </div>
                    
                    
                </div>
            </div>
        </form>
        <!-- profile image form close -->
        
     <c:if test="${not empty requestScope.valError}">
    <div id="m" style="color: white; background-color: #37a980; padding: 10px;  border-radius: 10px; margin-bottom: 15px; display: flex; justify-content: space-between; align-items: center">
        <c:out value="${requestScope.valError}" />
        <button id="h" style="padding: 5px 13px;">X</button>
    </div>
</c:if>

	   
	   
        <!-- info form start -->
        <form action="/ByteBazzar/updateProfileServlet" method="post" onsubmit="return validateForm()">
        <div class="sabbb-settings-section">
            <h2 class="sabbb-section-title">Profile Settings</h2>
            <div class="sabbb-form">
                <div class="sabbb-form-grid">
                <input type="hidden" name="useride" value="${usr.userId}">
                    <div class="sabbb-form-group">
                        <label for="fulName">Full Name</label>
                        <input type="text" id="fulName" class="sabbb-form-control" name="fulName"  value="${usr.fullName}" >
                    </div>
                    <div class="sabbb-form-group">
                      <label for="email">Email Address</label>
                      <input type="email" id="email" class="sabbb-form-control" name="emaile" value="${usr.email}" disabled>
                  </div>
                </div>
                
                <div class="sabbb-form-grid">
                    <div class="sabbb-form-group">
                        <label for="phone">Phone</label>
                        <input type="tel" id="phone" class="sabbb-form-control" name="phonee" value="${usr.phoneNumber}"disabled>
                    </div>
                    
                </div>
                
                 <div class="sabbb-form-group">
                        <label for="floc">Address</label>
                        <input type="text" id="floc" class="sabbb-form-control" name="addre" value="${usr.fullAddress}">
                    </div>

                

                <button class="sabbb-btn sabbb-save-profile-btn" type="submit">Save Profile</button>
            </div>
        </div>
        </form>
        
         
        <!-- info form close -->

   <c:if test="${not empty requestScope.succpass}">
    <div id="m" style="color: white; background-color: #37a980; padding: 10px;  border-radius: 10px; margin-bottom: 15px; display: flex; justify-content: space-between; align-items: center">
        <c:out value="${requestScope.succpass}" />
        <button id="h" style="padding: 5px 13px;">X</button>
    </div>
	</c:if>
       
        <!-- change pass form start -->
       <form action="/ByteBazzar/UpdatePasswordServlet" method="post" onsubmit="return validateFormm()">
    <input type="hidden" name="userId" value="${usr.userId}">
    <div class="sabbb-experience-section">
        <h2 class="sabbb-section-title">Change Password</h2>
        <div class="sabbb-form">
            <div class="sabbb-form-group">
                <label for="currentPassword">Current Password</label>
                <input type="password" id="currentPassword" class="sabbb-form-control" name="currpass" placeholder="Enter current password">
            </div>
            <div class="sabbb-form-group">
                <label for="newPassword">New Password</label>
                <input type="password" id="newPassword" class="sabbb-form-control"  name="newpass" placeholder="Enter new password">
            </div>
            <div class="sabbb-form-group">
                <label for="confirmNewPassword">Retype New Password</label>
                <input type="password" id="confirmNewPassword" class="sabbb-form-control" name="confpass" placeholder="Confirm new password">
            </div>
            <button type="submit" class="sabbb-btn sabbb-save-profile-btn">Confirm Change</button>
        </div>
    </div>
</form>

        <!-- chage pass form end -->
    </div>
    </div>
    
  </c:forEach>

  <!-- footer start  -->
  
  <jsp:include page="footer.jsp" />


  <!-- footer ends -->

 <script src="${pageContext.request.contextPath}/js/home.js"></script>
 
 <script>
    function validateForm() {
        var fullName = document.getElementById("fulName").value.trim();
        var fulladd = document.getElementById("floc").value.trim();

        if (fullName === null || fullName === "") {
            alert("Full Name must not be empty.");
            return false;
        }

        if (!fullName.match(/^[a-zA-Z\s]+$/)) {
            alert("Full Name can only contain letters and spaces.");
            return false;
        }
        if (fulladd === null || fulladd === "") {
            alert("Full Address must not be empty.");
            return false;
        }
        if (!fulladd.match(/^[a-zA-Z\s]+$/)) {
            alert("Enter Valid Address.");
            return false;
        }

        return true;
    }
</script>

<script>
        function validateFormm() {
            var currentPassword = document.getElementById("currentPassword").value.trim();
            var newPassword = document.getElementById("newPassword").value.trim();
            var confirmNewPassword = document.getElementById("confirmNewPassword").value.trim();

            if (currentPassword === null || currentPassword === "") {
                alert("Please enter your current password.");
                return false;
            }

            if (newPassword.length <= 8 || !newPassword.match(/^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).*$/)) {
                alert("New password must be at least 8 characters long and contain at least one number, one special character, and one uppercase letter.");
                return false;
            }

            if (newPassword !== confirmNewPassword) {
                alert("New password and confirm new password must match.");
                return false;
            }

            return true;
        }
    </script>

<script>
    document.getElementById("h").addEventListener("click", function() {
        document.getElementById("m").style.display = "none";
    });
</script>
 
</body>
</html>
    
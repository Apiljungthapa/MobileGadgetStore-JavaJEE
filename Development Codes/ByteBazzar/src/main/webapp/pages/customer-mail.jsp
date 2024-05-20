<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Message View</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />
</head>
<body>

<section class="assmi-bodyiie">
    <div class="assmi-message-container">
        <div class="assmi-profile">
            <img src="../images/miraj.jpg" alt="Profile Picture">
        </div>
        <div class="assmi-user-details">
            <h2 class="assmi-username">John Doe</h2>
            <ul class="assmi-user-info">
                <li><strong>Email:</strong> john.doe@example.com</li>
                <li><strong>Contact:</strong> +1234567890</li>
                <li><strong>Address:</strong> 123 Main Street, Anytown, USA</li>
                <li><strong>Created Date:</strong> 2020-01-04</li>
            </ul>
        </div>
        <div class="assmi-message-details">
            <h3 class="assmi-message-title"><span>Subject: </span>Inquiry about Product</h3>
            <hr>
            <p class="assmi-message-content">
                Hello, I am interested in learning more about your products. Can you provide additional information?
            </p>
        </div>
        <a href="mail_list.jsp" class="assmi-back-link"><button class="assmi-back-button">Back</button></a>
    </div>
</section>

</body>
</html>
    
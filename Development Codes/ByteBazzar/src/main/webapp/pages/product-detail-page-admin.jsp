<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Detail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />
</head>
<body>
    
<section class="api-bodyeel">
    <div class="api-container">
        <div class="api-product-detail">
            <div class="api-product-image">
    <img src="${selectedProducts[0].getImageUrl()}" alt="Product Image">
            </div>
            <div class="api-product-info">
                <h3><span class="api-hig-span-p">Product Name: </span>${selectedProducts[0].getProductName()}</h3>
                <hr style="margin-top: 15px; height: 2px; border: none; background-color: #000000; margin-bottom: 25px;">
                <p class="api-price"><span class="api-hig-span-ps">Price: </span>RS ${selectedProducts[0].getPrice()}</p>
                <ul class="api-specs">
                    <li><strong>Screen Size:</strong> ${selectedProducts[0].getScreenSize()} inches</li>
                    <li><strong>RAM:</strong> ${selectedProducts[0].getRam()} GB</li>
                    <li><strong>Processor:</strong> ${selectedProducts[0].getProcessor()}</li>
                    <li><strong>Storage:</strong> ${selectedProducts[0].getStorage()} GB</li>
                    <li><strong>Warranty:</strong> ${selectedProducts[0].getWarranty()} Year</li>
                    <li><strong>Camera:</strong> ${selectedProducts[0].getCamera()} MP</li>
                    <li><strong>Discount:</strong> ${selectedProducts[0].getDiscount()}%</li>
                </ul>
                
                <div class="api-features">
                    <hr style="margin-top: 15px; height: 2.5px; border: none; background-color: #000000; margin-bottom: 30px;">
                    <h3 class="api-hig-span-p">Features:</h3>
                    <p>${selectedProducts[0].getFeatures()}</p>
                </div>
            </div>
        </div>
        <a href="/ByteBazzar/FetchProductForAdmin"><button class="api-arb-back-pm">Back</button></a>
    </div>
</section>

</body>
</html>
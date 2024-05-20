<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />

    

    <title>Update Product</title>

</head>

<body>

    

<section class="arb-mid-mir">

    

  <div class="arb-conmir-container">

    <!-- Your other HTML content -->

    <div class="arb-conmir-form-container">

        <form action="/ByteBazzar/UpdateProductServlet" method="post" enctype="multipart/form-data">

            <div class="arb-conmir-form-grid">

                <!-- Access the first (and only) product in selectedProducts -->

                <c:if test="${not empty sessionScope.selectedProducts}">

                    <c:set var="product" value="${sessionScope.selectedProducts[0]}" />

                    

                     <div>

                    <label for="pID" class="arb-conmir-label">Product ID:</label>

                    <input type="text" id="pID" class="arb-conmir-input" placeholder="Enter Product ID"  name="pID" value="${product.productID}" required>

                	</div>

                    

                    <div>

                        <label for="pname" class="arb-conmir-label">Product Name:</label>

                        <input type="text" id="pname" class="arb-conmir-input" placeholder="Enter Product Name" name="pname" value="${product.productName}" required>

                    </div>

                    <div>

                        <label for="pprice" class="arb-conmir-label">Price:</label>

                        <input type="number" id="pprice" class="arb-conmir-input" placeholder="Enter Price" name="pprice" value="${product.price}" required>

                    </div>

                    

                    <div>

                    <label for="pram" class="arb-conmir-label">Ram:</label>

                    <input type="text" id="pram" class="arb-conmir-input" placeholder="Enter RAM" name="pram" value="${product.ram}" required>

                	</div>

                

                    <div>

                        <label for="psize" class="arb-conmir-label">Screen Size:</label>

                        <input type="text" id="psize" class="arb-conmir-input" placeholder="Enter Screen Size" name="psize" value="${product.screenSize}" required>

                    </div>

                    <div>

                        <label for="pproc" class="arb-conmir-label">Processor:</label>

                        <input type="text" id="pproc" class="arb-conmir-input" placeholder="Enter Processor" name="pproc" value="${product.processor}" required>

                    </div>

                    <div>

                        <label for="pimage" class="arb-conmir-label" >Previous Product Image:</label>

                        <img src="${product.imageUrl}" alt="Previous Product Image" width="100">

                    </div>

                    <div>

                        <label for="pimage" class="arb-conmir-label" >New Product Image:</label>

                        <input type="file" id="pimage" accept="image/*" class="arb-conmir-upload"  name="pimage2" required>

                    </div>

                    <div>

                        <label for="pstor" class="arb-conmir-label">Storage:</label>

                        <input type="text" id="pstor" class="arb-conmir-input" placeholder="Enter Phone Storage" name="pstor" value="${product.storage}" required>

                    </div>

                    <div>

                        <label for="pwar" class="arb-conmir-label">Warranty:</label>

                        <input type="text" id="pwar" class="arb-conmir-input" placeholder="Is Warranty Available?" name="pwar" value="${product.warranty}" required>

                    </div>

                    <div>

                        <label for="pcam" class="arb-conmir-label">Camera:</label>

                        <input type="text" id="pcam" class="arb-conmir-input" placeholder="Enter Camera Details" name="pcam" value="${product.camera}" required>

                    </div>

                    <div>

                        <label for="pdis" class="arb-conmir-label">Discount %</label>

                        <input type="number" id="pdis" class="arb-conmir-input" placeholder="Enter Discount" name="pdis" value="${product.discount}" required>

                    </div>

                    <div>

                        <label for="pfeat" class="arb-conmir-label">Features:</label>

                        <textarea id="pfeat" class="arb-conmir-textarea" rows="10" placeholder="Enter Phone Features" style="resize:none;" name="pfeat" required>${product.features}</textarea>

                    </div>

                </div>

            </c:if>

            <button type="submit" class="arb-conmir-button">UPDATE</button>

        </form>

    </div>

  </div>

</section>



</body>

</html>
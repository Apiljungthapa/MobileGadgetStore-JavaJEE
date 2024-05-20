<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />
    <title>Contact Form</title>
</head>
<body>
    
<section class="arb-mid-mir">
    
  <div class="arb-conmir-container">
    <a href="${pageContext.request.contextPath}/FetchProductForAdmin"><button class="arb-back-p">Back</button></a>
    <div class="arb-conmir-logo-container">
        <div class="arb-conmir-company-name">Add Product &nabla;&Delta;</div>
    </div>
    <div class="arb-conmir-form-container">
        <form action="/ByteBazzar/AddProductServlet" method="post" enctype="multipart/form-data">
            <div class="arb-conmir-form-grid">
            
                <div>
                    <label for="pID" class="arb-conmir-label">Product ID:</label>
                    <input type="text" id="pID" class="arb-conmir-input" placeholder="Enter Product ID"  name="pID" required>
                </div>
                
                <div>
                    <label for="pname" class="arb-conmir-label">Product Name:</label>
                    <input type="text" id="pname" class="arb-conmir-input" placeholder="Enter Product Name"  name="pname" required>
                </div>
                <div>
                    <label for="pprice" class="arb-conmir-label">Price:</label>
                    <input type="text" id="pprice" class="arb-conmir-input" placeholder="Enter Price"  name="pprice" required>
                </div>
                <div>
                    <label for="psize" class="arb-conmir-label">Screen Size:</label>
                    <input type="text" id="psize" class="arb-conmir-input" placeholder="Enter Screen Size" name="psize" required>
                </div>
                <div>
                    <label for="pram" class="arb-conmir-label">Ram:</label>
                    <input type="text" id="pram" class="arb-conmir-input" placeholder="Enter RAM" name="pram" required>
                </div>
                <div>
                    <label for="pproc" class="arb-conmir-label">Processor:</label>
                    <input type="text" id="pproc" class="arb-conmir-input" placeholder="Enter Processor"  name="pproc" required>
                </div>

                <div>
                    <label for="pimage" class="arb-conmir-label" >Product Image:</label>
                    <input type="file" id="pimage" name="pimage" accept="image/*" class="arb-conmir-upload"  name="pimage" required>
                </div>

                <div>
                    <label for="pbat" class="arb-conmir-label">Battery:</label>
                    <input type="text" id="pbat" class="arb-conmir-input" placeholder="Enter Battery"  name="pbat" required>
                </div>

                <div>
                    <label for="pstor" class="arb-conmir-label">Storage:</label>
                    <input type="text" id="pstor" class="arb-conmir-input" placeholder="Enter Phone Storage" name ="pstor" required>
                </div>

                <div>
                    <label for="pwar" class="arb-conmir-label">Warrenty:</label>
                    <input type="text" id="pwar" class="arb-conmir-input" placeholder="Is Warrenty Available?" name="pwar" required>
                </div>

                <div>
                    <label for="pcam" class="arb-conmir-label">Camera:</label>
                    <input type="text" id="pcam" class="arb-conmir-input" placeholder="Enter Camera Details" name="pcam" required>
                </div>

                <div>
                    <label for="pdis" class="arb-conmir-label">Discount %</label>
                    <input type="text" id="pdis" class="arb-conmir-input" placeholder="Enter Discount" name="pdis" required>
                </div>

                <div>
                    <label for="pfeat" class="arb-conmir-label">Features:</label>
                    <textarea id="pfeat" class="arb-conmir-textarea" rows="10" placeholder="Enter Phone Features" style="resize:none;" name="pfeat" required></textarea>
                </div>
                
            </div>
            <button type="submit" class="arb-conmir-button">ADD</button>
        </form>
    </div>
  </div>
</section>

</body>
</html>

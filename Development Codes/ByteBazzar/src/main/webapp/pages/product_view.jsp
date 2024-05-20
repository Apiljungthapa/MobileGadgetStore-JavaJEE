<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    



 <!DOCTYPE html>

<html lang="en">

  <head>

    <meta charset="UTF-8" />

    <meta

      name="viewport"

      content="width=device-width,initial-scale=1,maximum-scale=1"

    />

    <title>Product View</title>

   <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/admin.css" />

    <link

      rel="stylesheet"

      href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css"

    />

    

    



  </head>

  <body>

    <input type="checkbox" id="menu-toggle" />

     

      <jsp:include page="admin_sidebar.jsp" />



    <div class="main-content">

     <jsp:include page="admin_header.jsp" />

      



      <main>

        <div class="page-header">

          <h1>ByteBazzar Admin Panel</h1>

        </div>



        <!-- for displaying products -->



        <section class="product-listing-section">

          <div class="page-content">

          

          <%-- Check if a success message is present --%>

			<c:if test="${not empty successMessage}">

			    <div class="success-message">${successMessage}</div>

			</c:if>

			

            <a href="${pageContext.request.contextPath}/pages/add_product.jsp">

              <button class="add-btn-prod">Add Product</button>

            </a>



            <div class="records table-responsive">

              <div class="record-header">

                <div>

                  <h3>Products List</h3>

                </div>



                

              </div>



              <div>

                <table width="100%">

                  <thead>

                    <tr>

                      <th>Id</th>

                      <th><span class="las la-sort"></span> Product Name</th>

                      <th><span class="las la-sort"></span> RAM</th>

                      <th><span class="las la-sort"></span> Storage</th>

                      <th><span class="las la-sort"></span> Discount %</th>

                      <th><span class="las la-sort"></span> Price</th>

                      <th><span class="las la-sort"></span> ACTIONS</th>

                    </tr>

                  </thead>

                  <tbody>

                  

                  

                 <c:forEach var="product" items="${allProducts}" varStatus="loop">

    <tr>

        <td>${loop.index + 1}</td>

        <td>

            <div class="client">

                <img class="client-img" src="${product.imageUrl}" alt="Product Image">

                <div class="client-info">

                    <h4>${product.productName}</h4>

                </div>

            </div>

        </td>

        <td>${product.ram}</td>

        <td>${product.storage}</td>

        <td>${product.discount}</td>

        <td>RS ${product.price}</td>

        <td>

            <div class="actions">         

            

                <form action="${pageContext.request.contextPath}/ProductIdSent" method="post">

			    <input type="hidden" name="productId" value="${product.productID}">

			    <button type="submit" class="dev-act">

			        <span class="las la-edit"></span>

			    </button>

				</form>



                

                

                <a href="${pageContext.request.contextPath}/Product_detail_admin?productId=${product.productID}" class="dev-act">

                    <span class="las la-eye"></span>

                </a>

                

                <form action="${pageContext.request.contextPath}/DeleteProductByAdmin" method="post" id="deleteForm-${product.productID}">

			    <input type="hidden" name="productId" value="${product.productID}">

			    <button type="submit" class="dev-act" onclick="confirmDelete('${product.productID}')">

			        <span class="las la-trash-alt"></span>

			    </button>

				</form>

				

				

                

            </div>

        </td>

    </tr>

</c:forEach>



                    



                 



                   



                   

                  </tbody>

                </table>

              </div>

            </div>

          </div>

        </section>



        <!-- end of displaying products -->

      </main>

    </div>

  </body>

  

  <script>

	function confirmDelete(productID) {

		if (confirm("Are you sure you want to delete this Product: " + productID

				+ "?")) {

			document.getElementById("deleteForm-" + productID).submit();

		}

	}

</script>



</html>
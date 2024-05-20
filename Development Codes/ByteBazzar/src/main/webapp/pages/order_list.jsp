
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

    <title>Order-List</title>

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/stylesheets/admin.css"
    />

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

        <div class="page-content">
          <div class="analytics">
            <div class="card">
              <div class="card-head">
                <h2>${orderItemCount}</h2>

                <span class="las la-user-friends"></span>
              </div>

              <div class="card-progress">
                <small>User Orders</small>
              </div>
            </div>

            <div class="card">
              <div class="card-head">
                <h2>${pendingCount}</h2>

                <span class="las la-history"></span>
              </div>

              <div class="card-progress">
                <small>Pending Orders</small>
              </div>
            </div>

            <div class="card">
              <div class="card-head">
                <h2>${deliveredCount}</h2>

                <span class="las la-truck-loading"></span>
              </div>

              <div class="card-progress">
                <small>Order Delivered</small>
              </div>
            </div>
          </div>

          <div class="records table-responsive">
            <div class="record-header">
              <div>
                <h3>Customer Orders</h3>
              </div>
            </div>

            <div>
              <table width="100%">
                <thead>
                  <tr>
                   

                    <th><span class="las la-sort"></span> Customer Name</th>

                    <th><span class="las la-sort"></span> Product Id</th>

                    <th><span class="las la-sort"></span> Product Name</th>

                    <th><span class="las la-sort"></span> Amount</th>

                    <th><span class="las la-sort"></span> Status</th>

                   
                  </tr>
                </thead>

                <tbody>
                
              <c:forEach var="list" items="${listings}">
                  <tr>
                  

                    <td>
                      <div class="client">
                        <div
                          class="client-img bg-img"
                          style="background-image: url(${list.imageLink})" 
                        ></div>

                        <div class="client-info">
                          <h4>${list.customerName}</h4>

                          <small>@${list.id}</small>
                        </div>
                      </div>
                    </td>

                    <td>${list.productId}</td>

                    <td>${list.productName}</td>

                    <td>${list.amount}</td>

                    <td>${list.status}</td>

                  </tr>
</c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </main>
    </div>
  </body>
</html>

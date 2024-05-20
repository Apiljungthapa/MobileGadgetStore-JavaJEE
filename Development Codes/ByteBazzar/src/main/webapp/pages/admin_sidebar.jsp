<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   
<div class="sidebar">
      <div class="side-header">
        <h3>B<span>yteBazzar</span></h3>
      </div>

      <div class="side-content">
        <div class="profile">
          <h4>Miraj Deep Bhandari</h4>
        </div>

        <div class="side-menu">
          <ul>
          
          <li>
              <a href="${pageContext.request.contextPath}/FetchProductForAdmin">
                <span class="las la-mobile"></span>
                <small> Products</small>
              </a>
            </li>
            
            <li>
              <a href="${pageContext.request.contextPath}/ShowingAdminDetails">
                <span class="las la-shopping-cart"></span>
                <small>Orders</small>
              </a>
            </li>

            

          </ul>
        </div>
      </div>
    </div>
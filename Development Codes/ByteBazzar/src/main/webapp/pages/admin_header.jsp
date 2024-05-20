<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
  <div class="header-content">
    <label for="menu-toggle">
      <span class="las la-bars"></span>
    </label>

    <div class="header-menu">
      <div class="user">
        <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
          <button type="submit" class="logout-btnm">Logout</button>
        </form>
      </div>
    </div>
  </div>
</header>

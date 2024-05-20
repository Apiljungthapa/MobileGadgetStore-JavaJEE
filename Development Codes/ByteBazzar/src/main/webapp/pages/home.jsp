<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>
<meta charset="utf-8" />
<title>ByteBazzar Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>

	<!-- nav bar start -->
	<jsp:include page="header.jsp" />
	<!-- nav bar ends -->

	<!-- hero section start -->

	<!-- Hero Start -->
	<section class="hero">
		<div class="row container">
			<div class="column">
				<h2>ByteBazaar: Maximize Your Potential with Our Premium Mobile
					Phones and Tablets</h2>
				<p>"Welcome to ByteBazaar: Your Mobile Growth Hub! Explore our
					curated free tools and extensions to boost your business. From
					productivity to marketing, ByteBazaar has you covered. Elevate your
					mobile business today!"</p>
				<div class="buttons">
					<a href="#redirect-products" class="btn" id="shopbtn"> Shop Now
					</a> <a href="${pageContext.request.contextPath}/pages/about.jsp#con-redd"><button
							class="btn">Contact Us</button></a>
				</div>
			</div>
			<div class="column">
				<img src="${pageContext.request.contextPath}/images/selfie1.png" alt="heroImg" class="hero_img" />
			</div>
		</div>
		<img src="${pageContext.request.contextPath}/images/bg-bottom-hero.png" alt="" class="curveImg" />
	</section>
	<!-- Hero End-->

	<!-- card section start-->
	<section class="card-section">
		<div class="latest-title">
			<h2>Our Products</h2>
		</div>
		
		<c:set var="searchKeyword" value="${requestScope.search_keyword}" />
		
		<span id="redirect-products"></span>
		<form id="searchForm"  method="get" class="searchbar" action="${pageContext.request.contextPath}/FetchProdutsServlet">
			<div class="input-box">
				<i class="uil uil-search"></i> 
				<input id="searchInput" type="text" name="keyword" placeholder="Search here..."
               value="${empty search_keyword ? '' : search_keyword}" />
				<button type="submit" class="button">Search</button>
			</div>
		</form>

		<div class="card-list">
			
		<c:forEach var="product" items="${productList}">
    <div class="card-item">
        <section class="makecenter">
            <img src="${product.imageUrl}" alt="Card Image" /><br />
        </section>
        <span class="discount">${product.discount} % OFF</span>
        <h3>${product.productName}</h3>
        <section class="price-wrap">
            <form action="/ByteBazzar/ProductDetailServlet">
                <input type="hidden" name="product_" value="${product.productID}">
                <button type="submit" class="arrow">
                    <i class="fas fa-arrow-right card-icon"></i>
                </button>
            </form>
            <h4 style="margin-top: 46px; color:#e91e63; ">RS.${product.price}</h4>
        </section>
    </div>
</c:forEach>
			
		</div>

		
	</section>
	<!-- card section ends -->

	<!-- info section -->
	<section class="info">
		<div class="info-item">
			<section
				style="display: flex; align-items: center; justify-content: center">
				<img src="${pageContext.request.contextPath}/images/delivary-van.png" alt="del-logo" width="33%" />
				<h3>SHIPPING SERVICES</h3>
			</section>
			<p>we offer efficient shipping services that prioritize speed,
				reliability, and cost-effectiveness. Our deliveries are fast and
				always on time, with free shipping provided for all orders. We
				operate around the clock to ensure convenience and meet the diverse
				needs of our customers.</p>
		</div>

		<div class="info-item">
			<section
				style="display: flex; align-items: center; justify-content: center">
				<img src="${pageContext.request.contextPath}/images/return.png" alt="del-logo" width="33%" />
				<h3>RETURNS POLICIES</h3>
			</section>
			<p>Returning stuff is easy with us. If you need to send something
				back, just do it within the time limit and make sure it's still in
				good shape. You can get your money back, exchange it, or get store
				credit. And if you have any questions, our customer service team is
				ready to help.</p>
		</div>

		<div class="info-item cusSup">
			<section
				style="display: flex; align-items: center; justify-content: center">
				<img src="${pageContext.request.contextPath}/images/customer.png" alt="del-logo" width="30%" />
				<h3>CUSTOMER SUPPORT</h3>
			</section>
			<p>For customer support, you can easily reach out to us by
				leaving a message on our social media platforms or by using the
				contact form on our website's "Contact Us" page. We'll get back to
				you promptly to assist with any questions or concerns you may have.
			</p>
		</div>
	</section>

	<!-- info section ends -->
	<jsp:include page="footer.jsp" />
	<!-- footer section starts -->


	<script src="${pageContext.request.contextPath}/js/home.js"></script>
	
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ByteBazzar About Us</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/about.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/home.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/all.min.css" />

</head>
<body>

  <!-- nav start -->
  <jsp:include page="header.jsp" />
  <!-- nav end -->


  <div class="our-team">
    <h2>Our Team</h2>
  </div>

  <!-- developers info start -->
  <section class="about-us">

    <div class="container">

        <div class="person">
            <div class="image-placeholder"></div> <!-- Placeholder for image -->
            <div class="text">
              <h2>Miraj Bhandari</h2>
              <h5>AI Engineer</h5>
              <p>
                I am Miraj Deep Bhandari, an AI Engineer passionate about leveraging technology for solving complex problems. My expertise spans machine learning, natural language processing, computer vision, and robotics. I enjoy developing innovative AI applications that have a positive impact on society. Continuous learning and collaboration drive my pursuit of pushing the boundaries of AI innovation.</p>
              <div class="data">
                <a href="https://www.linkedin.com/in/miraj-deep-bhandari-624bb0263/"  target="_blank"> <button class="but">Connect</button></a>
              </div>
            </div>
            <div class="image-placeholder"><img src="../images/miraj.jpg" class="image-placeholder"></div> <!-- Placeholder for image -->
          </div>
      
      <!-- New Person 1 -->
      <div class="person">
        <div class="image-placeholder"></div> <!-- Placeholder for image -->
        <div class="text">
          <h2>Apil Thapa</h2>
          <h5>Back-end Developer</h5>
          <p>
            I am Apil Thapa, a Backend Developer specializing in building robust and scalable systems. My expertise includes designing APIs, optimizing databases, and ensuring system security. I am passionate about creating efficient backend solutions that power seamless user experiences. Continuous improvement and problem-solving drive my approach to backend development.</p>
          <div class="data">
            <a href="https://www.linkedin.com/in/apil-thapa-3114a3255/"  target="_blank"> <button class="but">Connect</button></a>
          </div>
        </div>
        <div class="image-placeholder"><img src="../images/apil.jpg" class="image-placeholder"></div> <!-- Placeholder for image -->
      </div>
      
      <!-- New Person 2 -->
      <div class="person">
        <div class="image-placeholder"></div> <!-- Placeholder for image -->
        <div class="text">
          <h2>Arbit Bhandari</h2>
          <h5>UI/UX Designer</h5>
          <p>
            I am Arbit Bhandari, a UI/UX Designer dedicated to crafting intuitive and visually appealing digital experiences. My expertise includes user research, prototyping, and creating pixel-perfect designs. I am passionate about enhancing usability and user satisfaction through thoughtful design solutions. Continuously refining my skills and staying updated with design trends fuel my passion for UI/UX design.</p>
          <div class="data">
            <a href="https://www.linkedin.com/in/arbit-bhandari-714ba9215/"  target="_blank"> <button class="but">Connect</button></a>
          </div>
        </div>
        <div class="image-placeholder"><img src="../images/arbitp.jpg" class="image-placeholder"></div> <!-- Placeholder for image -->
      </div>
      
      <!-- New Person 3 -->
      <div class="person">
        <div class="image-placeholder"></div> <!-- Placeholder for image -->
        <div class="text">
          <h2>Shreyansh Shrestha</h2>
          <h5>Front-end Developer</h5>
          <p>
            I am Shreyansh Shrestha, a Front-end Developer skilled in building responsive and interactive web applications. My expertise includes HTML, CSS, JavaScript, and modern front-end frameworks like React. I am passionate about creating engaging user interfaces that deliver seamless digital experiences. Continuously learning and implementing new technologies drive my commitment to front-end development.</p>
          <div class="data">
            <a href="https://www.instagram.com/its_shreeehere/" target="_blank"> <button class="but">Connect</button></a>
          </div>
        </div>
        <div class="image-placeholder"><img src="../images/shree.png" class="image-placeholder"></div>  <!-- Placeholder for image -->
      </div>
      
      <!-- New Person 4 -->
      <div class="person">
        <div class="image-placeholder"><img src="../images/ayub.jpg" class="image-placeholder"></div> <!-- Placeholder for image -->
        <div class="text">
          <h2>Ayub Bhatta</h2>
          <h5>Graphic Designer</h5>
          <p>
            I am Ayub Bhatta, a Graphic Designer specializing in creating captivating visual designs. My expertise includes graphic software proficiency, typography, and layout composition. I am passionate about translating ideas into compelling visuals that resonate with audiences. Continuously exploring new design trends and techniques fuels my creativity and dedication to graphic design.</p>
          <div class="data">
            <a href="https://www.linkedin.com/in/ayub-bhatta-31a6b3269/" target="_blank"> <button class="but">Connect</button></a>
          </div>
        </div>
        <div class="image-placeholder"></div> <!-- Placeholder for image -->
      </div>
      
    </div>
</section>
  <!-- developers info end -->

  <span id="con-redd"></span>
  <!-- contact form start -->
  <section class="mid-mir">
  <div class="conmir-container">
    <div class="conmir-logo-container">
        <div class="conmir-company-name">Contact Form &nabla;&Delta;</div>
    </div>
    <div class="conmir-form-container">
    
    <c:if test="${not empty requestScope.valError}">
    <div id="m" style="color: white; background-color: #37a980; padding: 10px;  border-radius: 10px; margin-bottom: 15px; display: flex; justify-content: space-between; align-items: center">
        <c:out value="${requestScope.valError}" />
        <button id="h" style="padding: 5px 13px;">X</button>
    </div>
	</c:if>
	
        <form action="/ByteBazzar/InquiryServlet"  method="post" onsubmit="return validateForm()">
            <div class="conmir-form-grid">
                <div>
                    <label for="fullname" class="conmir-label">Full Name</label>
                    <input type="text" id="fullname" class="conmir-input" placeholder="Enter First Name" name="fullname" required>
                </div>
                <div>
                    <label for="add" class="conmir-label">Address</label>
                    <input type="text" id="add" class="conmir-input" placeholder="Enter Address" name="addres" required>
                </div>
                <div>
                    <label for="phone" class="conmir-label">Phone</label>
                    <input type="tel" id="phone" class="conmir-input" placeholder="Enter your Phone" name="phon" required>
                </div>
                <div>
                    <label for="email" class="conmir-label">Email</label>
                    <input type="email" id="email" class="conmir-input" placeholder="Enter email address" name="emaill" required>
                </div>

                <div>
                  <label for="subject" class="conmir-label">Subject</label>
                  <input type="text" id="subject" class="conmir-input" placeholder="Enter Message Subject" name="subj" required>
              </div>
              
                <div>
                    <label for="message" class="conmir-label">Message</label>
                    <textarea id="message" class="conmir-textarea" rows="4" placeholder="Enter your message" name="mesg" required></textarea>
                </div>
            </div>
            <button type="submit" class="conmir-button">Submit</button>
        </form>
    </div>
  </div>
</section>
  <!-- contact us end -->

  
  <!-- footer start -->
  <jsp:include page="footer.jsp" />

  <script src="${pageContext.request.contextPath}/js/home.js"></script>

  <!-- footer ends -->
</body>

<script>
  function validateForm() {
    var fullname = document.getElementById("fullname").value;
    var address = document.getElementById("add").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var subject = document.getElementById("subject").value;
    var message = document.getElementById("message").value;

    // Regular expression for checking if the fullname contains only letters
    var fullnameRegex = /^[a-zA-Z\s]*$/;

    // Regular expression for checking if the phone contains only numbers
    var phoneRegex = /^\d+$/;

    if (fullname == "") {
      alert("Please enter your full name.");
      return false;
    }
    if (!fullnameRegex.test(fullname)) {
      alert("Full name should contain only letters.");
      return false;
    }
    if (address == "") {
      alert("Please enter your address.");
      return false;
    }
    if (phone == "") {
      alert("Please enter your phone number.");
      return false;
    }
    if (!phoneRegex.test(phone)) {
      alert("Phone number should contain only numbers.");
      return false;
    }
    if (email == "") {
      alert("Please enter your email address.");
      return false;
    }
    if (subject == "") {
      alert("Please enter the subject of your message.");
      return false;
    }
    if (message == "") {
      alert("Please enter your message.");
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
</html>

/**
 * InquiryServlet handles user inquiries.
 * This servlet is responsible for receiving inquiries via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.InquiryModel;
import util.StringUtils;

@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new InquiryServlet instance.
	 */
	public InquiryServlet() {

	}

	/**
	 * Handles HTTP POST requests sent to the servlet for submitting inquiries.
	 * Retrieves user session and user ID. If the user is not logged in, redirects
	 * to the login page. Retrieves inquiry subject, message, and generates a unique
	 * inquiry ID. Creates an InquiryModel object with the inquiry details. Adds the
	 * inquiry to the database and handles the result. If the inquiry is
	 * successfully added, forwards the user to the about page with a success
	 * message. If adding the inquiry fails, forwards the user to the about page
	 * with an error message. If there is an unexpected error, redirects the user to
	 * the logout servlet.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieving user session
		HttpSession userSession = request.getSession();
		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);
		// Redirect to login page if user is not logged in
		if (userId == null) {

			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
			return;
		}
		// Retrieving inquiry subject and message from request parameters
		String subject = request.getParameter("subj");
		String message = request.getParameter("mesg");
		String inquiryID = UUID.randomUUID().toString();

		String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		InquiryModel inq = new InquiryModel(inquiryID, userId, subject, createdAt, message);

		int result = dbController.addUserInquiry(inq);

		System.out.println(result);
		// Handling the result of adding the inquiry
		if (result == 1) {

			String errorMessage = "Your Message is Sucessfully Delivered !!!";
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher("/pages/about.jsp").forward(request, response);

		} else if (result == 0) {
			// If adding the inquiry fails, set error message attribute and forward to about
			// page
			String errorMessage = "Something Went Wrong Please Try Again Later !!!";
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher("/pages/about.jsp").forward(request, response);

		} else {
			// If there is an unexpected error, redirect to logout servlet
			response.sendRedirect(request.getContextPath() + "/LogoutServlet");

		}

		;

	}

}

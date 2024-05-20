/**
 * RegisterServlet handles user registration.
 * This servlet is responsible for processing user registration requests via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.UsersModel;
import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new RegisterServlet instance.
	 */
	public RegisterServlet() {
		super();

	}

	/**
	 * Handles HTTP POST requests sent to the servlet for user registration.
	 * Retrieves user registration details from request parameters. Validates user
	 * registration details such as user ID, full name, email, phone number, and
	 * password. Checks for data duplication in the database. Adds the new user to
	 * the database. Redirects the user to the login page after successful
	 * registration.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter(StringUtils.userFIELD);
		String fullname = request.getParameter("fullname_");
		String fullName = request.getParameter(StringUtils.FULLNAME_FIELD);
		String email = request.getParameter(StringUtils.EMAIL_FIELD);
		String phoneNumber = request.getParameter(StringUtils.PHONE_FIELD);
		String password = request.getParameter(StringUtils.PASSW_FIELD);
		String retypePassword = request.getParameter(StringUtils.REPASSW_FIELD);
		String gender = request.getParameter(StringUtils.GENDER_FIELD);
		String role = StringUtils.ROLE_FIELD;

		// Validate user ID
		if (userID == null || userID.trim().isEmpty() || userID.length() < 6) {
			String errorMessage = StringUtils.USER_ID_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		// Check if fullName is null or empty
		if (fullName == null || fullName.trim().isEmpty()) {
			String errorMessage = StringUtils.FULL_NAME_NON;

			// Set error message in request attribute
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);

			// Forward the request to the JSP page
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return; // Stop further processing
		}

		if (!fullName.matches("[a-zA-Z\\s]+")) {

			String errorMessage = StringUtils.FULL_NAME_NON;

			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);

			// Forward the request to the JSP page
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		// Validate email format
		if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			String errorMessage = StringUtils.EMAIL_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		if (phoneNumber.length() != "+977".length() + 10) {
			String errorMessage = StringUtils.PHONE_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		// Validate password complexity and match with retype password
		if (password.length() <= 8 || !password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).*$")) {
			String errorMessage = StringUtils.PASSW_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		if (!password.equals(retypePassword)) {

			String errorMessage = StringUtils.PASSW_NON_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		// Check for data duplication
		if (dbController.checkDuplicacy(userID, StringUtils.CHECK_DUP_ID)
				|| dbController.checkDuplicacy(email, StringUtils.CHECK_DUP_EMAIL)
				|| dbController.checkDuplicacy(phoneNumber, StringUtils.CHECK_DUP_NUMBER)) {

			String errorMessage = StringUtils.DUPLICACY_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			return;
		}

		UsersModel usermodel = new UsersModel(userID, fullName.toUpperCase(), email, password, phoneNumber, gender,
				role);
		int result = dbController.addUser(usermodel);

		if (result == 1) {

			response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);

		} else if (result == 0) {

			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);

		} else {

			String errorMessage = StringUtils.SERVER_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);

		}

	}

}

/**
 * LoginServlet handles user login functionality.
 * This servlet is responsible for processing login requests via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new LoginServlet instance.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for user login. Retrieves user
	 * ID and password from request parameters. Performs user authentication using
	 * the database controller. Sets session attributes based on user role and
	 * redirects to respective dashboards. If login fails, sets appropriate error
	 * messages and forwards to the login page.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter(StringUtils.USER_FIELD);
		String password = request.getParameter(StringUtils.PASS_FIELD);

		// Perform user authentication
		int loginResult = dbController.getUserLoginInfo(userId, password);

		if (loginResult == 1) {
			// User is an admin
			HttpSession adminSession = request.getSession();
			adminSession.setAttribute(StringUtils.ISADMIN, true);
			adminSession.setAttribute(StringUtils.SESSION_DATA, userId);
			adminSession.setMaxInactiveInterval(30 * 60);
			// Redirect to admin dashboard
			response.sendRedirect(request.getContextPath() + "/FetchProductForAdmin");
		} else if (loginResult == 2) {
			// User is a regular user
			HttpSession userSession = request.getSession();
			userSession.setAttribute(StringUtils.ISADMIN, false);
			userSession.setAttribute(StringUtils.SESSION_DATA, userId);
			userSession.setMaxInactiveInterval(30 * 60);
			// Redirect to user dashboard
			response.sendRedirect(request.getContextPath() + "/FetchProdutsServlet");
		} else if (loginResult == 3)

		{
			String errorMessage = StringUtils.ROLE_USER_NOT;

			request.setAttribute(StringUtils.ERROR, errorMessage);

			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);

		} else if (loginResult == 4) {
			String errorMessage = StringUtils.PASS_NOT;

			request.setAttribute(StringUtils.ERROR, errorMessage);

			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);

		}

		else if (loginResult == 0) {
			String errorMessage = StringUtils.ACCOUNT_NOT;

			request.setAttribute(StringUtils.ERROR, errorMessage);

			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);

		}

		else {

			String errorMessage = StringUtils.SERVER_NOT;

			request.setAttribute(StringUtils.ERROR, errorMessage);

			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);

		}

	}
}

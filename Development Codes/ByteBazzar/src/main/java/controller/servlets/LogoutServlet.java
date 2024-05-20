/**
 * LogoutServlet handles user logout functionality.
 * This servlet is responsible for processing logout requests via HTTP GET and POST methods.
 */
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new LogoutServlet instance.
	 */
	public LogoutServlet() {

	}

	/**
	 * Handles HTTP GET requests sent to the servlet. Redirects to doPost method for
	 * processing.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for logging out users. Removes
	 * cookies related to the user session. Invalidates the user session (if it
	 * exists). Redirects the user to the login page.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setValue("");
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}

		// Invalidate user session (if it exists)
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// Redirect to login page
		response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);

	}

}

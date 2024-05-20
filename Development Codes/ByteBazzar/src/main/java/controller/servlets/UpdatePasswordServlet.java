/**
 * UpdatePasswordServlet handles the update of user passwords.
 * This servlet is responsible for processing requests to update user passwords via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import util.StringUtils;

@WebServlet(urlPatterns = { "/UpdatePasswordServlet" })
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new UpdatePasswordServlet instance.
	 */
	public UpdatePasswordServlet() {
		super();
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for updating user passwords.
	 * Retrieves user ID, current password, new password, and confirmation password
	 * from request parameters. Validates the complexity of the new password and
	 * checks if it matches the confirmation password. Updates the user password in
	 * the database if validation passes. Redirects the user to the profile page
	 * with success or error messages accordingly.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("userId");
		String currentPass = request.getParameter("currpass");
		String newPass = request.getParameter("newpass");
		String confPass = request.getParameter("confpass");

		// Validate password complexity and match with retype password
		if (newPass.length() <= 8 || !newPass.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).*$")) {
			String errorMessage = StringUtils.PASSW_NON;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			System.out.println("Updatepassservlet error 1");
			return;
		}

		if (!newPass.equals(confPass)) {
			String errorMessage = StringUtils.PASSW_NON_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			System.out.println("Updatepassservlet error 2");
			return;
		}

		int passChangeResult = dbController.changeLoginInfo(userID, currentPass, newPass);

		if (passChangeResult == 1) {

			String successPass = "Password Sucessfully Changed";

			request.getSession().setAttribute("pass", successPass);

			response.sendRedirect(request.getContextPath() + "/ProfileServlet?success=true");

		} else if (passChangeResult == 4) {

			String successnoPass = "Your Current Password Did not Matches";

			request.getSession().setAttribute("nopass", successnoPass);

			response.sendRedirect(request.getContextPath() + "/ProfileServlet?success=true");

		} else {
			response.sendRedirect(request.getContextPath() + "/LogoutServlet");
		}
	}
}

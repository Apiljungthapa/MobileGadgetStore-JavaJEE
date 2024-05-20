/**
 * Servlet implementation class updateProfileServlet
 * updateProfileServlet handles the updating of user profiles.
 * This servlet processes requests to update user profile details via HTTP PUT method.
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

@WebServlet(asyncSupported = true, urlPatterns = { "/updateProfileServlet" })
public class updateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new updateProfileServlet instance.
	 */
	public updateProfileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Handles HTTP POST requests sent to the servlet for updating user profiles.
	 * Forwards the request to the doPut method for processing.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPut(request, response);
	}

	/**
	 * Handles HTTP PUT requests sent to the servlet for updating user profiles.
	 * Retrieves user details from request parameters and updates the user profile
	 * in the database. Redirects the user to the appropriate page with success or
	 * error messages.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("useride");
		String fullName = request.getParameter("fulName");
		String Address = request.getParameter("addre");

		UsersModel usermodel = new UsersModel(userID, fullName, Address);

		int result = dbController.userProfileUpdate(usermodel);

		if (result == 1) {

			String successMessage = "Profile Sucessfully Updated";

			request.getSession().setAttribute(StringUtils.ERROR_VAL, successMessage);

			response.sendRedirect(request.getContextPath() + "/ProfileServlet?success=true");

		} else if (result == 0) {

			request.getRequestDispatcher("/ProfileServlet").forward(request, response);

		} else {

			response.sendRedirect(request.getContextPath() + "/LogoutServlet");
		}

	}

}

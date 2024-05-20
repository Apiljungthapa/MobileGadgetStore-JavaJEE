/**
 * RemoveFromCartServlet handles removal of items from the cart.
 * This servlet is responsible for processing requests to remove items from the cart via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new RemoveFromCartServlet instance.
	 */
	public RemoveFromCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for removing items from the
	 * cart. Retrieves the product ID of the item to be removed from the request
	 * parameter. Deletes the item from the cart in the database. Redirects the user
	 * to the cart display page after successful removal.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");

		int rowsAffected = dbController.deletecart(productId);

		if (rowsAffected > 0) {
			response.sendRedirect(request.getContextPath() + "/DisplayToCart");
		}

		else {

			response.sendRedirect("/pages/home.jsp");
		}

	}
}
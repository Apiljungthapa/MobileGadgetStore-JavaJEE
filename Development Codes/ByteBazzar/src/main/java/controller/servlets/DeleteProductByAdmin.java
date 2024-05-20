/**
 * DeleteProductByAdmin servlet handles the deletion of products by administrators.
 * This servlet is responsible for receiving requests to delete products via HTTP DELETE method.
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

@WebServlet("/DeleteProductByAdmin")
public class DeleteProductByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController dbController;

	/**
	 * Constructs a new DeleteProductByAdmin servlet instance.
	 */
	public DeleteProductByAdmin() {
		this.dbController = new DatabaseController();

	}

	/**
	 * Handles HTTP GET requests sent to the servlet. This method currently returns
	 * a message indicating that the servlet is served at a specific context path.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Handles HTTP POST requests sent to the servlet. This method retrieves the ID
	 * of the product to be deleted from the request parameters. If the ID is not
	 * null or empty, it triggers the doDelete method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deleteId = request.getParameter("productId");

		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}
	}

	/**
	 * Handles HTTP DELETE requests sent to the servlet. This method receives the ID
	 * of the product to be deleted from the request parameters. It triggers the
	 * deletion operation in the database controller and redirects the user based on
	 * the result.
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");

		// Get the productId from the request
		String productId = req.getParameter(StringUtils.PROD_ID);

		// Delete the product and get the result
		int result = dbController.deleteStudentInfo(productId);

		// Debugging: Print productId and result to console
		System.out.println("Product ID: " + productId);

		System.out.println("Delete Result: " + result);

		// Check the result of the deletion operation
		if (result == 1) {
			// Deletion successful: Set success message attribute and redirect
			req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.ADMIN_FETCH_PROD);
		} else {
			// Deletion failed: Set error message attribute and redirect
			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PRODUCT_VIEW_PAGE);
		}

	}
}
package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.CartsModel;
import util.StringUtils;

//Servlet annotation to specify URL pattern for CartServlet
@WebServlet(asyncSupported = true, urlPatterns = { "/CartServlet" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DatabaseController instance for database interactions
	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new CartServlet instance.
	 */
	public CartServlet() {
		super();

	}

	/**
	 * Handles HTTP POST requests sent to the servlet for managing user's cart.
	 * Retrieves user and product information from request parameters. Checks if the
	 * product already exists in the user's cart to prevent duplication. Adds the
	 * product to the user's cart if it's not a duplicate. Redirects the user to
	 * appropriate pages based on the result of adding the product to the cart.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute(StringUtils.SESSION_DATA);
		String productId = request.getParameter(StringUtils.PROD_ID_CART);
		String cartId = StringUtils.CARD_ID;
		String quantity = request.getParameter(StringUtils.QUANT);

		// Checking for duplicate products in the cart
		if (dbController.checkDuplicacyy(userId, productId, StringUtils.CHECK_DUP_CART)) {
			String errorMessage = StringUtils.CART_ERROR_MSG;
			request.setAttribute("error", errorMessage);
			request.getRequestDispatcher(StringUtils.SINGLE_PAGE_PROD).forward(request, response);
			return;
		}
		// Creating a CartsModel object for the new cart item
		CartsModel cartmodel = new CartsModel(cartId, userId, productId, quantity);
		// Adding the product to the user's cart
		int result = dbController.addProductsCart(cartmodel);

		HttpSession adminSession = request.getSession();
		// Handling redirection based on the result of adding the product to the cart
		if (result == 1) {
			// Redirecting to fetch products servlet
			response.sendRedirect(request.getContextPath() + StringUtils.FETCH_PRODUCT_SERVLET);

			// change later

		} else if (result == 0) {

			request.getRequestDispatcher(StringUtils.REDIRECT_SERVLET).forward(request, response);

			// change later } else {

			String errorMessage = StringUtils.SERVER_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);

		}

	}

}
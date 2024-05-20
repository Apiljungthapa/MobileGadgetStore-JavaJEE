package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.CartsModel;
import model.ProductsModel;
import util.StringUtils;

@WebServlet("/CheckOutServlet")

public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new CheckOutServlet instance.
	 */
	public CheckOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for processing checkout.
	 * Retrieves user and cart information from session and request parameters.
	 * Fetches cart items from the database based on the user ID. Retrieves
	 * corresponding product details for each cart item. Populates a list with
	 * selected products for checkout. Sets attributes for chosen products and total
	 * amount in the request. Redirects the user to the order confirmation page.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieving user session and user ID
		HttpSession userSession = request.getSession();
		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);
		String total = request.getParameter(StringUtils.TOTAL_VAL);

		// Remove duplicate declaration of cardId
		String cardId = "";

		List<CartsModel> cartItems = dbController.getCartProduct(userId);

		ArrayList<ProductsModel> chooseproductsInCart = new ArrayList<>();

		for (CartsModel cartItem : cartItems) {

			String productId = cartItem.getProductId();

			String quantity = cartItem.getQuantity();

			// Assign the value of cartId
			cardId = cartItem.getCartId();

			ArrayList<ProductsModel> product = dbController.getProductbyID(productId);

			for (ProductsModel p : product) {

				p.setquantity(quantity);
			}

			chooseproductsInCart.addAll(product);
		}

		// for debugging purpose..
		if (chooseproductsInCart.isEmpty()) {

			System.out.println("The serv cart is empty.");

		} else {
			System.out.println("The serv cart is not empty. It contains " + chooseproductsInCart.size() + " products.");
		}

		request.setAttribute("chooseproductsInCart", chooseproductsInCart);

		request.setAttribute("grandTotal", total);

		// Set cardId in the session
		userSession.setAttribute("cardId", cardId);

		request.getRequestDispatcher(StringUtils.ORDER_CONFIRM).forward(request, response);
	}

}
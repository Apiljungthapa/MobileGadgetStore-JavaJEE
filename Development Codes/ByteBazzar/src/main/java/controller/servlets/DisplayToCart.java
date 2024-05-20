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

@WebServlet("/DisplayToCart")
public class DisplayToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	public DisplayToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession userSession = request.getSession();

		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);

		System.out.println("userId: " + userId);

		List<CartsModel> cartItems = dbController.getCartProduct(userId);

		ArrayList<ProductsModel> productsInCart = new ArrayList<>();

		int itemCount = cartItems.size();

		userSession.setAttribute("itemCount", itemCount);

		for (CartsModel cartItem : cartItems) {

			String productId = cartItem.getProductId();

			// Get the count of items in the cart / yesle chai database ma kati ota rows xa
			// dinxa

			String quantity = cartItem.getQuantity();

			userSession.setAttribute("productId", productId);

			ArrayList<ProductsModel> product = dbController.getProductbyID(productId);

			for (ProductsModel p : product) {
				p.setquantity(quantity);
			}

			productsInCart.addAll(product);

			if (productsInCart.isEmpty()) {

				System.out.println("The cart is empty.");

			} else {

				System.out.println("The cart is not empty. It contains " + productsInCart.size() + " products.");

			}

		}

		request.setAttribute("productsInCart", productsInCart);

		request.getRequestDispatcher(StringUtils.CART_VIEW_PAGE).forward(request, response);

	}

}
/**
 * Orderservlet handles order processing.
 * This servlet is responsible for processing order requests via HTTP POST method.
 */
package controller.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.CartsModel;
import model.Order_products;
import model.OrdersModel;
import util.StringUtils;

@WebServlet("/Orderservlet")
public class Orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new Orderservlet instance.
	 */
	public Orderservlet() {
		super();
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for processing orders.
	 * Retrieves session attributes for card ID and user ID. Generates a unique
	 * order ID. Retrieves order details such as total, address, city, and payment
	 * method from request parameters. Creates an OrdersModel object with the order
	 * details and adds it to the database. Retrieves cart details associated with
	 * the card ID. Adds order line items for each cart item to the database.
	 * Redirects the user to a thank you page after successful order processing.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cardId = (String) session.getAttribute("cardId");

		HttpSession userSession = request.getSession();
		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);
		String orderid = UUID.randomUUID().toString();

		String total = request.getParameter("grandTotal");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pay = request.getParameter("pay");

		System.out.println("cardId is" + cardId);
		System.out.println("total is" + total);

		String status = "pending";

		OrdersModel orders = new OrdersModel(orderid, userId, total, status, city, address, pay);

		int orderResult = dbController.addOrder(orders);

		if (orderResult != 1) {
			return;
		}

		List<CartsModel> cartDetails = dbController.getCartDetail(cardId);

		boolean success = true;

		for (CartsModel cartItem : cartDetails) {
			String productId = cartItem.getProductId();
			String Linequantity = cartItem.getQuantity();

			Order_products ordersprod = new Order_products(orderid, productId, Linequantity);

			int lineItemResult = dbController.addOrderLineItem(ordersprod);

			if (lineItemResult != 1) {
				success = false;
			}
		}

		if (success) {
			response.sendRedirect(request.getContextPath() + "/pages/thanku.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/pages/thanku.jsp");
		}
	}

}
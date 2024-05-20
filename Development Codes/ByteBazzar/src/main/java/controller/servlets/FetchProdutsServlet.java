/**
 * FetchProdutsServlet servlet retrieves products from the database and forwards them to the home page.
 * This servlet handles HTTP GET requests.
 */
package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.ProductsModel;
import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/FetchProdutsServlet" })
public class FetchProdutsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new FetchProdutsServlet instance.
	 */
	public FetchProdutsServlet() {
		super();

	}

	/**
	 * Handles HTTP GET requests sent to the servlet for fetching products.
	 * Retrieves user session and user ID. Retrieves cart item count for the user
	 * and sets it in the session. Retrieves search keyword from request parameters.
	 * Searches for products based on the keyword and retrieves matching products
	 * from the database. Forwards the product list and search keyword to the home
	 * page (home.jsp).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession userSession = request.getSession();

		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);

		int cartItemCount = dbController.getCartItemCount(userId);

		userSession.setAttribute("itemCount", cartItemCount);

		String keyword = request.getParameter("keyword");
		String searchPattern = "%" + keyword + "%"; // Correctly format the search pattern

		List<ProductsModel> searchedProducts = dbController.getProductbySearch(searchPattern);

		if (searchedProducts.isEmpty()) {
			// No matching products found, show all products
			List<ProductsModel> allProducts = dbController.getAllProductInfo();
			request.setAttribute("productList", allProducts);
			request.setAttribute("search_keyword", keyword);

		} else {
			// Matching products found, show the filtered list
			request.setAttribute("productList", searchedProducts);
			request.setAttribute("search_keyword", keyword);
		}

		// Forward to home.jsp
		request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
	}
}
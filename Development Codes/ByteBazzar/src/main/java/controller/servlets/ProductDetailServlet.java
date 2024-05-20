/**
 * ProductDetailServlet handles product detail retrieval.
 * This servlet is responsible for retrieving product details via HTTP GET method.
 */
package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.ProductsModel;

@WebServlet(asyncSupported = true, urlPatterns = { "/ProductDetailServlet" })
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new ProductDetailServlet instance.
	 */
	public ProductDetailServlet() {
		super();

	}

	/**
	 * Handles HTTP GET requests sent to the servlet for retrieving product details.
	 * Retrieves product ID from request parameter. Retrieves matching product
	 * details from the database. Forwards the matching product details to the
	 * single product page for display.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productIde = request.getParameter("product_");

		List<ProductsModel> matchedProducts = dbController.getProductbyID(productIde);
		// if else lagayeracheck garna parx if product not found redirection

		request.setAttribute("MatchingProducts", matchedProducts);
		request.getRequestDispatcher("/pages/singlepage-product.jsp").forward(request, response);

	}

}

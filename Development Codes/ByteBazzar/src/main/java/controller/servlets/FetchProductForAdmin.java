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

@WebServlet("/FetchProductForAdmin")
public class FetchProductForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	public FetchProductForAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductsModel> allProducts = dbController.getAllProductInfo();

		System.out.println("product size is" + allProducts.size());

		// Set product list as a request attribute
		request.setAttribute("allProducts", allProducts);

		// Forward the request to the admin page
		request.getRequestDispatcher("/pages/product_view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
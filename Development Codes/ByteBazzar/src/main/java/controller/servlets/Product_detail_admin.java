package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.ProductsModel;

/**
 * Servlet implementation class Product_detail_admin
 */
@WebServlet("/Product_detail_admin")

public class Product_detail_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	public Product_detail_admin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productid = request.getParameter("productId");

		System.out.println("id of admin panel is " + productid);

		ArrayList<ProductsModel> selectedProducts = dbController.getProductbyID(productid);

		System.out.println("size is " + selectedProducts.size());

		if (selectedProducts != null && !selectedProducts.isEmpty()) {

			HttpSession adminSession = request.getSession();

			adminSession.setAttribute("selectedProducts", selectedProducts);

			response.sendRedirect(request.getContextPath() + "/pages/product-detail-page-admin.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
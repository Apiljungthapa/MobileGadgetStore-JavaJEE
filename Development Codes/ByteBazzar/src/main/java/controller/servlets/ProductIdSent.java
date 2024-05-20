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

@WebServlet("/ProductIdSent")
public class ProductIdSent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	public ProductIdSent() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String updateid = request.getParameter("productId");

		System.out.println("updatefield" + updateid);

		ArrayList<ProductsModel> selectedProducts = dbController.getProductbyID(updateid);

		System.out.println("size is " + selectedProducts.size());

		if (selectedProducts != null && !selectedProducts.isEmpty()) {

			HttpSession adminSession = request.getSession();

			adminSession.setAttribute("selectedProducts", selectedProducts);

			response.sendRedirect(request.getContextPath() + "/pages/Adminupdate.jsp");

		}

	}

}
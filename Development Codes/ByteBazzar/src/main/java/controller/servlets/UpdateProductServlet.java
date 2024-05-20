/**
 * UpdateProductServlet handles the updating of product information.
 * This servlet processes requests to update product details via HTTP POST and PUT methods.
 */
package controller.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.DatabaseController;
import model.ProductsModel;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new UpdateProductServlet instance.
	 */
	public UpdateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for updating product
	 * information. Retrieves product ID and forwards the request to the doPut
	 * method for processing.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String produpdId = request.getParameter("pID");
//		String productName = request.getParameter("pname");
		System.out.println("p id is " + produpdId);
		if (produpdId != null && !produpdId.isEmpty()) {
			doPut(request, response);
		}
	}

	/**
	 * Handles HTTP PUT requests sent to the servlet for updating product
	 * information. Retrieves product details from request parameters and updates
	 * the product in the database. Redirects the user to the appropriate page with
	 * success or error messages.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("pID");

		String productName = request.getParameter("pname");

		String priceStr = request.getParameter("pprice");
		System.out.println("price is " + priceStr);

		String screenSize = request.getParameter("psize");

		String ram = request.getParameter("pram");

		String processor = request.getParameter("pproc");

		String battery = request.getParameter("pbat");

		String storage = request.getParameter("pstor");

		String warranty = request.getParameter("pwar");

		String camera = request.getParameter("pcam");

		String discountStr = request.getParameter("pdis");

		String features = request.getParameter("pfeat");

		Part image = request.getPart("pimage2");

		String imageFilename = image.getSubmittedFileName();

		System.out.println("name of file " + imageFilename);

		String uploadPath = "D:/workspace/ByteBazzar/src/main/webapp/images/product_images/" + imageFilename;

		String DataBase_img_url = request.getContextPath() + "/images/product_images/" + imageFilename;

		FileOutputStream fos = new FileOutputStream(uploadPath);

		InputStream is = image.getInputStream();

		try {

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		BigDecimal price = null;

		if (priceStr != null && !priceStr.isEmpty()) {

			price = new BigDecimal(priceStr);

		}
		System.out.println("id is " + productId);

		BigDecimal discount = null;

		if (discountStr != null && !discountStr.isEmpty()) {

			discount = new BigDecimal(discountStr);

		}

		BigDecimal discountamount = price.multiply(discount).divide(BigDecimal.valueOf(100));
		ProductsModel updatedProduct = new ProductsModel(productId, productName, screenSize, processor, ram, features,
				discount, storage, camera, warranty, price, discountamount, DataBase_img_url);
		System.out.println("Product ID: " + updatedProduct.getProductID());
		System.out.println("Product Name: " + updatedProduct.getProductName());
		System.out.println("Screen Size: " + updatedProduct.getScreenSize());
		System.out.println("Processor: " + updatedProduct.getProcessor());
		System.out.println("RAM: " + updatedProduct.getRam());
		System.out.println("Features: " + updatedProduct.getFeatures());
		System.out.println("Discount: " + updatedProduct.getDiscount());
		System.out.println("Storage: " + updatedProduct.getStorage());
		System.out.println("Camera: " + updatedProduct.getCamera());
		System.out.println("Warranty: " + updatedProduct.getWarranty());
		System.out.println("Price: " + updatedProduct.getPrice());
		System.out.println("Discount Amount: " + updatedProduct.getDiscountAmount());
		System.out.println("Database Image URL: " + updatedProduct.getImageUrl());

		int success = dbController.updateProductById(productId, updatedProduct);

		System.out.println("int: " + success);

		if (success == 1) {
			request.setAttribute("successMessage", "Product updated successfully.");
			response.sendRedirect(request.getContextPath() + "/FetchProductForAdmin");
		} else {
			// If the update was not successful, you can also set an error message
			request.setAttribute("errorMessage", "Failed to update product.");
			response.sendRedirect(request.getContextPath() + "/pages/Adminupdate.jsp");
		}

	}

}

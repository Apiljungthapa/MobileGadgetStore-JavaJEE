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
import util.StringUtils;

@MultipartConfig
@WebServlet("/AddProductServlet")
/**
 * The AddProductServlet class represents a servlet responsible for handling
 * requests related to adding products. This servlet extends the HttpServlet
 * class, making it capable of processing HTTP requests. It initializes a
 * DatabaseController instance to interact with the database.
 */
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	public AddProductServlet() {

		super();

	}

	/**
	 * Handles HTTP POST requests sent to the servlet for adding a new product to
	 * the database. Retrieves product information such as ID, name, price,
	 * specifications, and image from the request parameters. Saves the product
	 * image to a specified location on the server filesystem. Calculates discount
	 * amount based on the provided discount percentage. Creates a new ProductsModel
	 * object representing the product with the obtained information. Adds the
	 * product to the database using the DatabaseController instance. Redirects the
	 * user to appropriate pages based on the result of adding the product.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter(StringUtils.PID);

		String productName = request.getParameter(StringUtils.PNAME);

		String priceStr = request.getParameter(StringUtils.PPRICE);

		String screenSize = request.getParameter(StringUtils.PSIZE);

		String ram = request.getParameter(StringUtils.PRAM);

		String processor = request.getParameter(StringUtils.PPROC);

		String battery = request.getParameter(StringUtils.PBAT);

		String storage = request.getParameter(StringUtils.PSTOR);

		String warranty = request.getParameter(StringUtils.PWAR);

		String camera = request.getParameter(StringUtils.PCAM);

		String discountStr = request.getParameter(StringUtils.PDIS);

		String features = request.getParameter(StringUtils.PFEAT);

		Part image = request.getPart(StringUtils.PIMG);

		String imageFilename = image.getSubmittedFileName();

		String uploadPath = "D:/workspace/ByteBazzar/src/main/webapp/images/products_images/" + imageFilename;

		String DataBase_img_url = request.getContextPath() + "/images/products_images/" + imageFilename;

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

		BigDecimal discount = null;

		if (discountStr != null && !discountStr.isEmpty()) {

			discount = new BigDecimal(discountStr);

		}

		BigDecimal discountamount = price.multiply(discount).divide(BigDecimal.valueOf(100));

		ProductsModel product = new ProductsModel(productId, productName, screenSize, processor, ram, features,
				discount, storage, camera, warranty, price, discountamount, DataBase_img_url);

		int result = dbController.addProducts(product);

		if (result == 1) {

			request.getRequestDispatcher(StringUtils.ADMIN_HOME).forward(request, response);
			// need to change

		} else if (result == 0) {

			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			// need to change

		} else {

			String errorMessage = StringUtils.SERVER_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			// need to change

		}

	}

}
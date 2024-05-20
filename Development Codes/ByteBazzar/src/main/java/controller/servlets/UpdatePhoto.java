/**
 * Servlet implementation class UpdatePhoto
 * UpdatePhoto handles the updating of user profile photos.
 * This servlet processes requests to update user profile photos via HTTP POST method.
 */
package controller.servlets;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.DatabaseController;
import model.UsersModel;
import util.StringUtils;

@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/UpdatePhoto" })

public class UpdatePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DatabaseController dbController = new DatabaseController();

	/**
	 * Constructs a new UpdatePhoto instance.
	 */
	public UpdatePhoto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handling GET requests if needed
	}

	/**
	 * Handles HTTP POST requests sent to the servlet for updating user profile
	 * photos. Retrieves user ID from session, uploads the new profile image, and
	 * updates the user profile image URL in the database. Redirects the user to the
	 * appropriate page with success or error messages.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession userSession = request.getSession();
		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);

		Part image = request.getPart("profileImage");

		String imageFilename = image.getSubmittedFileName();

		String uploadPath = "D:/workspace/ByteBazzar/src/main/webapp/resources/images/users/" + imageFilename;

		String DataBase_img_url = request.getContextPath() + "/resources/images/users/" + imageFilename;

		try (InputStream is = image.getInputStream();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(uploadPath))) {
			byte[] data = new byte[is.available()];
			is.read(data);
			bos.write(data);
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("yeti ta print hunxa ta 1");
		UsersModel user = new UsersModel(DataBase_img_url, userId);

		System.out.println("yeti ta print hunxa ta 2");
		int result = dbController.addusersimg(user);

		if (result == 1) {
			response.sendRedirect(request.getContextPath() + "/ProfileServlet?success=true");
		} else if (result == 0) {
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		} else {
			String errorMessage = StringUtils.SERVER_NOT;
			request.setAttribute(StringUtils.ERROR_VAL, errorMessage);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		}
	}
}

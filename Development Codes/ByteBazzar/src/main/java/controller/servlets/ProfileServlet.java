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
import model.UsersModel;
import util.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/ProfileServlet" })
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController dbController = new DatabaseController();

	public ProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession userSession = request.getSession();
		String userId = (String) userSession.getAttribute(StringUtils.SESSION_DATA);

		if (userId == null) {
			// Redirect to login page or display an error message
			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
			return;
		}

		String successMessage = (String) request.getSession().getAttribute(StringUtils.ERROR_VAL);
		if (successMessage != null) {
			request.setAttribute(StringUtils.ERROR_VAL, successMessage);
			request.getSession().removeAttribute(StringUtils.ERROR_VAL);

		}

		String successMessagepass = (String) request.getSession().getAttribute("pass");
		if (successMessagepass != null) {
			request.setAttribute("succpass", successMessagepass);
			request.getSession().removeAttribute("pass");

		}

		String successMessagenopass = (String) request.getSession().getAttribute("nopass");
		if (successMessagenopass != null) {
			request.setAttribute("nosuccpass", successMessagenopass);
			request.getSession().removeAttribute("nopass");

		}

		String noServer = (String) request.getSession().getAttribute("noserver");
		if (noServer != null) {
			request.setAttribute("noser", successMessagenopass);
			request.getSession().removeAttribute("noserver");

		}

		List<UsersModel> userDetails = dbController.getProfileInfo(userId);
		String img_Url = dbController.getPhotoLink(userId);
		System.out.println(img_Url);

		request.setAttribute("imgUsers", img_Url);
		request.setAttribute("userDetail", userDetails);
		request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
	}

}

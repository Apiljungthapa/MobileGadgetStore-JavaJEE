package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);

		boolean isLoggedIn = session != null && session.getAttribute(StringUtils.SESSION_DATA) != null;
		boolean isAdmin = session != null && (Boolean.TRUE.equals(session.getAttribute(StringUtils.ISADMIN)));
		boolean isLoginPage = uri.endsWith(StringUtils.LOGIN_ENDS) || uri.endsWith(StringUtils.LOGIN_SERVLET_ENDS);
		boolean isRegisterPage = uri.endsWith(StringUtils.REGISTER_ENDS)
				|| uri.endsWith(StringUtils.REGISTER_SERVLET_ENDS);
		boolean isLogoutServlet = uri.endsWith(StringUtils.LOGOUT_SERVLET_ENDS);
		boolean isProfilePage = uri.endsWith(StringUtils.PROFILE_ENDS);
		boolean isCartPage = uri.endsWith("/cart-list.jsp");
		boolean cartPageServlet = uri.endsWith("/CartServlet");
		boolean isOrderListPage = uri.endsWith(StringUtils.ORDER_LIST_ENDS);
		boolean isCustomerMailPage = uri.endsWith(StringUtils.CUSTOMER_MAIL_ENDS);
		boolean isMailListPage = uri.endsWith(StringUtils.MAIL_LIST_ENDS);
		boolean isProductViewPage = uri.endsWith(StringUtils.PRODUCT_VIEW_ENDS);
		boolean isProductDetailAdminPage = uri.endsWith(StringUtils.PRODUCT_DETAIL_ADMIN_ENDS);
		boolean isAddProductPage = uri.endsWith(StringUtils.ADD_PRODUCT_ENDS);
		boolean AddProductServlet_ = uri.endsWith(StringUtils.AddProductServlet_);
		boolean fetchforadminservlet = uri.endsWith("/FetchProductForAdmin");
		boolean deleteproductbyadmin = uri.endsWith("/DeleteProductByAdmin");
		boolean updateproductbyadmin = uri.endsWith("/UpdateProductServlet");
		boolean sentproducttoadmin = uri.endsWith("/ProductIdSent");
		boolean adminjsppage = uri.endsWith("/Adminupdate.jsp");

		boolean orderlistservlet = uri.endsWith("/ShowingAdminDetails");
		boolean Product_detail_admin = uri.endsWith("/Product_detail_admin");
		boolean ShowingAdminDetails = uri.endsWith("/ShowingAdminDetails");
		boolean adminOnly_page = isOrderListPage || isCustomerMailPage || isMailListPage || isProductViewPage
				|| isProductDetailAdminPage || isAddProductPage || ShowingAdminDetails || AddProductServlet_
				|| fetchforadminservlet || deleteproductbyadmin || updateproductbyadmin || Product_detail_admin
				|| sentproducttoadmin || adminjsppage;

		boolean isStaticResource = uri.startsWith("/css/") || uri.startsWith("/js/") || uri.startsWith("/images/");
		if (isStaticResource || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".jpg")) {
			chain.doFilter(request, response); // Skip filtering for static resources
			return;
		}

		if (isLoggedIn) { // for login
			if (isAdmin) {
				if (isLoginPage || isRegisterPage) {
					res.sendRedirect(req.getContextPath() + "/ShowingAdminDetails");
					return;
				} else if (adminOnly_page || isLogoutServlet) { // admin ley user ko page herna na milna ko lagi

					chain.doFilter(request, response);
				}

				else { // admin ley user ko page herna kjoje order_list mai redirect gardine

					res.sendRedirect(req.getContextPath() + "/ShowingAdminDetails");
				}

			}

			else { // Normal user logic
				if (isLoginPage || isRegisterPage || adminOnly_page) {
					res.sendRedirect(req.getContextPath() + "/FetchProdutsServlet");
					return;
				}

				else {

					chain.doFilter(request, response);
				}
			}
		} else { // Not logged in

			if (isProfilePage || isOrderListPage || isCustomerMailPage || isMailListPage || isProductViewPage
					|| isProductDetailAdminPage || isAddProductPage || isCartPage || cartPageServlet || adminjsppage
					|| adminOnly_page) {
				res.sendRedirect(req.getContextPath() + StringUtils.LOGIN_PAGE);
				return;
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}
}
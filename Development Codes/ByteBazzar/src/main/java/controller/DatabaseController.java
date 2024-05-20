package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.CartsModel;
import model.CustomerTransaction;
import model.InquiryModel;
import model.Order_products;
import model.OrdersModel;
import model.PasswordEncryptionWithAes;
import model.ProductsModel;
import model.UsersModel;
import util.StringUtils;

//   for database connectivity
public class DatabaseController {

	private static final String system = null;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StringUtils.DRIVER);
		String url = StringUtils.CONN_LINK;
		String user = StringUtils.ID;
		String pass = StringUtils.PASS;
		return DriverManager.getConnection(url, user, pass);// returns connection object
	}

	// for adding user to database
	public int addUser(UsersModel usermodel) {

		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(StringUtils.INSERT_USER);

			// insert_student ko order sanga milna parxa check stringUtils class
			st.setString(1, usermodel.getUserId());
			st.setString(2, usermodel.getFullName());
			st.setString(3, usermodel.getEmail());
			st.setString(4, PasswordEncryptionWithAes.encrypt(usermodel.getUserId(), usermodel.getPassword()));
			st.setString(5, usermodel.getPhoneNumber());
			st.setString(6, usermodel.getGender());
			st.setString(7, usermodel.getRole());

			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	public int deleteStudentInfo(String productID) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_USER);
			st.setString(1, productID);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int getUserLoginInfo(String userId, String password) {
		try (Connection conn = getConnection();

				PreparedStatement st = conn.prepareStatement(StringUtils.GET_USER_INFO)) {

			// Set parameters for the prepared statement
			st.setString(1, userId);

			// Execute the query
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					String userDb = rs.getString(StringUtils.USER);
					String roleDb = rs.getString(StringUtils.USER_ROLE);
					String passwordDb = rs.getString(StringUtils.USER_CREDENTIALS);
					String decryptedPwd = PasswordEncryptionWithAes.decrypt(passwordDb, userDb);

					// Check if the provided credentials match the database records
					if (decryptedPwd != null && decryptedPwd.equals(password) && userDb.equals(userId)) {

						if (roleDb.equalsIgnoreCase(StringUtils.Role1) || roleDb.equalsIgnoreCase(StringUtils.Role2)) {

							return roleDb.equalsIgnoreCase(StringUtils.Role1) ? 1 : 2; // 1 for admin, 2 for regular
																						// user
						} else {

							return 3; // Role does not match

						}

					} else {

						return 4; // Username and/or Passwords do not match
					}

				} else {

					return 0; // No matching record found for the provided userId
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 to indicate an error occurred
		}
	}

	public int addProducts(ProductsModel productModel) {

		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(StringUtils.ADD_PRODUCTS);

			st.setString(1, productModel.getProductID());

			st.setString(2, productModel.getProductName());

			st.setString(3, productModel.getScreenSize());

			st.setString(4, productModel.getProcessor());

			st.setString(5, productModel.getRam());

			st.setString(6, productModel.getFeatures());

			st.setBigDecimal(7, productModel.getDiscount());

			st.setString(8, productModel.getStorage());

			st.setString(9, productModel.getCamera());

			st.setString(10, productModel.getWarranty());

			st.setBigDecimal(11, productModel.getDiscountAmount());

			st.setBigDecimal(12, productModel.getPrice());

			st.setString(13, productModel.getImageUrl());

			int result = st.executeUpdate();

			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			return -1;

		}

	}

	// Get allProducts for fetch
	public ArrayList<ProductsModel> getAllProductInfo() {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.Fetch_PRODUCTS);
			ResultSet result = st.executeQuery();

			ArrayList<ProductsModel> products_ = new ArrayList<>();

			while (result.next()) {
				ProductsModel product = new ProductsModel();
				product.setProductID(result.getString("Product_ID"));
				product.setProductName(result.getString("Product_Name"));
				product.setScreenSize(result.getString("Screen_Size"));
				product.setProcessor(result.getString("Processor"));
				product.setRam(result.getString("RAM"));
				product.setFeatures(result.getString("Features"));
				product.setDiscount(result.getBigDecimal("Discount"));
				product.setStorage(result.getString("Storage"));
				product.setCamera(result.getString("Camera"));
				product.setWarranty(result.getString("Warranty"));
				product.setPrice(result.getBigDecimal("Price"));
				product.setDiscountAmount(result.getBigDecimal("Discount_Amount"));
				product.setImageUrl(result.getString("Image"));
				products_.add(product);
			}

			return products_;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<ProductsModel> getProductbyID(String ProductID) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.ID_PRODUCTS);
			st.setString(1, ProductID);
			ResultSet result = st.executeQuery();

			ArrayList<ProductsModel> selected_products = new ArrayList<>();

			while (result.next()) {
				ProductsModel product = new ProductsModel();
				product.setProductID(result.getString("Product_ID"));
				product.setProductName(result.getString("Product_Name"));
				product.setScreenSize(result.getString("Screen_Size"));
				product.setProcessor(result.getString("Processor"));
				product.setRam(result.getString("RAM"));
				product.setFeatures(result.getString("Features"));
				product.setDiscount(result.getBigDecimal("Discount"));
				product.setStorage(result.getString("Storage"));
				product.setCamera(result.getString("Camera"));
				product.setWarranty(result.getString("Warranty"));
				product.setPrice(result.getBigDecimal("Price"));
				product.setDiscountAmount(result.getBigDecimal("Discount_Amount"));
				product.setImageUrl(result.getString("Image"));
				selected_products.add(product);
			}

			return selected_products;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null; // Return an empty list if an error occurs
		}
	}

	public ArrayList<ProductsModel> getProductbySearch(String SearchItem) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.SEARCH_PRODUCTS);
			st.setString(1, SearchItem);

			ResultSet result = st.executeQuery();

			ArrayList<ProductsModel> searched_products = new ArrayList<>();

			while (result.next()) {
				ProductsModel product = new ProductsModel();
				product.setProductID(result.getString("Product_ID"));
				product.setProductName(result.getString("Product_Name"));
				product.setScreenSize(result.getString("Screen_Size"));
				product.setProcessor(result.getString("Processor"));
				product.setRam(result.getString("RAM"));
				product.setFeatures(result.getString("Features"));
				product.setDiscount(result.getBigDecimal("Discount"));
				product.setStorage(result.getString("Storage"));
				product.setCamera(result.getString("Camera"));
				product.setWarranty(result.getString("Warranty"));
				product.setPrice(result.getBigDecimal("Price"));
				product.setDiscountAmount(result.getBigDecimal("Discount_Amount"));
				product.setImageUrl(result.getString("Image"));
				searched_products.add(product);

			}

			return searched_products;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null; // Return an empty list if an error occurs
		}
	}

	public int addProductsCart(CartsModel cart) {

		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(StringUtils.ADD_CART);

			st.setString(1, cart.getCartId());

			st.setString(2, cart.getUserId());

			st.setString(3, cart.getProductId());

			st.setString(4, cart.getQuantity());

			int result = st.executeUpdate();

			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			return -1;

		}

	}

	public ArrayList<CartsModel> getCartProduct(String userId) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.GET_CART);
			st.setString(1, userId);

			ResultSet result = st.executeQuery();

			ArrayList<CartsModel> cartProducts_ = new ArrayList<>();

			while (result.next()) {
				CartsModel cart = new CartsModel();

				cart.setCartId(result.getString("cart_id"));
				cart.setProductId(result.getString("Product_ID"));
				cart.setQuantity(result.getString("quantity"));
				cart.setUserId(result.getString("User_ID"));

				cartProducts_.add(cart);
			}

			return cartProducts_;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

// for profile

	public ArrayList<UsersModel> getProfileInfo(String userId) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.USER_QUERY);

			st.setString(1, userId);

			ResultSet result = st.executeQuery();

			ArrayList<UsersModel> usersDetails = new ArrayList<>();

			while (result.next()) {
				UsersModel user = new UsersModel();

				user.setFullName(result.getString("Full_Name"));
				user.setEmail(result.getString("Email"));
				user.setPhoneNumber(result.getString("Phone_Number"));
				user.setFullAddress(result.getString("ADDRESS"));
				user.setUserId(result.getString("User_ID"));
				usersDetails.add(user);
			}
			for (UsersModel user : usersDetails) {
				System.out.println("Full Name: " + user.getFullName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Phone Number: " + user.getPhoneNumber());
				System.out.println("Full Address: " + user.getFullAddress());
				System.out.println();
			}
			return usersDetails;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public int userProfileUpdate(UsersModel user) {

		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(StringUtils.UPDATE_USER);

			st.setString(1, user.getFullName());

			st.setString(2, user.getFullAddress());

			st.setString(3, user.getUserId());

			int result = st.executeUpdate();

			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			return -1;

		}

	}

	public int changeLoginInfo(String userId, String curpassword, String newpassword) {
		try (Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT User_ID, Password FROM users WHERE User_ID = ?")) {

			// Set parameters for the prepared statement
			System.out.println("check 1 " + userId);
			System.out.println("check 2 " + curpassword);
			System.out.println("check 3 " + newpassword);
			st.setString(1, userId);

			// Execute the query
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					String userDb = rs.getString("User_ID");
					System.out.println("check 1 " + userDb);
					String passwordDb = rs.getString("Password");
					System.out.println("check 2 " + passwordDb);

					String decryptedPwd = PasswordEncryptionWithAes.decrypt(passwordDb, userDb);
					System.out.println("check 3 " + decryptedPwd);

					// Check if the provided credentials match the database records
					if (decryptedPwd != null && decryptedPwd.equals(curpassword) && userDb.equals(userId)) {

						// Prepare the update statement
						PreparedStatement st1 = conn
								.prepareStatement("UPDATE users SET Password = ? WHERE User_ID = ?");
						st1.setString(1, PasswordEncryptionWithAes.encrypt(userId, newpassword)); // Set new encrypted
																									// password
						st1.setString(2, userId); // Set user ID for WHERE clause

						// Execute the update statement
						int rowsUpdated = st1.executeUpdate();

						if (rowsUpdated > 0) {
							return 1; // Successful password update
						} else {
							return -1; // Update failed
						}

					} else {
						return 4; // Incorrect current password
					}

				} else {
					return 0; // No matching record found for the provided userId
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 to indicate an error occurred
		}
	}

	public int addusersimg(UsersModel userModel) {

		try (Connection conn = getConnection()) {

//			System.out.println("yeti ta print hunxa ta");

			System.out.println("test1" + userModel.getImgLink());

			System.out.println("test2" + userModel.getUserId());

			PreparedStatement st = conn.prepareStatement(StringUtils.UPDATE_USER_IMG);

			st.setString(1, userModel.getImgLink());

			st.setString(2, userModel.getUserId());

			int result = st.executeUpdate();

			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();

			return -1;

		}

	}

	public String getPhotoLink(String userId) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.IMG_RETRIVAL_QUERY);

			st.setString(1, userId);

			ResultSet result = st.executeQuery();

			String link = null;
			while (result.next()) {
				link = result.getString("IMG_LINK");
			}

			return link;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// Handle the exception appropriately, e.g., logging or throwing a custom
			// exception
			return null; // Return null or handle the error differently based on your requirement
		}
	}

	public int addUserInquiry(InquiryModel inqury) {

		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(StringUtils.INSERT_INQUIRY);

			// insert_student ko order sanga milna parxa check stringUtils class
			st.setString(1, inqury.getInquiryID());
			st.setString(2, inqury.getUserID());
			st.setString(3, inqury.getSubject());
			st.setString(4, inqury.getCreatedAt());
			st.setString(5, inqury.getMessage());

			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}

	}

	public int deletecart(String productID) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement("DELETE FROM carts WHERE product_id = ?");
			st.setString(1, productID);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public boolean checkDuplicacyy(String columnValue, String columnValue2, String dbStatement) {
		try (Connection conn = getConnection()) {

			PreparedStatement st = conn.prepareStatement(dbStatement);
			st.setString(1, columnValue);
			st.setString(2, columnValue2);
			ResultSet rs = st.executeQuery();
			return rs.next(); // If rs.next() returns true, a duplicate exists
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return false;
		}
	}

	public int getCartItemCount(String userId) {
		int count = 0;
		try (Connection con = getConnection()) {
			PreparedStatement st = con
					.prepareStatement("SELECT COUNT(*) AS cartItemCount FROM carts WHERE user_id = ?");
			st.setString(1, userId); // Set the user ID parameter
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cartItemCount"); // Retrieve the count from the "cartItemCount" column
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		}
		return count;

	}

	public int addOrder(OrdersModel ordermodel) {
		try (Connection conn = getConnection()) {
			// Prepare the SQL statement
			String query = "INSERT INTO orders (Order_ID, User_ID, Total_Amount, Status, city, address, payment) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);

			// Set parameters for the statement
			statement.setString(1, ordermodel.getOrderId());
			statement.setString(2, ordermodel.getUserId());
			statement.setString(3, ordermodel.getTotalAmount());
			statement.setString(4, ordermodel.getStatus());
			statement.setString(5, ordermodel.getCity());
			statement.setString(6, ordermodel.getAddress());
			statement.setString(7, ordermodel.getPayment());

			// Execute the statement
			return statement.executeUpdate(); // Returns the number of rows affected
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 to indicate failure
		}
	}

	public List<CartsModel> getCartDetail(String cart_id) {
		List<CartsModel> cartDetails = new ArrayList<>();
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement("SELECT * FROM carts WHERE cart_id = ?");
			st.setString(1, cart_id); // Set the cart ID parameter
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String productId = rs.getString("product_id");
				String quantity = rs.getString("quantity");

				// Create a new CartsModel object with retrieved data
				CartsModel cartItem = new CartsModel();
				cartItem.setProductId(productId);
				cartItem.setQuantity(quantity);

				// Add the cart item to the list
				cartDetails.add(cartItem);
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
		}
		return cartDetails;
	}

	public int addOrderLineItem(Order_products ordersprod) {
		try (Connection conn = getConnection()) {
			// Prepare the SQL statement
			String query = "INSERT INTO order_products (Order_ID, Product_ID, Line_Quantity) VALUES (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);

			// Set parameters for the statement
			statement.setString(1, ordersprod.getOrderID());
			statement.setString(2, ordersprod.getProductID());
			statement.setString(3, ordersprod.getLineQuantity());

			// Execute the statement
			return statement.executeUpdate(); // Returns the number of rows affected
		} catch (SQLIntegrityConstraintViolationException ex) {
			System.out.println("Duplicate entry detected for Order_ID: " + ordersprod.getOrderID() + ", Product_ID: "
					+ ordersprod.getProductID());
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 to indicate failure
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 to indicate failure
		}
	}

	// public boolean checkRole(String userId)
	public boolean checkDuplicacy(String columnValue, String dbStatement) {
		try (Connection conn = getConnection()) {
			PreparedStatement st = conn.prepareStatement(dbStatement);
			st.setString(1, columnValue);
			ResultSet rs = st.executeQuery();
			return rs.next(); // If rs.next() returns true, a duplicate exists
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return false;
		}
	}

	public int getOrderCount() {
		int count = 0;
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement("SELECT COUNT(*) AS Order_Count FROM orders");

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				count = rs.getInt("Order_Count");
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return count;

	}

	public int getPendingCount() {
		int count = 0;
		try (Connection con = getConnection()) {
			String sql = "SELECT COUNT(*) AS Order_Count FROM orders WHERE status = 'Pending'";
			try (PreparedStatement st = con.prepareStatement(sql)) {
				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						count = rs.getInt("Order_Count");
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return count;
	}

	public int getdeliveredCount() {
		int count = 0;
		try (Connection con = getConnection()) {
			String sql = "SELECT COUNT(*) AS Order_Count FROM orders WHERE status = 'Delivered'";
			try (PreparedStatement st = con.prepareStatement(sql)) {
				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						count = rs.getInt("Order_Count");
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return count;
	}

	public int updateProductById(String ProductID, ProductsModel updatedProduct) {

		try (Connection conn = getConnection()) {
			System.out.println("product id: " + ProductID);

			PreparedStatement statement = conn.prepareStatement(StringUtils.UPDATE_QUERY_ADMIN);

			statement.setString(1, updatedProduct.getProductName());
			statement.setString(2, updatedProduct.getScreenSize());
			statement.setString(3, updatedProduct.getProcessor());
			statement.setString(4, updatedProduct.getRam());
			statement.setString(5, updatedProduct.getFeatures());
			statement.setBigDecimal(6, updatedProduct.getDiscount());
			statement.setString(7, updatedProduct.getStorage());
			statement.setString(8, updatedProduct.getCamera());
			statement.setString(9, updatedProduct.getWarranty());
			statement.setBigDecimal(10, updatedProduct.getPrice());
			statement.setBigDecimal(11, updatedProduct.getDiscountAmount());
			statement.setString(12, updatedProduct.getImageUrl());
			statement.setString(13, updatedProduct.getProductID());

			int rowsUpdated = statement.executeUpdate();

			return rowsUpdated > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			return 0;

		}

	}

	public ArrayList<OrdersModel> getAllOrders() {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.FETCH_ORDERS);
			ResultSet result = st.executeQuery();

			ArrayList<OrdersModel> orders = new ArrayList<>();

			while (result.next()) {
				OrdersModel order = new OrdersModel();

				order.setOrderId(result.getString("Order_ID"));
				order.setUserId(result.getString("User_ID"));
				order.setTotalAmount(result.getString("Total_Amount"));
				order.setStatus(result.getString("Status"));
				order.setCity(result.getString("city"));
				order.setAddress(result.getString("address"));
				order.setPayment(result.getString("payment"));

				orders.add(order);
			}

			return orders;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<CustomerTransaction> getAllOrdersDetails() {
		List<CustomerTransaction> ordersCum = new ArrayList<>();
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtils.LIST_ORDERS);
			ResultSet result = st.executeQuery();

			while (result.next()) {

				CustomerTransaction orderdetails = new CustomerTransaction();

				orderdetails.setId(result.getString("Id"));
				orderdetails.setCustomerName(result.getString("Customer_Name"));
				orderdetails.setProductId(result.getString("Product_Id"));
				orderdetails.setProductName(result.getString("Product_Name"));
				orderdetails.setAmount(result.getString("Amount"));
				orderdetails.setStatus(result.getString("Status"));
				orderdetails.setImageLink(result.getString("Image_Link"));

				ordersCum.add(orderdetails);
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return ordersCum;
	}

}
package model;

public class CartsModel {

	private String cartId;

	private String userId;

	private String productId;

	private String quantity;

	public CartsModel() {

	}
	// Constructor

	public CartsModel(String cartId, String userId, String productId, String quantity) {

		this.cartId = cartId;

		this.userId = userId;

		this.productId = productId;

		this.quantity = quantity;

	}

	// Getters and Setters

	public String getCartId() {

		return cartId;

	}

	public void setCartId(String cartId) {

		this.cartId = cartId;

	}

	public String getUserId() {

		return userId;

	}

	public void setUserId(String userId) {

		this.userId = userId;

	}

	public String getProductId() {

		return productId;

	}

	public void setProductId(String productId) {

		this.productId = productId;

	}

	public String getQuantity() {

		return quantity;

	}

	public void setQuantity(String quantity) {

		this.quantity = quantity;

	}

}
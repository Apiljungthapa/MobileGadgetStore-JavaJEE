package model;

public class Order_products {
	private String orderID;
	private String productID;
	private String lineQuantity;

	// Constructors
	public Order_products() {
	}

	public Order_products(String orderID, String productID, String lineQuantity) {
		this.orderID = orderID;
		this.productID = productID;
		this.lineQuantity = lineQuantity;
	}

	// Getters and setters
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getLineQuantity() {
		return lineQuantity;
	}

	public void setLineQuantity(String lineQuantity) {
		this.lineQuantity = lineQuantity;
	}
}
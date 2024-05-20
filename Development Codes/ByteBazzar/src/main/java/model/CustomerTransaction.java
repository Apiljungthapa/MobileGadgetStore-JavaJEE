package model;

public class CustomerTransaction {
	private String id;
	private String customerName;
	private String productId;
	private String productName;
	private String amount;
	private String status;
	private String imageLink;

	// Constructors
	public CustomerTransaction(String id, String customerName, String productId, String productName, String amount,
			String status, String imageLink) {
		this.id = id;
		this.customerName = customerName;
		this.productId = productId;
		this.productName = productName;
		this.amount = amount;
		this.status = status;
		this.imageLink = imageLink;
	}

	public CustomerTransaction() {

	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
}

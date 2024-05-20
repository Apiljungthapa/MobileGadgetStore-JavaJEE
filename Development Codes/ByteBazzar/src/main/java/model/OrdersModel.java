package model;

public class OrdersModel {
	private String orderId;
	private String userId;
	private String totalAmount;
	private String status;
	private String city;
	private String address;
	private String payment;

	// Constructors
	public OrdersModel(String orderId, String userId, String totalAmount, String status, String city, String address,
			String payment) {
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.city = city;
		this.address = address;
		this.payment = payment;
	}

	public OrdersModel(String orderId, String userId, String totalAmount, String status) {
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public OrdersModel() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

}
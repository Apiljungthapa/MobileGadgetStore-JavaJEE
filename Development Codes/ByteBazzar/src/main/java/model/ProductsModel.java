package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductsModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String productID;
	private String productName;
	private String screenSize;
	private String processor;
	private String ram;
	private String features;
	private BigDecimal discount;
	private String storage;
	private String camera;
	private String warranty;
	private BigDecimal price;
	private BigDecimal discountAmount;
	private String imageUrl;

	private String quantity;

	public ProductsModel() {

	}

	public ProductsModel(String productID, String productName, String screenSize, String processor, String ram,
			String features, BigDecimal discount, String storage, String camera, String warranty, BigDecimal price,
			BigDecimal discountAmount, String imageUrl) {
		this.productID = productID;
		this.productName = productName;
		this.screenSize = screenSize;
		this.processor = processor;
		this.ram = ram;
		this.features = features;
		this.discount = discount;
		this.storage = storage;
		this.camera = camera;
		this.warranty = warranty;
		this.price = price;
		this.discountAmount = discountAmount;
		this.imageUrl = imageUrl;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

}

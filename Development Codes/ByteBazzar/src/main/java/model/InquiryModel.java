package model;

public class InquiryModel {
	private String inquiryID;
	private String userID;
	private String subject;
	private String createdAt;
	private String message;

	// Constructors
	public InquiryModel() {
	}

	public InquiryModel(String inquiryID2, String userId2, String subject, String createdAt, String message) {
		this.inquiryID = inquiryID2;
		this.userID = userId2;
		this.subject = subject;
		this.createdAt = createdAt;
		this.message = message;
	}

	// Getters and setters
	public String getInquiryID() {
		return inquiryID;
	}

	public void setInquiryID(String inquiryID) {
		this.inquiryID = inquiryID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

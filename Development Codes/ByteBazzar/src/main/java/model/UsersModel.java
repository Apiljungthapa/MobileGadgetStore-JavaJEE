
package model;

import java.io.Serializable;

public class UsersModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String fullName;

	private String email;

	private String password;

	private String phoneNumber;

	private String gender;

	private String role;

	private String fullAddress;

	private String imgLink;

	public UsersModel(String imgLink, String userId) {

		this.userId = userId;
		this.imgLink = imgLink;
	}

	public UsersModel(String userId, String fullName, String fullAddress) {

		this.userId = userId;

		this.fullName = fullName;

		this.fullAddress = fullAddress;

	}

	public UsersModel() {

	}

	public UsersModel(String userId, String fullName, String email, String password, String phoneNumber, String gender,
			String role) {

		this.userId = userId;

		this.fullName = fullName;

		this.email = email;

		this.password = password;

		this.phoneNumber = phoneNumber;

		this.gender = gender;

		this.role = role;

	}

	public String getUserId() {

		return userId;

	}

	public void setUserId(String userId) {

		this.userId = userId;

	}

	public String getFullName() {

		return fullName;

	}

	public void setFullName(String fullName) {

		this.fullName = fullName;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getPhoneNumber() {

		return phoneNumber;

	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

	public String getGender() {

		return gender;

	}

	public void setGender(String gender) {

		this.gender = gender;

	}

	public String getRole() {

		return role;

	}

	public void setRole(String role) {

		this.role = role;

	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

}

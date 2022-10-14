package com.knimbus.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class User {

	private Long userId;
	private String userName;
	private String password;
	public static String defaultPassword="Test123";
//	private String newPassword;
//	private String confirmPassword;
	private String email;
	private Long age;
	private String state;
	private String city;
	private Long pincode;
	//private Long roleName;
	
	private Long roleId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleName(Long roleName) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "User [user_id=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email + ", age=" + age + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + ", roleId=" + roleId + "]";
	}

}

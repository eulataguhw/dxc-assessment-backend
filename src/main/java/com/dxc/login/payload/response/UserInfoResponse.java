package com.dxc.login.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private String firstName;
	private String lastName;

	public UserInfoResponse(Long id, String username, String email, String firstName, String lastName, List<String> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}

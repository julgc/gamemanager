package com.gm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	public User() {
	}

	public User(String userId, String password, boolean enabled) {
		super();
		this.userId = userId;
		this.password = password;
		this.enabled = enabled;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String userId;
	private String password;
	private boolean enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}

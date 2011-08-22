package com.dmma.dashboard.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id()
	@GeneratedValue
	@Column private Integer id;
	@Column private Long    brokerMidasId;
	@Column private Long    bankerExternalId;
	@Column private String  email;
	@Column private String  title;
	@Column private Boolean enabled;
	@Column private String  password;
	
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBrokerMidasId(Long brokerMidasId) {
		this.brokerMidasId = brokerMidasId;
	}

	public Long getBrokerMidasId() {
		return brokerMidasId;
	}

	public void setBankerExternalId(Long bankerExternalId) {
		this.bankerExternalId = bankerExternalId;
	}

	public Long getBankerExternalId() {
		return bankerExternalId;
	}

	
}

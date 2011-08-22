package com.dmma.dashboard.app.models;

import java.io.Serializable;

public class RegistrationModel implements Serializable{
	private static final long serialVersionUID = -7985491438434740888L;
	
	private Long   midasofficeid;
	private Long   midasbrokerid;
	private String email;
	private String password1;
	private String password2;
	private String jcaptcha;


	public RegistrationModel() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getJcaptcha() {
		return jcaptcha;
	}

	public void setJcaptcha(String jcaptcha) {
		this.jcaptcha = jcaptcha;
	}

	public void setMidasofficeid(Long midasofficeid) {
		this.midasofficeid = midasofficeid;
	}

	public Long getMidasofficeid() {
		return midasofficeid;
	}

	public void setMidasbrokerid(Long midasbrokerid) {
		this.midasbrokerid = midasbrokerid;
	}

	public Long getMidasbrokerid() {
		return midasbrokerid;
	}
}

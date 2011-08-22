package com.dmma.dashboard.app.models;

import java.io.Serializable;

public class GetChangedModel implements Serializable{
	private static final long serialVersionUID = -7985491438434740888L;

	private Integer  minutes;

	public GetChangedModel() {
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}


}
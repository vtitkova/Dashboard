package com.dmma.dashboard.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**This entity will be used only as a test
 * to show full java development process 
 * */

@Entity
@Table(name = "dummy")
public class Dummy {
	
	@Id()
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column private String text;
	
	public Dummy() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

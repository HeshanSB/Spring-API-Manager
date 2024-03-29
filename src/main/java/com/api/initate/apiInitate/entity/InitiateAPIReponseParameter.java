package com.api.initate.apiInitate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InitiateAPIReponseParameter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String responseParameter;
	
	@ManyToOne
	private InitiateAPI initiateAPI;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResponseParameter() {
		return responseParameter;
	}

	public void setResponseParameter(String responseParameter) {
		this.responseParameter = responseParameter;
	}
	
	
}

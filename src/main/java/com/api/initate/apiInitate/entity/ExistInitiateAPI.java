package com.api.initate.apiInitate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ExistInitiateAPI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private InitiateAPI initiateAPI;
	
	@ManyToOne
	private ExistAPI existAPI;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public InitiateAPI getInitiateAPI() {
		return initiateAPI;
	}

	public void setInitiateAPI(InitiateAPI initiateAPI) {
		this.initiateAPI = initiateAPI;
	}

	public ExistAPI getExistAPI() {
		return existAPI;
	}

	public void setExistAPI(ExistAPI existAPI) {
		this.existAPI = existAPI;
	}
	
}

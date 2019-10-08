package com.api.initate.apiInitate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExistAPIResponseParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String parameter;
	
	@ManyToOne
	private ExistAPI existApi;

	public ExistAPIResponseParameter() {
		
	}

	public ExistAPIResponseParameter(String parameter, ExistAPI existApi) {
		this.parameter = parameter;
		this.existApi = existApi;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public ExistAPI getExistApi() {
		return existApi;
	}

	public void setExistApi(ExistAPI existApi) {
		this.existApi = existApi;
	}
	
	
}

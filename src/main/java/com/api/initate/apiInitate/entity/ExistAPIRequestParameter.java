package com.api.initate.apiInitate.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ExistAPIRequestParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String parameter;
	
	private String type;
	
	@ManyToOne
	private ExistAPI existApi;
	
	public ExistAPIRequestParameter() {
		
	}

	public ExistAPIRequestParameter(String parameter, String type, ExistAPI existApi) {
		this.parameter = parameter;
		this.existApi = existApi;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ExistAPI getExistApi() {
		return existApi;
	}

	public void setExistApi(ExistAPI existApi) {
		this.existApi = existApi;
	}
	
}

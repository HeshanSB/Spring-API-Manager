package com.api.initate.apiInitate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ExistAPI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String endpoint;
	private String type;

	
	public ExistAPI() {
		
	}

	public ExistAPI(String endpoint, String type) {
		this.endpoint = endpoint;
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

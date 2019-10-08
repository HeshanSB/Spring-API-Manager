package com.api.initate.apiInitate.model;

import java.util.List;

public class ExistAPIModel {
	private String endpoint;
	private String type;
	private List<String> requestParameter;
	private List<String> requestParameterType;
	private List<String> responseParameter;
	private List<String> requestParameterValues;
	
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
	public List<String> getRequestParameter() {
		return requestParameter;
	}
	public void setRequestParameter(List<String> requestParameter) {
		this.requestParameter = requestParameter;
	}
	public List<String> getResponseParameter() {
		return responseParameter;
	}
	public void setResponseParameter(List<String> responseParameter) {
		this.responseParameter = responseParameter;
	}
	public List<String> getRequestParameterType() {
		return requestParameterType;
	}
	public void setRequestParameterType(List<String> requestParameterType) {
		this.requestParameterType = requestParameterType;
	}
	public List<String> getRequestParameterValues() {
		return requestParameterValues;
	}
	public void setRequestParameterValues(List<String> requestParameterValues) {
		this.requestParameterValues = requestParameterValues;
	}
	
	
}

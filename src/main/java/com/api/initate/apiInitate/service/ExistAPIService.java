package com.api.initate.apiInitate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.initate.apiInitate.entity.ExistAPI;
import com.api.initate.apiInitate.entity.ExistAPIRequestParameter;
import com.api.initate.apiInitate.entity.ExistAPIResponseParameter;
import com.api.initate.apiInitate.model.RequestBean;
import com.api.initate.apiInitate.repository.ExistAPIRepository;
import com.api.initate.apiInitate.repository.ExistAPIRequestParameterRepository;
import com.api.initate.apiInitate.repository.ExistAPIResponseParameterRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class ExistAPIService {
	
	@Autowired
	ExistAPIRepository existAPIRepo;
	
	@Autowired
	ExistAPIRequestParameterRepository existAPIRequestParameterRepo;
	
	@Autowired
	ExistAPIResponseParameterRepository existAPIResponseParameterRepo;
	
	public ExistAPI saveApiEndPoint(ExistAPI existAPI) {
		
		ExistAPI registerApi = existAPIRepo.save(existAPI);
		
		return registerApi;
	}
	
	public ResponseEntity<String> saveExistResponseParameters(List<String> responses, ExistAPI existAPI) {
		
		for(String respo: responses){
			ExistAPIResponseParameter response = new ExistAPIResponseParameter(respo, existAPI);
			existAPIResponseParameterRepo.save(response);
		}
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<String> saveExistRequestParameters(List<String> requests, List<String> type, ExistAPI existAPI) {
		
		int i = 0;
		
		for(String reque: requests){
			ExistAPIRequestParameter request = new ExistAPIRequestParameter(reque, type.get(i), existAPI);
			existAPIRequestParameterRepo.save(request);
			i++;
		}
		return ResponseEntity.ok().build();
	}
	
	public String vaildateExistApi(String endpoint) {
		
		final String uri = endpoint;
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}
	
	public ResponseEntity<String> validateApi(String endpoint, String apiType, List<String> request, List<String> requestType, List<String> requestValues) {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		final  String url = endpoint;
		RestTemplate restTemplate = new RestTemplate();
		
		// validate get and delete api's
		if(apiType.equals("GET")|| apiType.equals("DELETE")) {
			
			if(request==null || request.isEmpty()) {
				return restTemplate.getForEntity(url, String.class);
			}
			else {
				
				if(requestType.contains("param") || requestType.contains("header")) {
					System.out.println("Test1");
					int index = 0;
					Map<String, String> params = new HashMap<String, String>();
					
					for(String type: requestType) {
						System.out.println(type);
						
						if(type.equals("param")) {
							params.put(request.get(index), requestValues.get(index));
						}
						
						if(type.equals("header")) {
							headers.set(request.get(index), requestValues.get(index));
						}
						index++;
					}
					HttpEntity<Object> entity = new HttpEntity<Object>(headers);
					return restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
				}
				else {
					return null;
				}
			}
		}
		
		//validate post api's
		else if(apiType.equals("POST")) {
			if(request==null || request.isEmpty()) {
				return restTemplate.postForEntity(url, null, String.class);
			}
			else {
				
				HashMap<String, String> bodyData = new HashMap<String, String>();
				Map<String, String> params = new HashMap<String, String>();
				
				int index = 0;
				for(String type: requestType) {
					
					if(type.equals("body")) {
						bodyData.put(request.get(index), requestValues.get(index));
					}
					else if(type.equals("header")) {
						headers.set(request.get(index), requestValues.get(index));
					}
					else if(type.equals("param")) {
						params.put(request.get(index), requestValues.get(index));
					}
					
					index++;
				}
				HttpEntity<Object> entity = new HttpEntity<Object>(bodyData,headers);
				ResponseEntity<String> result = restTemplate.postForEntity(url, entity, String.class, params);
			
				return result;
			}
		}
		else {
			return null;
		}
	}
}

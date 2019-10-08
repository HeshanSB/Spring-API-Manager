package com.api.initate.apiInitate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.api.initate.apiInitate.entity.ExistAPI;
import com.api.initate.apiInitate.entity.ExistAPIRequestParameter;
import com.api.initate.apiInitate.entity.ExistAPIResponseParameter;
import com.api.initate.apiInitate.model.ExistAPIModel;
import com.api.initate.apiInitate.repository.ExistAPIRepository;
import com.api.initate.apiInitate.service.ExistAPIService;

@RestController
public class ExistAPIController {
	
	@Autowired
	ExistAPIService existAPIService;
	
	@Autowired
	ExistAPIRepository existAPIRepo;
	
	@PostMapping("/register")
	private ExistAPI registerExistAPI(@RequestBody ExistAPIModel existAPIModel) {
		
		ExistAPI existAPI = new ExistAPI(existAPIModel.getEndpoint(), existAPIModel.getType());
		List<String> request = existAPIModel.getRequestParameter();
		List<String> response = existAPIModel.getResponseParameter();
		List<String> requestType = existAPIModel.getRequestParameterType();
		List<String> requestValues = existAPIModel.getRequestParameterValues();
		
		System.out.println(existAPIService.validateApi(existAPIModel.getEndpoint(), existAPIModel.getType(), request, requestType, requestValues));
		
		ExistAPI registeredApi;
		registeredApi = existAPIRepo.findByEndpointAndType(existAPI.getEndpoint(), existAPI.getType());
		if(registeredApi != null) {
			return null;
		}
		else {
			ExistAPI api = existAPIService.saveApiEndPoint(existAPI);
			existAPIService.saveExistRequestParameters(request, requestType, existAPI);
			existAPIService.saveExistResponseParameters(response, existAPI);
			return api;
		}
		
	}
	
	@GetMapping("/test/{id}/{name}")
	private ResponseEntity<String> testExistAPI(@RequestHeader(name="SOME", required = true) @PathVariable("id") String id, @PathVariable("name") String name) {
		
//		List<String> response = new ArrayList<String>();
		String test = "Test is successful "+id+" "+name;
		return ResponseEntity.ok().body(test);
	}
	
	@PostMapping("/test/{id}")
	private ResponseEntity<String> testPostApiId(@RequestBody ExistAPI existAPI, 
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@PathVariable("id") String id){
		return ResponseEntity.ok().body(existAPI.getEndpoint()+" "+id);
	} 
	
	@PostMapping("/test")
	private ResponseEntity<String> testPostApi(@RequestBody ExistAPI existAPI, 
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist){
		return ResponseEntity.ok().body(existAPI.getEndpoint());
	} 

}

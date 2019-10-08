package com.api.initate.apiInitate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.initate.apiInitate.entity.ExistAPI;

public interface ExistAPIRepository extends CrudRepository<ExistAPI, Long> {
	
	//List<ExistAPI> findAllByEndpoint(String endpoint);
	ExistAPI findByEndpointAndType(String endpoint, String type);
}

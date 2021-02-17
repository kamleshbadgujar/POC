package com.poc.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface RestApiCall {
	
	public void callRestApi(String url, String method);
	
	public Map<String, String> getResponseMap();
	
}

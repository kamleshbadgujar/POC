package com.poc.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.poc.service.RestApiCall;

@Service
public class RestApiCallImpl implements RestApiCall {

	@Autowired
	private RestTemplate restTemplate;
	
	private Map<String, String> responseMap = new HashMap();

	@Override
	public void callRestApi(String url, String method) {

		if(method.equalsIgnoreCase("GET"))
		{
			ResponseEntity<String> response = null; 
			try {
				response = restTemplate.getForEntity("https://" + url, String.class);
				responseMap.put(url, response.getBody());
			} catch (RestClientException ex) {
				responseMap.put(url, ex.getLocalizedMessage());
			}
		}
		
		if(method.equalsIgnoreCase("POST"))
		{
			ResponseEntity<String> response = null; 
			try {
				response = restTemplate.postForEntity("https://" + url, null, String.class);
				responseMap.put(url, response.getBody());
			} catch (RestClientException ex) {
				responseMap.put(url, ex.getLocalizedMessage());
			}
		}
	}
	
	public Map<String, String> getResponseMap() {
		return responseMap;
	}

}

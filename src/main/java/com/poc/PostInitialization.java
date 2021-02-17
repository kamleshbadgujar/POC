package com.poc;

import java.util.Properties;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.service.FileReader;
import com.poc.service.RestApiCall;
import com.poc.util.WriteToFile;

@Component
public class PostInitialization {

	@Autowired
	private FileReader fileReader;
	
	@Autowired
	private RestApiCall restApiCall;
	
	@Autowired
	private WriteToFile writeToFile;
	
	static final Logger log = 
	        LoggerFactory.getLogger(PostInitialization.class);
	
	
	@PostConstruct
	public void init() {
        Properties prop = fileReader.readProperties();
        prop.forEach((key, value) -> {
        	restApiCall.callRestApi(key.toString(), value.toString());
        });
        
        writeToFile.writeToFile(restApiCall.getResponseMap());
    }
}

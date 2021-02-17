package com.poc.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.poc.PostInitialization;
import com.poc.service.FileReader;

@Service
public class FileReaderImpl implements FileReader{
	
	static final Logger log = 
	        LoggerFactory.getLogger(FileReaderImpl.class);
	
	public Properties readProperties() {
		return readPropertiesFile();
	}
	
	private Properties readPropertiesFile() {
		
        log.debug("called rest api");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		 
        log.debug("called rest api");
		try (InputStream resourceStream = loader.getResourceAsStream("url.properties")) {
		    properties.load(resourceStream);
		} catch (IOException e) {
		    log.error("Error occured while reading the properties file");
		}
	      return properties;
	   }

}

package com.poc.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public interface FileReader {

	public Properties readProperties();
}

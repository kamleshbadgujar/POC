package com.poc.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class WriteToFile {

	 private static final String OUTPUT_FILE_PATH = System.getProperty("user.dir") + "/response.txt";
	 
	 public void writeToFile(Map<String, String> responseMap) {	
		 File file = new File(OUTPUT_FILE_PATH);
	        try (BufferedWriter bf = new BufferedWriter( new FileWriter(file) );){
	        	int i = 1;
	            for(Map.Entry<String, String> entry : responseMap.entrySet()){
	             
	                bf.write( i + ". " + entry.getKey() + ":" + entry.getValue() );
	                bf.newLine();
	                bf.newLine();
	                i++;
	            }
	            i=0;
	            bf.flush();
	 
	        }catch(IOException e){
	            e.printStackTrace();
	        }
	 }
}

package com.xsit.testdata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	// read json file data to String
	TestData testData;
	public  JsonDataReader() {
		try {
			byte[] jsonData = Files.readAllBytes(Paths.get("src/test/resources/TestData.txt"));

			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object
			testData = objectMapper.readValue(jsonData, TestData.class);
			//System.out.println("Employee Object\n"+ testData.getUrl());
			
		} catch (IOException e) {
			e.printStackTrace();
		 }
		
		//return testData;
		

	}
	public TestData getTestData() {
		return testData;
		
	}
	
	public Map<String, String> getJsonDataInMaps() throws JsonParseException, JsonMappingException, IOException {

		//converting json to Map
		byte[] mapData = Files.readAllBytes(Paths.get("src/test/resources/TestDataForMap.txt"));
		Map<String,String> myMap = new HashMap<String, String>();

		ObjectMapper objectMapper = new ObjectMapper();
		myMap = objectMapper.readValue(mapData, HashMap.class);
		System.out.println("Map is: "+myMap);

		//another way
		return myMap;

		
		
	}
	
	
}

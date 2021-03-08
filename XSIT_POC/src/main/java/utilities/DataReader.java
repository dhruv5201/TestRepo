package utilities;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class DataReader {
	public String getJsonData(String jsonPath) {
		String data= null;
		
		File json = new File("src/test/resources/Data.json");

	    JsonPath jPath = new JsonPath(json);
	    data= jPath.getString(jsonPath);
	    System.out.println("JSON Value : " + data);
		
		return data;
		
	}

}

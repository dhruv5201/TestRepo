package utilities;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class JsonDataReader {
	String FilePath;
	public JsonDataReader(String FilePath){
		this.FilePath = FilePath;
	}
	public String getJsonData(String jsonPath)  {
		String data = null;
		File json = new File(FilePath);
		
		JsonPath jPath = new JsonPath(json);
		data = jPath.getString(jsonPath);
		
		
		//System.out.println("JSON Value : " + data);

		return data;

	}
}

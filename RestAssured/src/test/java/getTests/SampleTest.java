package getTests;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTest {
  @Test (enabled =false)
  public void GetUserDetails() {
	  
	  
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response=httpRequest.request(Method.GET,"users");
	  JsonPath jasonDriver=response.jsonPath();
	  	 
	  //String RespnseBody=response.getBody().asString();
	 // System.out.println(RespnseBody);
	  
	 //********* Putting all the User names in a List.*************// 
	  
	 int responseSize=jasonDriver.getList("").size();
	 List <String> userlist= new ArrayList<String>();
	 for (int i =0 ; i<responseSize ; i++ ) {
		 userlist.add(i,jasonDriver.get("["+i+"].name").toString() );
	 }
	 System.out.println("User List is: " + userlist);
	 
	 //***********************************************************//
	  
	  String UserName=jasonDriver.get("[0].address.geo.lat");
	  System.out.println("$$$$$: "+ UserName);
	  
	  
  }
  
  @Test (enabled =true)
  public void GetDataFromFile() {
	  //JsonPath json=JsonPath.from("src/test/resources/Data.json");
	  //System.out.println("Json: " + json.get("id").toString());
	  
	  File json = new File("src/test/resources/Data.json");

	    JsonPath jsonPath = new JsonPath(json);
	    String tank= jsonPath.getString("id");
	    System.out.println("JSON Value : " + tank);
	    
	  
	  
	  
	  
  }
}

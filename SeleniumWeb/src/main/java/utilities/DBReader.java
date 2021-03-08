package utilities;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

public class DBReader {

	public static void MongoReader() {
		MongoClient mongoClient = null;
		DBCursor cursor = null;
		try {
			mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DB database = mongoClient.getDB("TestDB");
			DBCollection collection = database.getCollection("Students");
			DBObject query = new BasicDBObject("roll", "R001");
			cursor = collection.find(query);
			DBObject R001 = cursor.one();
			String name = R001.get("name").toString();
			String classs = R001.get("class").toString();
			String contact = R001.get("contact").toString();
			System.out.println("name :" + name + " | classs: " + classs + " | contact: " + contact);

		} catch (MongoException e) {
			System.out.println("Exception occured - " + e.toString());
			if (cursor != null) {
				cursor.close();
			}
			

		}
		catch (Exception e) {
			System.out.println("Exception occured - " + e.toString());
		}

	}

}

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


public class MongoCrudOps {
	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			
			DB db = mongo.getDB("testdb");
			
			DBCollection table = db.getCollection("user");
			BasicDBObject document = new BasicDBObject();
			table.remove(document);
			
			/*
			 * Insert
			 */
			document = new BasicDBObject();
			document.put("name", "Suganthan");
			document.put("age", 26);
			document.put("createdDate", new Date());
			table.insert(document);
			
			
			/**
			 * Search
			 * Find and Display
			 */
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "Suganthan");
			
			DBCursor cursor = table.find(searchQuery);
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			/**
			 * Update
			 */
			
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.put("name", "Suganthan");
			
			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.put("name", "Suganthan Madhavan");
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", updateDocument);
			
			table.update(updateQuery, updateObject);
			
			
			/**
			 * Search
			 * Find and Display
			 */
			searchQuery.put("name", "Suganthan Madhavan");
			
			cursor= table.find(searchQuery);
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			/**
			 * Done
			 */
			System.out.println("******Done********");
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(MongoException e) {
			e.printStackTrace();
		}
		
	}
}

package com.yube.db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class mongoDB {
	private MongoClient mongoClient = null;
	private DB database = null;

	public mongoDB(HashMap<String, String> config) {

		mongoClient = new MongoClient(config.get("host"), Integer.parseInt(config.get("port")));
		database = mongoClient.getDB(config.get("dbName"));

		DBCollection table = database.getCollection("usd_tl");
		BasicDBObject query = new BasicDBObject();
		String id = UUID.randomUUID().toString();
		query.put("id", "aba30930-3e72-44d0-99bb-f49213f86d76");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("low", new BasicDBObject().append("value", "5.25").append("id", id).append("type", "low")
				.append("low", new BasicDBObject().append("value", "5.24").append("id", id).append("type", "low")));

		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		table.update(query, updateObj);
		System.out.println(table.find().next());
	}

	
	public boolean createCollection(String collectionName) {
		try {
			DBCollection col = database.createCollection(collectionName, null);
			
			BasicDBObject obj = new BasicDBObject();

			return true;
		} catch (MongoException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	
	public boolean insertData(BasicDBObject document, DBCollection root) {
		try {
			root.insert(document);
			return true;
		} catch (MongoException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}

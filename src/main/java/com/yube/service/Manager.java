package com.yube.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.yube.calc.ChangeRate;
import com.yube.db.mongoDB;
import com.yube.http.JsoupOperations;
import com.yube.util.Cast;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashMap<String,String> config=new HashMap<>();
//		config.put("host", "localhost");
//		config.put("port","27017");
//		config.put("dbName", "local");
//		new mongoDB(config);
		JsoupOperations op = new JsoupOperations();
		ChangeRate cr=new ChangeRate();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 try {
				 while(true) {
				cr.changeRateCalc(Cast.strTOdoub(op.getDollarTlExhangeRate()));
				Thread.sleep(15000);
				 }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		thread.start();

	}

}

package com.yube.http;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupOperations {
	public String getDollarTlExhangeRate() {
		String url = "https://dolar.tlkur.com";
		Document document;
		try {
			document = Jsoup.connect(url).get();
			
			return document.getElementById("USDTRY").text().toString();
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "hata:"+e.toString();
		}
	

	}
}

package com.yube.calc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.yube.util.Cast;
import com.yube.util.FileOperations;

public class ChangeRate {
  private double exchange = 0;
  private String status = "start" ;
  private double rate = 0;
public boolean changeRateCalc(Double newExchange) {
	if (exchange == 0) {
		toOutString(status,rate,newExchange);
		
	}else {
		if(exchange>newExchange) {
			status="low";
			rate = Cast.doubTOrate(exchange, newExchange);
			toOutString(status, rate,newExchange);
		}else if(exchange<newExchange) {
			status="high";
			rate =Cast.doubTOrate(newExchange,exchange);
			toOutString(status, rate,newExchange);
		}
		else {
			status="same";
			rate = Cast.doubTOrate(newExchange,exchange);
			toOutString(status, rate,newExchange);
		}
	}
	exchange=newExchange;
return true;
}
  private boolean toOutString(String status, double rate,double value) {
	  Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	  String data="{\n\t\""+UUID.randomUUID().toString()+"\":{\n\t\t\"time\" : \""+ft.format(dNow)+"\" ,\n\t\t\"status\" : \""+status+"\" ,\n\t\t\"rate\" : \"%"+rate+"\" ,\n\t\t\"value\" : \""+value+"\"\n\t}\n},\n";
	  FileOperations.Writer("C:\\Users\\yusuf\\Desktop", "dolar_tl_rate.json", data,true);
	  return true;
  }
}

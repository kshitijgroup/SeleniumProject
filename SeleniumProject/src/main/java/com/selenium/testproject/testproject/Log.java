package com.selenium.testproject.testproject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {

	static String configFilename = "src\\main\\resources\\log4j.properties";
	public static final Logger log = Logger.getLogger(Log.class.getName()); 
	private static final Logger log1 = Logger.getLogger(Log.class);
	public static void getLogger(){
		PropertyConfigurator.configure(configFilename);
	}
	public static void logger(String msg) {
		//log.info(msg);
	
	}
}

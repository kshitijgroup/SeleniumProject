package com.selenium.testproject.testproject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDataExample {
	String n;

	public String readJSONData(String keyword) throws IOException, ParseException {

		Reader reader = new FileReader("json/creds.json");

		JSONParser parser = new JSONParser();

		JSONArray jsonArr =  (JSONArray) parser.parse(reader);

		for (Object obj : jsonArr) {

			JSONObject jo = (JSONObject) obj;
			n = (String) jo.get(keyword);

		}
		
		/*JSONObject jo1 = (JSONObject) parser.parse(reader);
		n = (String) jo1.get(keyword);*/
		return n;

	}

	public static void main(String[] args) throws IOException, ParseException {
		JSONDataExample e = new JSONDataExample();
		String a = e.readJSONData("blog URL");
		System.out.println(a);

	}

}
package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadData {
	public static String JSonFileReader(String key) throws IOException, ParseException
	{
       JSONParser jsonParser = new JSONParser();
		
		FileReader read=new FileReader("/Users/navya/Desktop/Demo/vegetable/src/test/resources/Jsonreaddata.json");
		Object obj = jsonParser.parse(read);
		JSONObject jobj = (JSONObject) obj;
		 return jobj.get(key).toString();
	}
	
	

}

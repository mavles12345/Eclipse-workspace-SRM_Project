package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		// requestspec used to send the data
		
		if (req==null) {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return req;
		
		}
		
		return req;

	}
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("F:\\Eclipse-workspace-RestAssured-April2024\\RestAssured_GooglePlace\\src\\test\\java\\resources\\global.properties");
		p.load(fis);
		return p.getProperty(key);		
		
	}
	
	public String getJsonPath(Response response, String key){
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
		//String keyvalue = js.getString(key);
		//return keyvalue;


}
}
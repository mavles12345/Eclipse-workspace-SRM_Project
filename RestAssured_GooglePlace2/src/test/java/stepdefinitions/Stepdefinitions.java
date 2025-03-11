package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import google.pojo.Addplace;
import google.pojo.Addplace_location;
import google.pojo.Addplace_types;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Stepdefinitions extends Utils {

	RequestSpecification res;
	ResponseSpecification response;
	Response addPlace_response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

	@Given("Add place Payload")
	public void add_place_payload() throws IOException {

		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();

		// res = given().spec(requestSpecification()).body(data.addPlacePayload());

	}

	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Exception {
		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();

		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

	}

	@When("User calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {

		addPlace_response = res.when().post("/maps/api/place/add/json").then().spec(response).assertThat().extract()
				.response();

		System.out.println(addPlace_response);

	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getAPIResources());

		if (method.equals("POST")) {

			addPlace_response = res.when().post(resourceAPI.getAPIResources()).then().spec(response).assertThat()
					.extract().response();

		} else if (method.equals("GET")) {
			addPlace_response = res.when().get(resourceAPI.getAPIResources()).then().spec(response).assertThat()
					.extract().response();

				} 
		else if (method.equalsIgnoreCase("DELETE")) {

			addPlace_response = res.when().delete(resourceAPI.getAPIResources());
					//.then().spec(response).assertThat().extract().response();

		} else {

			System.out.println("No valid input");
		}

		// System.out.println(addPlace_response);

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {

		assertEquals(addPlace_response.getStatusCode(), 200);

	}

	@Then("{string} in responsebody is {string}")
	public void in_responsebody_is(String keyValue, String expectedValue) {

		// String res = addPlace_response.asString();
		// js = new JsonPath(res);
		// String value = js.getString(keyValue);
		// System.out.println(value);

		assertEquals(getJsonPath(addPlace_response, keyValue), expectedValue);

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

		place_id = getJsonPath(addPlace_response, "place_id");
		System.out.println(place_id);

		res = given().spec(requestSpecification()).queryParam("place_id", place_id);

		user_calls_with_http_request(resource, "GET");

		String actualname = getJsonPath(addPlace_response, "name");
		System.out.println(actualname);
		assertEquals(actualname, expectedName);

	}

	@Given("Deleteplace Payload")
	public void deleteplace_payload() throws IOException {

		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
		
		System.out.println(place_id);
		

	}

}

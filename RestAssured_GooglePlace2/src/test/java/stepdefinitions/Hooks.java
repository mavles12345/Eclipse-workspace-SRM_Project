package stepdefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws Exception {

		Stepdefinitions m = new Stepdefinitions();

		if (Stepdefinitions.place_id == null) {

			m.add_place_payload_with("jack", "Jappanese", "Japan");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("jack", "GetPlaceAPI");
		}

	}

}

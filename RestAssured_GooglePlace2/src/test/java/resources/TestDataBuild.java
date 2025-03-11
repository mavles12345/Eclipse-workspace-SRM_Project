package resources;

import java.util.ArrayList;
import java.util.List;

import google.pojo.Addplace;
import google.pojo.Addplace_location;
import google.pojo.Addplace_types;

public class TestDataBuild {
	
	public Addplace addPlacePayload(String name, String language, String address) {
		
		Addplace add = new Addplace();
		add.setAccuracy(50);
		//add.setName("Frontline house");
		add.setName(name);
		add.setPhone_number("(+91) 983 893 3937");
		//add.setAddress("29, side layout, cohen 09");
		add.setAddress(address);
		add.setWebsite("http://google.com");
		//add.setLanguage("French-IN");
		add.setLanguage(language);

		Addplace_location loc = new Addplace_location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setLocation(loc);

		List<String> types = new ArrayList<String>();// add all types into the list
		types.add("shoe park");
		types.add("shop");

		Addplace_types type = new Addplace_types(); // create object for Addplace_types inorder to add list
		type.setTypes(types);

		add.setTypes(type); // add list types into main object
		
		return add;

	}
	
	public String deletePlacePayload(String place_id) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";

		
	}

}

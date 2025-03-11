package google.pojo;

public class Addplace {
	
	private String name;
	private int accuracy;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private Addplace_location location;
	private Addplace_types types;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Addplace_location getLocation() {
		return location;
	}
	public void setLocation(Addplace_location location) {
		this.location = location;
	}
	public Addplace_types getTypes() {
		return types;
	}
	public void setTypes(Addplace_types types) {
		this.types = types;
	}
		
	

}

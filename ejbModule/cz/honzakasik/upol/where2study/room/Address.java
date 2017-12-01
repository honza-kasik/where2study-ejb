package cz.honzakasik.upol.where2study.room;

public class Address {
	
	private final String street;
	private final String city;
	private final String number;
	
	public Address(String street, String city, String number) {
		this.street = street;
		this.city = city;
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getNumber() {
		return number;
	}

}

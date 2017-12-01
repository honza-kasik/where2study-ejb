package cz.honzakasik.upol.where2study.room;

public class Building {
	
	private final Address address;
	
	//id
	private final String abbreviation;
	
	public Building(Address address, String abbreviation) {
		this.address = address;
		this.abbreviation = abbreviation;
	}

	public Address getAddress() {
		return address;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	
}

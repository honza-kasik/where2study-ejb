package cz.honzakasik.upol.where2study.room;

public class Department {
	
	//id
	private final String abbreviation;
	private final String fullName;
	
	public Department(String abbreviation, String fullName) {
		this.abbreviation = abbreviation;
		this.fullName = fullName;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	public String getFullName() {
		return fullName;
	}
	
	
}

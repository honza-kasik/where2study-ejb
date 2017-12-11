package cz.honzakasik.upol.where2study.room;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Abstraction over building
 */
@Entity
public class Building implements Serializable {
	
	private static final long serialVersionUID = -1122210484785184704L;

	@Id
	@Column(nullable = false)
	private String abbreviation;
	
	private String street;
	private String city;
	private String number;
		
	/**
	 * Create new instance
	 */
	public Building() {
	}

	/**
	 * Create new instance with set variables
	 * @param abbreviation building's abbreviation, e.g.: LP
	 * @param street street on which the building is located
	 * @param city city in which the building is located
	 * @param number street number of building
	 */
	public Building(String abbreviation, String street, String city, String number) {
		this.abbreviation = abbreviation;
		this.street = street;
		this.city = city;
		this.number = number;
	}

	/**
	 * Get building's abbreviation
	 * @return
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	
	/**
	 * Sets building's abbreviation
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	/**
	 * Get building's street
	 * @return
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set building's street
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Get building's city
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set building's city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Get building's street number
	 * @return street number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Set building's street number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Building other = (Building) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
}

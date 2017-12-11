package cz.honzakasik.upol.where2study.room;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * An abstraction over department - an organizational unit.
 * It is based on STAG's department, so it can be both 'katedra' and faculty
 */
@Entity
public class Department implements Serializable {
	
	private static final long serialVersionUID = -6506106165566157647L;
	
	@Id
	@Column(nullable = false)
	private String abbreviation;
	private String fullName;
	
	/**
	 * Create new instance
	 */
	public Department() {
	}

	/**
	 * Create new instance
	 * @param abbreviation departments abbreviation, e.g. KMI
	 * @param fullName full name of department
	 */
	public Department(String abbreviation, String fullName) {
		this.abbreviation = abbreviation;
		this.fullName = fullName;
	}
	
	/**
	 * Get department's abbreviation
	 * @return abbreviation of department
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	
	/**
	 * Get full name of department
	 * @return full department's name
	 */
	public String getFullName() {
		return fullName;
	}
	

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
		Department other = (Department) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}
	
}

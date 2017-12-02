package cz.honzakasik.upol.where2study.room;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
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

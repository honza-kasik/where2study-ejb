package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rozvrh")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rozvrh {
	
    @XmlElement(name = "rozvrhovaAkce")
	private List<RozvrhovaAkce> rozvrhoveAkce;

	public List<RozvrhovaAkce> getRozvrhoveAkce() {
		return rozvrhoveAkce;
	}

	public void setRozvrhoveAkce(List<RozvrhovaAkce> rozvrhoveAkce) {
		this.rozvrhoveAkce = rozvrhoveAkce;
	}

}

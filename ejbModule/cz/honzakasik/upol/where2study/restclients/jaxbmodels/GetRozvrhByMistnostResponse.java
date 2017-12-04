package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getRozvrhByMistnostResponse", namespace="http://stag-ws.zcu.cz/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetRozvrhByMistnostResponse {
	
    @XmlElement(name = "rozvrh")
	private Rozvrh rozvrh;

	public Rozvrh getRozvrh() {
		return rozvrh;
	}

}

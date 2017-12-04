package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getMistnostiInfoResponse", namespace="http://stag-ws.zcu.cz/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetMistnostiInfoResponse {
	
    @XmlElement(name = "mistnostiInfo")
	private MistnostiInfo mistnostiInfo;

	public MistnostiInfo getMistnostiInfo() {
		return mistnostiInfo;
	}

}

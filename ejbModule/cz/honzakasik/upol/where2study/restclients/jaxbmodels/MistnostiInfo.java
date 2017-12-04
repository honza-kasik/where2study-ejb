package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mistnostiInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MistnostiInfo {
	
    @XmlElement(name = "mistnostInfo")
	private List<MistnostInfo> mistnostInfos;

	public List<MistnostInfo> getMistnostInfos() {
		return mistnostInfos;
	}

	public void setMistnostInfos(List<MistnostInfo> mistnostInfos) {
		this.mistnostInfos = mistnostInfos;
	}
	
}

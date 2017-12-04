package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rozvrhovaAkce")
@XmlAccessorType(XmlAccessType.FIELD)
public class RozvrhovaAkce {
	
	private String katedra;
	private String den;
	private String datumOd;
	private String datumDo;
	private String hodinaSkutOd;
	private String hodinaSkutDo;
	
	public String getKatedra() {
		return katedra;
	}
	
	public void setKatedra(String katedra) {
		this.katedra = katedra;
	}
	
	public String getDen() {
		return den;
	}
	
	public void setDen(String den) {
		this.den = den;
	}
	
	public String getDatumOd() {
		return datumOd;
	}
	
	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}
	
	public String getDatumDo() {
		return datumDo;
	}
	
	public void setDatumDo(String datumDo) {
		this.datumDo = datumDo;
	}
	
	public String getHodinaSkutOd() {
		return hodinaSkutOd;
	}
	
	public void setHodinaSkutOd(String hodinaSkutOd) {
		this.hodinaSkutOd = hodinaSkutOd;
	}
	
	public String getHodinaSkutDo() {
		return hodinaSkutDo;
	}
	
	public void setHodinaSkutDo(String hodinaSkutDo) {
		this.hodinaSkutDo = hodinaSkutDo;
	}

}

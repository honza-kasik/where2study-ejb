package cz.honzakasik.upol.where2study.restclients.jaxbmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mistnostInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MistnostInfo {
	
	private String zkrBudovy;
	private String cisloMistnosti;
	private String katedra;
	private String pracoviste;
	private int typCiselne;
	private String typ;
	private int kapacita;
	private String spolecnyFond;
	private String provozOd;
	private String provozDo;
	private String dvereCislo;
	private String podlazi;
	private String obec;
	private String ulice;
	private String cisloPopisne;
	private String adresaBudovy;
	private String identifikatorBudova;
	private String poznamka;
	
	public String getZkrBudovy() {
		return zkrBudovy;
	}
	
	public void setZkrBudovy(String zkrBudovy) {
		this.zkrBudovy = zkrBudovy;
	}
	
	public String getCisloMistnosti() {
		return cisloMistnosti;
	}
	
	public void setCisloMistnosti(String cisloMistnosti) {
		this.cisloMistnosti = cisloMistnosti;
	}
	
	public String getKatedra() {
		return katedra;
	}
	
	public void setKatedra(String katedra) {
		this.katedra = katedra;
	}
	
	public String getPracoviste() {
		return pracoviste;
	}
	
	public void setPracoviste(String pracoviste) {
		this.pracoviste = pracoviste;
	}
	
	public int getTypCiselne() {
		return typCiselne;
	}
	
	public void setTypCiselne(int typCiselne) {
		this.typCiselne = typCiselne;
	}
	
	public String getTyp() {
		return typ;
	}
	
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	public int getKapacita() {
		return kapacita;
	}
	
	public void setKapacita(int kapacita) {
		this.kapacita = kapacita;
	}
	
	public String getSpolecnyFond() {
		return spolecnyFond;
	}
	
	public void setSpolecnyFond(String spolecnyFond) {
		this.spolecnyFond = spolecnyFond;
	}
	
	public String getProvozOd() {
		return provozOd;
	}
	
	public void setProvozOd(String provozOd) {
		this.provozOd = provozOd;
	}
	
	public String getDvereCislo() {
		return dvereCislo;
	}
	
	public void setDvereCislo(String dvereCislo) {
		this.dvereCislo = dvereCislo;
	}
	
	public String getPodlazi() {
		return podlazi;
	}
	
	public void setPodlazi(String podlazi) {
		this.podlazi = podlazi;
	}
	
	public String getObec() {
		return obec;
	}
	
	public void setObec(String obec) {
		this.obec = obec;
	}
	
	public String getUlice() {
		return ulice;
	}
	
	public void setUlice(String ulice) {
		this.ulice = ulice;
	}
	
	public String getCisloPopisne() {
		return cisloPopisne;
	}
	
	public void setCisloPopisne(String cisloPopisne) {
		this.cisloPopisne = cisloPopisne;
	}
	
	public String getAdresaBudovy() {
		return adresaBudovy;
	}
	
	public void setAdresaBudovy(String adresaBudovy) {
		this.adresaBudovy = adresaBudovy;
	}
	
	public String getIdentifikatorBudova() {
		return identifikatorBudova;
	}
	
	public void setIdentifikatorBudova(String identifikatorBudova) {
		this.identifikatorBudova = identifikatorBudova;
	}
	
	public String getProvozDo() {
		return provozDo;
	}
	
	public void setProvozDo(String provozDo) {
		this.provozDo = provozDo;
	}

	public String getPoznamka() {
		return poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}
		
}

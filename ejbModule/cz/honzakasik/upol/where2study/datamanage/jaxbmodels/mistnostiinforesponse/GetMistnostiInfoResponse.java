//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.04 at 09:55:31 AM CET 
//


package cz.honzakasik.upol.where2study.datamanage.jaxbmodels.mistnostiinforesponse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mistnostiInfo" form="unqualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mistnostInfo" maxOccurs="unbounded" form="unqualified">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="zkrBudovy" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
 *                             &lt;element name="cisloMistnosti" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                             &lt;element name="katedra" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
 *                             &lt;element name="pracoviste" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                             &lt;element name="typCiselne" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
 *                             &lt;element name="typ" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
 *                             &lt;element name="kapacita" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
 *                             &lt;element name="spolecnyFond" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
 *                             &lt;element name="provozOd" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
 *                             &lt;element name="provozDo" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="poznamka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="plocha" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="dvereCislo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="podlazi" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
 *                             &lt;element name="obec" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
 *                             &lt;element name="ulice" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                             &lt;element name="cisloPopisne" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="adresaBudovy" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                             &lt;element name="urlMistnost" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="urlBudova" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="identifikatorMistnost" type="{http://www.w3.org/2001/XMLSchema}NCName" minOccurs="0" form="unqualified"/>
 *                             &lt;element name="identifikatorBudova" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mistnostiInfo"
})
@XmlRootElement(name = "getMistnostiInfoResponse")
public class GetMistnostiInfoResponse {

    @XmlElement(required = true)
    protected GetMistnostiInfoResponse.MistnostiInfo mistnostiInfo;

    /**
     * Gets the value of the mistnostiInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GetMistnostiInfoResponse.MistnostiInfo }
     *     
     */
    public GetMistnostiInfoResponse.MistnostiInfo getMistnostiInfo() {
        return mistnostiInfo;
    }

    /**
     * Sets the value of the mistnostiInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMistnostiInfoResponse.MistnostiInfo }
     *     
     */
    public void setMistnostiInfo(GetMistnostiInfoResponse.MistnostiInfo value) {
        this.mistnostiInfo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mistnostInfo" maxOccurs="unbounded" form="unqualified">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="zkrBudovy" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
     *                   &lt;element name="cisloMistnosti" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *                   &lt;element name="katedra" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
     *                   &lt;element name="pracoviste" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *                   &lt;element name="typCiselne" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
     *                   &lt;element name="typ" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
     *                   &lt;element name="kapacita" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
     *                   &lt;element name="spolecnyFond" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
     *                   &lt;element name="provozOd" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
     *                   &lt;element name="provozDo" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="poznamka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="plocha" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="dvereCislo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="podlazi" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
     *                   &lt;element name="obec" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
     *                   &lt;element name="ulice" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *                   &lt;element name="cisloPopisne" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="adresaBudovy" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *                   &lt;element name="urlMistnost" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="urlBudova" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="identifikatorMistnost" type="{http://www.w3.org/2001/XMLSchema}NCName" minOccurs="0" form="unqualified"/>
     *                   &lt;element name="identifikatorBudova" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mistnostInfo"
    })
    public static class MistnostiInfo {

        @XmlElement(required = true)
        protected List<GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo> mistnostInfo;

        /**
         * Gets the value of the mistnostInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mistnostInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMistnostInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo }
         * 
         * 
         */
        public List<GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo> getMistnostInfo() {
            if (mistnostInfo == null) {
                mistnostInfo = new ArrayList<GetMistnostiInfoResponse.MistnostiInfo.MistnostInfo>();
            }
            return this.mistnostInfo;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="zkrBudovy" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
         *         &lt;element name="cisloMistnosti" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
         *         &lt;element name="katedra" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
         *         &lt;element name="pracoviste" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
         *         &lt;element name="typCiselne" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
         *         &lt;element name="typ" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
         *         &lt;element name="kapacita" type="{http://www.w3.org/2001/XMLSchema}integer" form="unqualified"/>
         *         &lt;element name="spolecnyFond" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
         *         &lt;element name="provozOd" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
         *         &lt;element name="provozDo" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
         *         &lt;element name="poznamka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
         *         &lt;element name="plocha" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0" form="unqualified"/>
         *         &lt;element name="dvereCislo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
         *         &lt;element name="podlazi" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" form="unqualified"/>
         *         &lt;element name="obec" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
         *         &lt;element name="ulice" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
         *         &lt;element name="cisloPopisne" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
         *         &lt;element name="adresaBudovy" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
         *         &lt;element name="urlMistnost" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
         *         &lt;element name="urlBudova" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0" form="unqualified"/>
         *         &lt;element name="identifikatorMistnost" type="{http://www.w3.org/2001/XMLSchema}NCName" minOccurs="0" form="unqualified"/>
         *         &lt;element name="identifikatorBudova" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0" form="unqualified"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "zkrBudovy",
            "cisloMistnosti",
            "katedra",
            "pracoviste",
            "typCiselne",
            "typ",
            "kapacita",
            "spolecnyFond",
            "provozOd",
            "provozDo",
            "poznamka",
            "plocha",
            "dvereCislo",
            "podlazi",
            "obec",
            "ulice",
            "cisloPopisne",
            "adresaBudovy",
            "urlMistnost",
            "urlBudova",
            "identifikatorMistnost",
            "identifikatorBudova"
        })
        public static class MistnostInfo {

            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String zkrBudovy;
            @XmlElement(required = true)
            protected String cisloMistnosti;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String katedra;
            @XmlElement(required = true)
            protected String pracoviste;
            @XmlElement(required = true)
            protected BigInteger typCiselne;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String typ;
            @XmlElement(required = true)
            protected BigInteger kapacita;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String spolecnyFond;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String provozOd;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String provozDo;
            protected String poznamka;
            protected BigDecimal plocha;
            protected String dvereCislo;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String podlazi;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String obec;
            @XmlElement(required = true)
            protected String ulice;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String cisloPopisne;
            @XmlElement(required = true)
            protected String adresaBudovy;
            @XmlSchemaType(name = "anyURI")
            protected String urlMistnost;
            @XmlSchemaType(name = "anyURI")
            protected String urlBudova;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String identifikatorMistnost;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String identifikatorBudova;

            /**
             * Gets the value of the zkrBudovy property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZkrBudovy() {
                return zkrBudovy;
            }

            /**
             * Sets the value of the zkrBudovy property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZkrBudovy(String value) {
                this.zkrBudovy = value;
            }

            /**
             * Gets the value of the cisloMistnosti property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCisloMistnosti() {
                return cisloMistnosti;
            }

            /**
             * Sets the value of the cisloMistnosti property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCisloMistnosti(String value) {
                this.cisloMistnosti = value;
            }

            /**
             * Gets the value of the katedra property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKatedra() {
                return katedra;
            }

            /**
             * Sets the value of the katedra property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKatedra(String value) {
                this.katedra = value;
            }

            /**
             * Gets the value of the pracoviste property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPracoviste() {
                return pracoviste;
            }

            /**
             * Sets the value of the pracoviste property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPracoviste(String value) {
                this.pracoviste = value;
            }

            /**
             * Gets the value of the typCiselne property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTypCiselne() {
                return typCiselne;
            }

            /**
             * Sets the value of the typCiselne property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTypCiselne(BigInteger value) {
                this.typCiselne = value;
            }

            /**
             * Gets the value of the typ property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTyp() {
                return typ;
            }

            /**
             * Sets the value of the typ property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTyp(String value) {
                this.typ = value;
            }

            /**
             * Gets the value of the kapacita property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getKapacita() {
                return kapacita;
            }

            /**
             * Sets the value of the kapacita property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setKapacita(BigInteger value) {
                this.kapacita = value;
            }

            /**
             * Gets the value of the spolecnyFond property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSpolecnyFond() {
                return spolecnyFond;
            }

            /**
             * Sets the value of the spolecnyFond property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSpolecnyFond(String value) {
                this.spolecnyFond = value;
            }

            /**
             * Gets the value of the provozOd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProvozOd() {
                return provozOd;
            }

            /**
             * Sets the value of the provozOd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProvozOd(String value) {
                this.provozOd = value;
            }

            /**
             * Gets the value of the provozDo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProvozDo() {
                return provozDo;
            }

            /**
             * Sets the value of the provozDo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProvozDo(String value) {
                this.provozDo = value;
            }

            /**
             * Gets the value of the poznamka property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPoznamka() {
                return poznamka;
            }

            /**
             * Sets the value of the poznamka property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPoznamka(String value) {
                this.poznamka = value;
            }

            /**
             * Gets the value of the plocha property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPlocha() {
                return plocha;
            }

            /**
             * Sets the value of the plocha property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPlocha(BigDecimal value) {
                this.plocha = value;
            }

            /**
             * Gets the value of the dvereCislo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDvereCislo() {
                return dvereCislo;
            }

            /**
             * Sets the value of the dvereCislo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDvereCislo(String value) {
                this.dvereCislo = value;
            }

            /**
             * Gets the value of the podlazi property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPodlazi() {
                return podlazi;
            }

            /**
             * Sets the value of the podlazi property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPodlazi(String value) {
                this.podlazi = value;
            }

            /**
             * Gets the value of the obec property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObec() {
                return obec;
            }

            /**
             * Sets the value of the obec property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObec(String value) {
                this.obec = value;
            }

            /**
             * Gets the value of the ulice property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUlice() {
                return ulice;
            }

            /**
             * Sets the value of the ulice property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUlice(String value) {
                this.ulice = value;
            }

            /**
             * Gets the value of the cisloPopisne property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCisloPopisne() {
                return cisloPopisne;
            }

            /**
             * Sets the value of the cisloPopisne property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCisloPopisne(String value) {
                this.cisloPopisne = value;
            }

            /**
             * Gets the value of the adresaBudovy property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAdresaBudovy() {
                return adresaBudovy;
            }

            /**
             * Sets the value of the adresaBudovy property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAdresaBudovy(String value) {
                this.adresaBudovy = value;
            }

            /**
             * Gets the value of the urlMistnost property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrlMistnost() {
                return urlMistnost;
            }

            /**
             * Sets the value of the urlMistnost property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrlMistnost(String value) {
                this.urlMistnost = value;
            }

            /**
             * Gets the value of the urlBudova property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrlBudova() {
                return urlBudova;
            }

            /**
             * Sets the value of the urlBudova property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrlBudova(String value) {
                this.urlBudova = value;
            }

            /**
             * Gets the value of the identifikatorMistnost property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifikatorMistnost() {
                return identifikatorMistnost;
            }

            /**
             * Sets the value of the identifikatorMistnost property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifikatorMistnost(String value) {
                this.identifikatorMistnost = value;
            }

            /**
             * Gets the value of the identifikatorBudova property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifikatorBudova() {
                return identifikatorBudova;
            }

            /**
             * Sets the value of the identifikatorBudova property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifikatorBudova(String value) {
                this.identifikatorBudova = value;
            }

			@Override
			public String toString() {
				return "MistnostInfo [zkrBudovy=" + zkrBudovy + ", cisloMistnosti=" + cisloMistnosti + ", katedra="
						+ katedra + ", pracoviste=" + pracoviste + ", typCiselne=" + typCiselne + ", typ=" + typ
						+ ", kapacita=" + kapacita + ", spolecnyFond=" + spolecnyFond + ", provozOd=" + provozOd
						+ ", provozDo=" + provozDo + ", poznamka=" + poznamka + ", plocha=" + plocha + ", dvereCislo="
						+ dvereCislo + ", podlazi=" + podlazi + ", obec=" + obec + ", ulice=" + ulice
						+ ", cisloPopisne=" + cisloPopisne + ", adresaBudovy=" + adresaBudovy + ", urlMistnost="
						+ urlMistnost + ", urlBudova=" + urlBudova + ", identifikatorMistnost=" + identifikatorMistnost
						+ ", identifikatorBudova=" + identifikatorBudova + "]";
			}
            
        

        }

    }

}

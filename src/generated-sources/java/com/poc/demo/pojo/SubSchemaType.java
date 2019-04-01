//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.01 at 02:40:24 PM PDT 
//


package com.poc.demo.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subSchemaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subSchemaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="col" type="{}colSchemaType"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}commonAttrGroup"/>
 *       &lt;attribute name="sendQName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="allChangedRows" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="beforeValues" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="changedColsOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="hasLoadPhase" type="{}loadPhaseEnumType" default="none" />
 *       &lt;attribute name="dbServerType" use="required" type="{}dbServerTypeEnumType" />
 *       &lt;attribute name="dbRelease" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dbInstance" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="capRelease" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subSchemaType", propOrder = {
    "col"
})
public class SubSchemaType {

    @XmlElement(required = true)
    protected List<ColSchemaType> col;
    @XmlAttribute(name = "sendQName", required = true)
    protected String sendQName;
    @XmlAttribute(name = "allChangedRows")
    protected Boolean allChangedRows;
    @XmlAttribute(name = "beforeValues")
    protected Boolean beforeValues;
    @XmlAttribute(name = "changedColsOnly")
    protected Boolean changedColsOnly;
    @XmlAttribute(name = "hasLoadPhase")
    protected LoadPhaseEnumType hasLoadPhase;
    @XmlAttribute(name = "dbServerType", required = true)
    protected DbServerTypeEnumType dbServerType;
    @XmlAttribute(name = "dbRelease", required = true)
    protected String dbRelease;
    @XmlAttribute(name = "dbInstance", required = true)
    protected String dbInstance;
    @XmlAttribute(name = "capRelease", required = true)
    protected String capRelease;
    @XmlAttribute(name = "timestamp")
    protected String timestamp;
    @XmlAttribute(name = "subName", required = true)
    protected String subName;
    @XmlAttribute(name = "srcOwner", required = true)
    protected String srcOwner;
    @XmlAttribute(name = "srcName", required = true)
    protected String srcName;
    @XmlAttribute(name = "intentSEQ")
    protected String intentSEQ;

    /**
     * Gets the value of the col property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the col property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColSchemaType }
     * 
     * 
     */
    public List<ColSchemaType> getCol() {
        if (col == null) {
            col = new ArrayList<ColSchemaType>();
        }
        return this.col;
    }

    /**
     * Gets the value of the sendQName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendQName() {
        return sendQName;
    }

    /**
     * Sets the value of the sendQName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendQName(String value) {
        this.sendQName = value;
    }

    /**
     * Gets the value of the allChangedRows property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAllChangedRows() {
        if (allChangedRows == null) {
            return false;
        } else {
            return allChangedRows;
        }
    }

    /**
     * Sets the value of the allChangedRows property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllChangedRows(Boolean value) {
        this.allChangedRows = value;
    }

    /**
     * Gets the value of the beforeValues property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBeforeValues() {
        if (beforeValues == null) {
            return false;
        } else {
            return beforeValues;
        }
    }

    /**
     * Sets the value of the beforeValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBeforeValues(Boolean value) {
        this.beforeValues = value;
    }

    /**
     * Gets the value of the changedColsOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isChangedColsOnly() {
        if (changedColsOnly == null) {
            return true;
        } else {
            return changedColsOnly;
        }
    }

    /**
     * Sets the value of the changedColsOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangedColsOnly(Boolean value) {
        this.changedColsOnly = value;
    }

    /**
     * Gets the value of the hasLoadPhase property.
     * 
     * @return
     *     possible object is
     *     {@link LoadPhaseEnumType }
     *     
     */
    public LoadPhaseEnumType getHasLoadPhase() {
        if (hasLoadPhase == null) {
            return LoadPhaseEnumType.NONE;
        } else {
            return hasLoadPhase;
        }
    }

    /**
     * Sets the value of the hasLoadPhase property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadPhaseEnumType }
     *     
     */
    public void setHasLoadPhase(LoadPhaseEnumType value) {
        this.hasLoadPhase = value;
    }

    /**
     * Gets the value of the dbServerType property.
     * 
     * @return
     *     possible object is
     *     {@link DbServerTypeEnumType }
     *     
     */
    public DbServerTypeEnumType getDbServerType() {
        return dbServerType;
    }

    /**
     * Sets the value of the dbServerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DbServerTypeEnumType }
     *     
     */
    public void setDbServerType(DbServerTypeEnumType value) {
        this.dbServerType = value;
    }

    /**
     * Gets the value of the dbRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbRelease() {
        return dbRelease;
    }

    /**
     * Sets the value of the dbRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbRelease(String value) {
        this.dbRelease = value;
    }

    /**
     * Gets the value of the dbInstance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbInstance() {
        return dbInstance;
    }

    /**
     * Sets the value of the dbInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbInstance(String value) {
        this.dbInstance = value;
    }

    /**
     * Gets the value of the capRelease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapRelease() {
        return capRelease;
    }

    /**
     * Sets the value of the capRelease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapRelease(String value) {
        this.capRelease = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the subName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubName() {
        return subName;
    }

    /**
     * Sets the value of the subName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubName(String value) {
        this.subName = value;
    }

    /**
     * Gets the value of the srcOwner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcOwner() {
        return srcOwner;
    }

    /**
     * Sets the value of the srcOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcOwner(String value) {
        this.srcOwner = value;
    }

    /**
     * Gets the value of the srcName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcName() {
        return srcName;
    }

    /**
     * Sets the value of the srcName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcName(String value) {
        this.srcName = value;
    }

    /**
     * Gets the value of the intentSEQ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntentSEQ() {
        return intentSEQ;
    }

    /**
     * Sets the value of the intentSEQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntentSEQ(String value) {
        this.intentSEQ = value;
    }

}
package tn.suptech.tn.tp03.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_ADDRESS")
public class Address {
    @Id
    private Long AID;
    private String COUNTRY;
    private String STREET;
    private String ZIPCODE;

    public Address() {
    }

    public Address(Long AID, String COUNTRY, String STREET, String ZIPCODE) {
        this.AID = AID;
        this.COUNTRY = COUNTRY;
        this.STREET = STREET;
        this.ZIPCODE = ZIPCODE;
    }

    public Long getAID() {
        return AID;
    }

    public void setAID(Long AID) {
        this.AID = AID;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public String getZIPCODE() {
        return ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;

    }

    @Override
    public String toString() {
        return "Address{" +
                "AID=" + AID +
                ", COUNTRY='" + COUNTRY + '\'' +
                ", STREET='" + STREET + '\'' +
                ", ZIPCODE='" + ZIPCODE + '\'' +
                '}';
    }
}

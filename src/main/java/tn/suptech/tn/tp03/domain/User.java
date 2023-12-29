package tn.suptech.tn.tp03.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long ID;

    @Column(name="FIRSTNAME")
    private String FIRSTNAME;

    @Column(name="LASTNAME")
    private String LASTNAME;

    @Column(name="USERNAME")
    private String USERNAME;

    @Column(name="PASSWORD")
    private String PASSWORD;

    @OneToOne
    @JoinColumn(name="ua_fk",referencedColumnName = "AID")
    private Address address;

    @ManyToMany
    @JoinTable(
            name="users_affected",
            joinColumns =@JoinColumn(name="user_id")
    )
    private List<Role> professions = new ArrayList<>();

    public User() {
    }


    public User(String FIRSTNAME, String LASTNAME, String USERNAME, String PASSWORD, Address address) {
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.address = address;

    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", FIRSTNAME='" + FIRSTNAME + '\'' +
                ", LASTNAME='" + LASTNAME + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", address=" + address +

                '}';
    }
}

package tn.suptech.tn.tp03.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="T_ROLE")
public class Role {
    @Id
    private Long RID;
    private String NAME;
    private String DESCRIPTION;

    @ManyToMany(mappedBy = "professions")
    private List<User> userAffected = new ArrayList<>();
    public Role() {
    }

    public Role(Long RID, String NAME, String DESCRIPTION) {
        this.RID = RID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
    }

    public void ajouterUserAffected(User user){
        userAffected.add(user);
    }


    public Long getRID() {
        return RID;
    }

    public void setRID(Long RID) {
        this.RID = RID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Role{" +
                "RID=" + RID +
                ", NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}

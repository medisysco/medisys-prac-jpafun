package my.com.medisys.prac.javaee.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "marital_status")
public class MaritalStatus implements Serializable {

    private static final long serialVersionUID = -2317459317638748639L;

    @Id
    @Column(name = "marital_status_code")
    private String maritalStatusCode;

    @Column(name = "marital_status_name")
    private String maritalStatusName;

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getMaritalStatusName() {
        return maritalStatusName;
    }

    public void setMaritalStatusName(String maritalStatusName) {
        this.maritalStatusName = maritalStatusName;
    }

}

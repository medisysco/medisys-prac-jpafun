package my.com.medisys.prac.jpafun.entity;

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
@Table(name = "nationalities")
public class Nationality implements Serializable {

    private static final long serialVersionUID = 237496785266728983L;

    @Id
    @Column(name = "nationality_code")
    private String nationalityCode;

    @Column(name = "nationality_name")
    private String nationalityName;

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

}

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
@Table(name = "genders")
@Access(AccessType.FIELD)
public class Gender implements Serializable {

    private static final long serialVersionUID = -5447498767683263429L;

    @Id
    @Column(name = "gender_code")
    private String genderCode;

    @Column(name = "gender_name")
    private String genderName;

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

}

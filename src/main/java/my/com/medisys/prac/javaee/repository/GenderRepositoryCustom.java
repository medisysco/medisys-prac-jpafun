package my.com.medisys.prac.javaee.repository;

import my.com.medisys.prac.javaee.entity.Gender;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface GenderRepositoryCustom {
    Gender findByGenderCode(String genderCode);
}

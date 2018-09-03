package my.com.medisys.prac.jpafun.repository;

import my.com.medisys.prac.jpafun.entity.Gender;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface GenderRepositoryCustom {
    Gender findByGenderCode(String genderCode);
}

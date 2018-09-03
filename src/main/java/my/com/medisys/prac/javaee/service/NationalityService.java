package my.com.medisys.prac.javaee.service;

import java.util.List;

import my.com.medisys.prac.javaee.entity.Nationality;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface NationalityService {
    List<Nationality> findAll();
    Nationality findByNationalityCode(String nationalityCode);
}

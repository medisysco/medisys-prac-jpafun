package my.com.medisys.prac.javaee.service;

import java.util.List;

import my.com.medisys.prac.javaee.entity.MaritalStatus;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public interface MaritalStatusService {
    List<MaritalStatus> findAll();
    MaritalStatus findByMaritalStatusCode(String maritalStatusCode);
}

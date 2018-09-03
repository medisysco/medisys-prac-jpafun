package my.com.medisys.prac.jpafun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.com.medisys.prac.jpafun.entity.Nationality;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Repository
public interface NationalityRepository extends JpaRepository<Nationality, String> {
    Nationality findByNationalityCode(String nationalityCode);
}

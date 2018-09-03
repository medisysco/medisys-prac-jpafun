package my.com.medisys.prac.jpafun.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import my.com.medisys.prac.jpafun.entity.Gender;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Repository
@Transactional(readOnly = true)
public class GenderRepositoryImpl implements GenderRepositoryCustom {

    private static final Logger log = LoggerFactory.getLogger(GenderRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        String jql = "SELECT g FROM Gender g WHERE g.genderCode = :genderCode";
        Query qry = em.createQuery(jql);
        qry.setParameter("genderCode", genderCode);
        return (Gender) qry.getSingleResult();
    }*/

    @Override
    public Gender findByGenderCode(String genderCode) {
        Query qry = em.createNamedQuery("Gender.findByGenderCode");
        qry.setParameter("genderCode", genderCode);
        Gender gender = null;
        try {
            gender = (Gender) qry.getSingleResult();
        }catch(NoResultException e) {
            log.warn(e.getMessage());
        }
        return gender;
    }

    /*@Override
    public Gender findByGenderCode(String genderCode) {
        return em.find(Gender.class, genderCode);
    }*/

}

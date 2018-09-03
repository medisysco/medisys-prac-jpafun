package my.com.medisys.prac.javaee.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import my.com.medisys.prac.javaee.entity.MaritalStatus;


/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Repository
@Transactional(readOnly = true)
public class MaritalStatusRepositoryImpl implements MaritalStatusRepositoryCustom {

    private static final Logger log = LoggerFactory.getLogger(MaritalStatusRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;

    /*@Override
    public MaritalStatus findByMaritalStatusCode(String genderCode) {
        String jql = "SELECT ms FROM MaritalStatus ms WHERE ms.maritalStatusCode = :maritalStatusCode";
        Query qry = em.createQuery(jql);
        qry.setParameter("maritalStatusCode", maritalStatusCode);
        return (MaritalStatus) qry.getSingleResult();
    }*/

    @Override
    public MaritalStatus findByMaritalStatusCode(String maritalStatusCode) {
        Query qry = em.createNamedQuery("MaritalStatus.findByMaritalStatusCode");
        qry.setParameter("maritalStatusCode", maritalStatusCode);
        MaritalStatus maritalStatus = null;
        try {
        maritalStatus = (MaritalStatus) qry.getSingleResult();
        }catch(NoResultException e) {
            log.warn(e.getMessage());
        }
        return maritalStatus;
    }

    /*@Override
    public MaritalStatus findByMaritalStatusCode(String maritalStatusCode) {
        return em.find(MaritalStatus.class, maritalStatusCode);
    }*/

}

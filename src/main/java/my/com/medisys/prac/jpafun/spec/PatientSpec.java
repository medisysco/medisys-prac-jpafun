package my.com.medisys.prac.jpafun.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import my.com.medisys.prac.jpafun.entity.Patient;

public class PatientSpec implements Specification<Patient> {

    private Patient example;

    public PatientSpec(Patient example) {
        this.example = example;
    }

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(example.getFirstName())) {
            predicates.add(cb.like(cb.lower(root.get("firstName")), example.getFirstName().toLowerCase() + "%"));
        }
        if (!StringUtils.isEmpty(example.getLastName())) {
            predicates.add(cb.like(cb.lower(root.get("lastName")), example.getLastName().toLowerCase() + "%"));
        }
        if (!ObjectUtils.isEmpty(example.getPatientNo())) {
            predicates.add(cb.equal(root.get("patientNo"), example.getPatientNo()));
        }
        if (!ObjectUtils.isEmpty(example.getBirthDate())) {
            predicates.add(cb.equal(root.get("birthDate"), example.getBirthDate()));
        }
        return and(predicates, cb);
    }

    private Predicate and(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }

    public static PatientSpec of(Patient example) {
        return new PatientSpec(example);
    }
}

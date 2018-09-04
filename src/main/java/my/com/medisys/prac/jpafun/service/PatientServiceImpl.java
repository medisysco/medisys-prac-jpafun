package my.com.medisys.prac.jpafun.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import my.com.medisys.prac.jpafun.entity.Patient;
import my.com.medisys.prac.jpafun.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    PatientRepository repo;

    public List<Patient> findAll() {
        List<Patient> patients = repo.findAll();
        return patients;
    }

    public List<Patient> findAll(Patient patient) {
        //PatientSpec example = PatientSpec.of(patient);
        Example<Patient> example = Example.of(patient);
        List<Patient> patients = repo.findAll(example);
        return patients;
    }

    public Patient findByPatientNo(int patientNo) {
        Patient patient = repo.findOne(patientNo);
        return patient;
    }

    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    public Patient update(int patientNo, Patient patient) {
        Patient exist = repo.findOne(patientNo);
        if (!ObjectUtils.isEmpty(exist)) {
            exist.setBirthDate(patient.getBirthDate());
            exist.setFathersName(patient.getFathersName());
            exist.setFirstName(patient.getFirstName());
            exist.setGenderCode(patient.getGenderCode());
            exist.setLastName(patient.getLastName());
            exist.setMaritalStatusCode(patient.getMaritalStatusCode());
            exist.setMothersName(patient.getMothersName());
            exist.setNationalityCode(patient.getNationalityCode());
            exist.setPhoneNumber(patient.getPhoneNumber());
            repo.save(exist);
        }
        return exist;
    }

    public Patient delete(int patientNo) {
        Patient patient = repo.findOne(patientNo);
        if (!ObjectUtils.isEmpty(patient)) {
            repo.delete(patient);
        }
        return patient;
    }

}

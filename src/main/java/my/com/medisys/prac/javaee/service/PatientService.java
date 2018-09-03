package my.com.medisys.prac.javaee.service;

import java.util.List;

import my.com.medisys.prac.javaee.entity.Patient;

public interface PatientService {
    List<Patient> findAll();
    List<Patient> findAll(Patient patient);
    Patient findByPatientNo(int patientNo);
    Patient save(Patient patient);
    Patient update(int patientNo, Patient patient);
    Patient delete(int patientNo);
}

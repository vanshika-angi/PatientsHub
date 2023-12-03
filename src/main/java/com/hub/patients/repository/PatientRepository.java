package com.hub.patients.repository;

import com.hub.patients.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findByPatientName(String patientName);

}

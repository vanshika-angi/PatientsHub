package com.hub.patients.service;

import com.hub.patients.model.Patient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PatientService {
    public String createPatientDetails(Patient patient);
    public String updatePatientDetails(Patient patient);
    public Patient getPatientDetails(String patientId);
    public String deletePatientDetails(String patientId);
    public List<Patient> getAllPatient();
    public List<Patient> getByPatientName(String patientName);



}
